package com.kh.mycore.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kh.mycore.data.database.dao.Branch.BranchDao
import com.kh.mycore.data.database.entities.branch.BranchData

@Database(
    entities=[BranchData::class],
    version = 1
)
abstract class Database:RoomDatabase() {

    abstract fun branchDataDao():BranchDao
}