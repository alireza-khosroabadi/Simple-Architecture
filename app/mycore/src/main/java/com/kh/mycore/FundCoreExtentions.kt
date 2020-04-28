package com.kh.mycore

import com.kh.mycore.FundCore
import com.kh.mycore.ServiceType
import com.kh.mycore.service.account.AccountServiceImpl
import com.kh.mycore.service.branch.BranchServiceImpl
import com.kh.mycore.service.versionControl.VersionControlServiceImp

fun <T> FundCore.provideCoreService(serviceType: ServiceType): T {
    return when (serviceType) {
        ServiceType.BRANCH_SERVICE -> BranchServiceImpl()
        ServiceType.ACCOUNT_SERVICE -> AccountServiceImpl()
        ServiceType.VERSION_CONTROL -> VersionControlServiceImp()
    } as T
}