package com.eslam.entity.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.eslam.entity.entities.CategoryEntity

/** A data access object about the [CategoryEntity] entity. */
@Dao
interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategoriesList(movies: List<CategoryEntity>)


    @Query("SELECT * FROM CategoryEntity WHERE id = :id_")
    fun getCategory(id_: Int): CategoryEntity

    @Query("SELECT * FROM CategoryEntity ")
    fun getCategoriesList(): LiveData<List<CategoryEntity>>

}
