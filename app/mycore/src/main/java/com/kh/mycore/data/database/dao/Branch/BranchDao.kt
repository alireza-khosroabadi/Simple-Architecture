package com.kh.mycore.data.database.dao.Branch

import androidx.room.Dao
import androidx.room.Query
import com.kh.mycore.data.database.dao.BaseDao
import com.kh.mycore.data.database.entities.branch.BranchData
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Branch Dto is abstract class for android Room library to implement database queries
 */
@Dao
abstract class BranchDao : BaseDao<BranchData> {

    /**
     * find branch with branch code
     *
     * @param branchCode is unique property and primary key for Branch table
     * @return return [BranchData] when exist in table or null if dose not exist
     */
    @Query("SELECT * FROM branchData WHERE branchCode=:branchCode")
    abstract fun findBranchByCode(branchCode: String): BranchData

    /**
     * return all branches in Branch table
     * @return return empty list if Branch table is empty or return list of [BranchData]
     */
    @Query("SELECT * FROM branchData WHERE ordering != -1 ORDER BY favorite DESC ,ordering DESC")
    abstract fun loadAllBranchesAsSingle(): Single<List<BranchData>>

    @Query("SELECT * FROM branchData WHERE ordering != -1 ORDER BY favorite DESC ,ordering DESC")
    abstract fun loadAllBranches(): List<BranchData>

    @Query("SELECT * FROM branchData WHERE branchCode=:branchCode")
    abstract fun loadBranchesWithBranchCode(branchCode: String) :List<BranchData>

    /**
     * use for indicate a branch exist in Branch table or not
     *
     * @param branchCode [BranchData] unique id in table
     * @return number of branch with branchCode in table return 0 if cannot find any branch whit branchCode in table
     */
    @Query("SELECT COUNT(branchCode) FROM branchData WHERE branchCode=:branchCode")
    abstract fun branchCount(branchCode: String): Int

    @Query("UPDATE branchData SET ordering = -1 WHERE branchCode NOT IN (:branchCodeLine)")
    abstract fun updateNotExistBranchOrder(branchCodeLine: String)

    @Query("UPDATE branchData Set ordering = 1 WHERE branchCode in (:branchCodeLine) AND ordering = -1")
    abstract fun updateExistBranchOrder(branchCodeLine: String)

    @Query("UPDATE branchData SET branchCode =:newBranchCode WHERE branchCode=:oldBranchCode")
    abstract fun updateBranchCodes(oldBranchCode:String, newBranchCode:String)
}