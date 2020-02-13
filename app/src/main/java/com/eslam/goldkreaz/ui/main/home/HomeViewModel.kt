package com.eslam.goldkreaz.ui.main.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.eslam.entity.entities.CategoryEntity
import com.eslam.goldkreaz.base.LiveCoroutinesViewModel
import com.eslam.goldkreaz.repository.ClientRepository


class HomeViewModel
constructor(
    private val repo: ClientRepository
) : LiveCoroutinesViewModel() {


    val toastLiveData: MutableLiveData<String> = MutableLiveData()

    val categoryLiveData: LiveData<List<CategoryEntity>> by lazy {
        launchOnViewModelScope {
            this.repo.loadCategoryList {
                this.toastLiveData.postValue(it)
            }
        }
    }




    fun isLoading() = this.repo.isLoading
}
