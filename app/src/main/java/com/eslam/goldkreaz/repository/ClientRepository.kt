package com.eslam.goldkreaz.repository

import com.eslam.entity.database.CategoryDao
import com.eslam.entity.entities.CategoryEntity
import com.eslam.entity.response.CategoryData
import com.eslam.network.client.CategoryClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

class ClientRepository constructor(
    private val categoryClient: CategoryClient,
    private val movieDao: CategoryDao
) : Repository {

    override var isLoading: Boolean = false

    init {
        Timber.d("Injection ClientRepository")
    }

    private fun saveCategoryList(responseData: List<CategoryData?>?) =
        responseData?.map {
            CategoryEntity(
                id = it!!.id!!,
                name = it.name,
                total_items = it.totalItems,
                icon = it.icon
            )

        }

    suspend fun loadCategoryList() = withContext(Dispatchers.IO) {

        Timber.e("loadCategoryList")

        val categories = movieDao.getCategoriesList()

        categories.apply { }


    }
    suspend fun fetchCategoryList(error: (String) -> Unit) = withContext(Dispatchers.IO) {

        Timber.e("fetchCategoryList")


        isLoading = true
        try {

            val response = categoryClient.fetchCategories().await()

            if (response.type == "success") {
                val categoryEntityList = saveCategoryList(response.data)

                movieDao.insertCategoriesList(categoryEntityList!!)
//                    liveData.postValue(categoryEntityList)

                error(" Done ")

            }
        } catch (ex: Throwable) {

            error(" Throwable ")
        }
        isLoading = false



    }


}
