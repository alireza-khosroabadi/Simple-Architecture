package com.kh.mycore.service.branch

import com.kh.mycore.data.database.entities.branch.BranchData

internal object BranchServiceDataHolder {

    //val branchList:List<BranchEntity> = mutableListOf()
    /**
     * hold current logged in user Branch
     */
    var currentBranch : BranchData?=null;
}