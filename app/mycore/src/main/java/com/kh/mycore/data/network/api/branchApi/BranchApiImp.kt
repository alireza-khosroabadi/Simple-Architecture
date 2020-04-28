package com.kh.mycore.data.network.service.branchService

import com.kh.mycore.data.network.entities.BaseResponse
import com.kh.mycore.data.network.entities.Branch.BranchDto
import com.kh.mycore.data.network.ApiService
import io.reactivex.Single

internal class BranchApiImp (val apiService: ApiService):BranchApi {
    override fun getFunds(testServer: Boolean): Single<BaseResponse<List<BranchDto>>> = apiService.getFunds(testServer)
}