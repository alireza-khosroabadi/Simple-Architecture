package com.kh.mycore.data.repository.branch

import com.kh.mycore.data.database.entities.branch.BranchData
import com.kh.mycore.data.network.entities.BaseResponse
import io.reactivex.Flowable
import io.reactivex.Single

internal interface BranchRepository {

    /**
     * fetch all branch from Branch table
     *
     * @return List Of [BranchData]
     */
    fun loadLocalBranchesList(): Single<List<BranchData>>

    /**
     * load branches from Server
     *
     * @param isTestServer Branch for test server and primary server is different
     * @return
     */
    fun loadBranchList(isTestServer: Boolean): Single<BaseResponse<List<BranchData>>>
}