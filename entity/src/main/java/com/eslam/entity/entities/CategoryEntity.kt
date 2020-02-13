package com.eslam.entity.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class CategoryEntity(
    @PrimaryKey(autoGenerate = false) val id: String,
    val icon: String?,
    val name: String?,
    val total_items: String?
)
