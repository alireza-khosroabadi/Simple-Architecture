package com.kh.mycore.data.database.service.branch

import com.kh.mycore.FundCore
import com.kh.mycore.data.database.dao.Branch.BranchDao
import com.kh.mycore.data.database.entities.branch.BranchData
import com.kh.mycore.data.extentions.updateFromOldData
import com.kh.mycore.service.ConfigStateHolder
import com.kh.mycore.service.branch.BranchServiceDataHolder
import io.reactivex.Single

/*
class BranchDataService (val database: Database) {

    private val branchDao = database.branchDataDao();
*/

/**
 *  a top function for insert and update branches received from server
 *  this function change branch code for one branch in test mode
 *
 *
 *  this function must refactor and optimize
 *
 * @param branchList new [BranchData] list from server
 */

internal fun List<BranchData>.saveBranch() {
    val branchDao = FundCore.getEntityDao<BranchDao>(BranchData::class.simpleName)
    var i = 0
    var branchCodeLine = ""
    when (ConfigStateHolder.isTestServer) {
        true -> {
            branchDao.updateBranchCodes("11049", "99898")
            BranchServiceDataHolder.currentBranch?.branchCode = "99898"
        }
        false -> branchDao.updateBranchCodes("99898", "11049")
    }
//    if (ConfigStateHolder.isTestServer) {
//        for (fund in this) {
//            if (fund.branchCode == "11049") {
//                fund.branchCode = "99898"
//                //val branch = branchDao.findBranchByCode("11049")
//                //branch?.let {
//                //   branchDao.delete(branch)
//                //  branch.branchCode = "99898"
//                // branchDao.insert(branch)
//            }
//        }
        // }
        branchDao.updateBranchCodes("11049", "99898")
        BranchServiceDataHolder.currentBranch?.branchCode = "99898"
        // BranchServiceDataHolder.currentBranch?.let {
        // val branch = BranchServiceDataHolder.currentBranch
        // branch?.branchCode = "99898"
        // BranchServiceDataHolder.currentBranch = branch
        //}
//    } else {
//        branchDao.updateBranchCodes("99898", "11049")
        //val branches: List<BranchData> = branchDao.loadBranchesWithBranchCode("99898")
        // for (fund in branches) {
        //    if (fund.branchCode == "99898") {
        //        fund.branchCode = "11049"
        //        val branch1 = branchDao.findBranchByCode("99898")
        //       branch1?.let {
        //           branchDao.delete(branch1)
        //           it.branchCode = "11049"
        //           branchDao.update(it)
        //       }
        //   }
        //   }
//    }
    this.map {
        it.branchCode = if (it.branchCode.equals("11049") || it.branchCode.equals("99898"))
            if (ConfigStateHolder.isTestServer)
                "99898"
            else
                "11049"
        else it.branchCode
        it
    }.forEach {
        val oldBranch = it.branchCode.findBranch()
        oldBranch?.updateFromOldData(it)
        branchDao.insert(oldBranch ?: it)
        if (branchDao.branchCount(it.branchCode) == 0) {
            branchCodeLine += it.branchCode
            if (i < this.size - 1) branchCodeLine += ","
            i++
        }
//        if (oldBranch != null) {
//            oldBranch.updateFromOldData(it)
//            branchDao.update(oldBranch)
//        } else {
//            branchDao.insert(it)
//        }
    }

//    for (fundBranch in this) {
//        //val oldBranch = branchDao.findBranchByCode(fundBranch.branchCode)
//        val oldBranch = fundBranch.branchCode.findBranch()
//        if (oldBranch != null) {
//            oldBranch.updateFromOldData(fundBranch)
//            branchDao.update(oldBranch)
//        } else {
//            branchDao.insert(fundBranch)
//        }
    /*  if (oldBranch != null) {
          oldBranch.updateDataFrom(fundBranch)
          branchDao.update(oldBranch)
      } else {
          branchDao.insert(branchMapper.map(fundBranch))
      }*/
    //  }


    //Remove fundBranch from list L


    //Remove fundBranch from list L
//    for (branch in this) {
//        if (branchDao.branchCount(branch.branchCode) == 0) {
//            branchCodeLine += branch.branchCode
//            if (i < this.size - 1) branchCodeLine += ","
//            i++
//        }
//    }
    //Set for every item in L: ordering = -1
    //Set for every item in L: ordering = -1
    if (branchCodeLine != "") {
        //Branch.executeQuery("update branch set ordering = -1 where branch_code not in (" + branchCodeLine + ")");
        branchDao.updateNotExistBranchOrder(branchCodeLine)
        //Branch.executeQuery("update branch set ordering = 1 where branch_code in (" + branchCodeLine + ") and ordering = -1");
        branchDao.updateExistBranchOrder(branchCodeLine)
    }
}


/**
 * fetch branches from Branch table
 *
 * @return list of [BranchData] if table is empty return empty list
 */
internal fun loadAllBranches(): Single<List<BranchData>> =
    FundCore.getEntityDao<BranchDao>(BranchData::class.simpleName).loadAllBranchesAsSingle()


internal fun String.findBranch(): BranchData? =
    FundCore.getEntityDao<BranchDao>(BranchData::class.simpleName).findBranchByCode(this)

//}