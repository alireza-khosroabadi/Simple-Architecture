package com.kh.mycore.data.database.dao

import com.kh.mycore.FundCore
import com.kh.mycore.data.database.entities.Data
import com.kh.mycore.data.database.entities.branch.BranchData

internal class EntityDaoFactory {
    companion object{
        fun <T> factory(className: String?):T{
            return when(className){
                BranchData::class.simpleName-> FundCore.dataBase.branchDataDao()
                else -> null
            } as T
        }
    }
}