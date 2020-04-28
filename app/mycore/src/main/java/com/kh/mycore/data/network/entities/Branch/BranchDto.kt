package com.kh.mycore.data.network.entities.Branch

import com.google.gson.annotations.SerializedName
import com.kh.mycore.data.network.entities.Dto

data class BranchDto(
    @SerializedName("branchId") val id:Int,
    @SerializedName("branchCode") val code:String,
    @SerializedName("branchName") val name:String,
    @SerializedName("branchPic") val pic:String
):Dto