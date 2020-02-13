package com.eslam.goldkreaz.ui.main.home

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.eslam.entity.entities.CategoryEntity
import com.eslam.goldkreaz.base.LiveCoroutinesViewModel
import com.eslam.goldkreaz.repository.ClientRepository
import kotlinx.coroutines.launch


class HomeViewModel
constructor(
    private val repo: ClientRepository
) : LiveCoroutinesViewModel(), CategoryAdapter.ClickListener {


    val adapter: CategoryAdapter = CategoryAdapter(this)

    val toastLiveData: MutableLiveData<String> = MutableLiveData()

    val categoryLiveData: LiveData<List<CategoryEntity>> by lazy {
        launchOnViewModelScope {
            this.repo.loadCategoryList()
        }
    }

    init {
        viewModelScope.launch {
            repo.fetchCategoryList {
                toastLiveData.postValue(it)
            }
        }
    }


    fun isLoading() = this.repo.isLoading

    override fun onRowClick(v: View, category: CategoryEntity) {
    }
}
