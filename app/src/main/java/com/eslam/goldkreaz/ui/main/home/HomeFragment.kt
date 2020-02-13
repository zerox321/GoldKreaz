package com.eslam.goldkreaz.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.observe
import com.eslam.goldkreaz.R
import com.eslam.goldkreaz.base.DatabindingFragment
import com.eslam.goldkreaz.databinding.FragmentHomeBinding
import org.koin.android.viewmodel.ext.android.viewModel
import timber.log.Timber

class HomeFragment : DatabindingFragment() {

    private val homeViewModel by viewModel<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding<FragmentHomeBinding>(
            inflater, R.layout.fragment_home, container
        ).apply {
            viewModel = this@HomeFragment.homeViewModel
            lifecycleOwner = this@HomeFragment
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeMessages()
        observeData()
    }

    private fun observeData() =
        this.homeViewModel.categoryLiveData.observe(viewLifecycleOwner) {
            this.homeViewModel.adapter.submitList(it)
        }

    private fun observeMessages() =
        this.homeViewModel.toastLiveData.observe(viewLifecycleOwner) {
            Timber.e(it)
        }
}