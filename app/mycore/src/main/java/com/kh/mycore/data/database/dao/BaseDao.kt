package com.kh.mycore.data.database.dao

import androidx.room.*

/**
 * all public CRUD queries defined and all Dao classes must inherit from this interface
 *
 * @param T indicate Room entity class, when Room implement Dao class use entity class type to create SQLite query
 */
@Dao
internal interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data:T)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(dataList:List<T>)

    @Update
    fun update(data: T)

    @Delete
    fun delete(data: T)

}