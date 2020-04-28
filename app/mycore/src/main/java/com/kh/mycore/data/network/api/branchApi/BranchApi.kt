package com.kh.mycore.data.network.service.branchService

import com.kh.mycore.data.network.entities.BaseResponse
import com.kh.mycore.data.network.entities.Branch.BranchDto
import io.reactivex.Single

interface BranchApi {
    fun getFunds(testServer: Boolean) : Single<BaseResponse<List<BranchDto>>>
}