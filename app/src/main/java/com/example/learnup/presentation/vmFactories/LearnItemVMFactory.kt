package com.example.learnup.presentation.vmFactories

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.learnup.data.LearnRepositoryImpl
import com.example.learnup.domain.*
import com.example.learnup.presentation.viewModels.LearnItemViewModel

class LearnItemVMFactory(application: Application):ViewModelProvider.Factory {
    private val repository = LearnRepositoryImpl.getInstance(application)
    private val getAllLearnItemsUseCase  by lazy(LazyThreadSafetyMode.NONE) {
        GetAllLearnItemsUseCase(repository)
    }

    private val getLearnItemByIdUseCase  by lazy(LazyThreadSafetyMode.NONE) {
        GetLearnItemByIdUseCase(repository)
    }

    private val getLearnItemIdUseCase  by lazy(LazyThreadSafetyMode.NONE) {
        GetLearnItemIdUseCase(repository)
    }

    private val appSettingsHolder  by lazy(LazyThreadSafetyMode.NONE) {
        AppSettingsHolder(repository)
    }
    private val deleteLearnItemByIdUseCase  by lazy(LazyThreadSafetyMode.NONE) {
        DeleteLearnItemByIdUseCase(repository)
    }


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LearnItemViewModel(getAllLearnItemsUseCase,getLearnItemByIdUseCase,getLearnItemIdUseCase,appSettingsHolder,deleteLearnItemByIdUseCase) as T
    }
}