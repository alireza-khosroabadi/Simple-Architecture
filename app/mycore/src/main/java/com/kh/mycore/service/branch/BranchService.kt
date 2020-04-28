package com.kh.mycore.service.branch

import com.kh.mycore.service.ServiceResult
import com.kh.mycore.service.CoreService
import io.reactivex.Observable

abstract class BranchService : CoreService() {

    /**
     * load branch from server, if branch loaded success then update Branch table in local database
     *
     * @return
     */
    abstract fun loadBranches(): Observable<ServiceResult<List<BranchEntity>>>

    /**
     *
     *
     * @return
     */
    abstract fun getBranchList(): Observable<ServiceResult<List<BranchEntity>>>

    abstract fun getCurrentBranch(): BranchEntity?

    abstract fun setCurrentBranch(currentBranch: BranchEntity)
}