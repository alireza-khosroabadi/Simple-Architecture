package com.kh.mycore

/**
 *
 * ServiceType Used for @FundCore.provideCoreService(serviceType: ServiceType)
 * all FundCore Service most have an enum type and to when for create instance in @see provideCoreService() method
 *
 * */
enum class ServiceType {
    BRANCH_SERVICE,
    ACCOUNT_SERVICE,
    VERSION_CONTROL;
}