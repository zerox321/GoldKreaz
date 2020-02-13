package com.eslam.entity.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.eslam.entity.Keyword

/** KeywordListConverter is a converter class for type converting a entity. */
open class KeywordListConverter {

  @TypeConverter
  fun fromString(value: String): List<Keyword>? {
    val listType = object : TypeToken<List<Keyword>>() {}.type
    return Gson().fromJson<List<Keyword>>(value, listType)
  }

  @TypeConverter
  fun fromList(list: List<Keyword>?): String {
    val gson = Gson()
    return gson.toJson(list)
  }
}
