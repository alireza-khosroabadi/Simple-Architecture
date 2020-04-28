package com.kh.mycore.data.database.entities.branch

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kh.mycore.data.database.entities.Data


@Entity
data class BranchData(
    @PrimaryKey var branchCode: String,
    var branchId: Int,
    var branchName: String,
    var branchPic: String?,
    var favorite: Boolean = false,
    var attempt: Int = 0,
    var ordering: Int = 0,
    var isActive: Boolean = false
):Data{
    constructor() : this("",0,"","")
}