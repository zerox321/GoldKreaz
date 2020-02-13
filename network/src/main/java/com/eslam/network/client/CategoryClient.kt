package com.eslam.network.client

import com.eslam.network.service.CategoryService

class CategoryClient(private val service: CategoryService) {

    fun fetchCategories() =
        service.getCategoriesAsync("get", "categories")


}
