package com.kh.mycore.data.extentions

import com.kh.mycore.data.database.entities.branch.BranchData
import com.kh.mycore.data.network.entities.Branch.BranchDto
import com.kh.mycore.service.branch.BranchEntity


/**
 * Extensions function to convert [BranchDto] to [BranchData]
 *
 */
internal fun BranchDto.map() =
    BranchData(
        branchId = id,
        branchCode = code,
        branchName = name,
        branchPic = pic
    )

/**
 * Extensions function to convert [BranchData] to [BranchEntity]
 *
 */
internal fun BranchData.map() =
    BranchEntity(
        branchCode = branchCode,
        branchId = branchId,
        branchName = branchName,
        branchPic = branchPic,
        favorite = favorite,
        attempt = attempt,
        ordering = ordering,
        isActive = isActive
    )

/**
 * Extensions function to convert [BranchEntity] to [BranchData]
 *
 */
internal fun BranchEntity.map() =
    BranchData(
        branchCode = branchCode,
        branchId = branchId,
        branchName = branchName,
        branchPic = branchPic,
        favorite = favorite,
        attempt = attempt,
        ordering = ordering,
        isActive = isActive
    )

/**
 * update [BranchData] primary properties from another [BranchData]
 *
 */
internal fun BranchData.updateFromOldData(oldBranchData: BranchData){
    branchCode = oldBranchData.branchCode
    branchId = oldBranchData.branchId
    branchName = oldBranchData.branchName
    branchPic = oldBranchData.branchPic
}