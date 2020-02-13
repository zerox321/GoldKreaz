
package com.eslam.entity.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.eslam.entity.entities.CategoryEntity

@Database(entities = [CategoryEntity::class],
  version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
  abstract fun categoryDao(): CategoryDao
}
