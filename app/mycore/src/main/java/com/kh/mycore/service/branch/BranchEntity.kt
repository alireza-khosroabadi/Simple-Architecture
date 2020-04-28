package com.kh.mycore.service.branch

data class BranchEntity( var branchCode: String,
                         val branchId: Int,
                         val branchName: String,
                         val branchPic: String?,
                         val favorite: Boolean = false,
                         val attempt: Int = 0,
                         val ordering: Int = 0,
                         val isActive: Boolean = false)