package com.kh.mycore.data.repository.branch

import com.kh.mycore.FundCore
import com.kh.mycore.data.database.entities.branch.BranchData
import com.kh.mycore.data.database.service.branch.loadAllBranches
import com.kh.mycore.data.database.service.branch.saveBranch
import com.kh.mycore.data.extentions.map
import com.kh.mycore.data.network.entities.BaseResponse
import com.kh.mycore.data.network.entities.Status.*
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.functions.Function

internal class BranchRepositoryImp :
    BranchRepository {

    override fun loadLocalBranchesList(): Single<List<BranchData>> = loadAllBranches()
    override fun loadBranchList(isTestServer: Boolean): Single<BaseResponse<List<BranchData>>> =
        FundCore.apiService.getFunds(isTestServer)
            .doOnError{
                it.printStackTrace()
            }
            .map {
                when (it.status) {
                    SUCCESS -> {
                        val data = BaseResponse.success(it.data!!.map { it.map() })
                        data?.data?.saveBranch()
                        data
                    }
                    NETWORK_ERROR -> BaseResponse.networkError(it.throwable)
                    REST_ERROR -> BaseResponse.restError(it.restError)
                }
            }
            .flatMap {
                when(it.status) {
                    SUCCESS -> loadAllBranches().map { BaseResponse.success(it) }
                    else -> Single.create {  it}
                }
            }
}