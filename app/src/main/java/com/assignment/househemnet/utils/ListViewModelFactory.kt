package com.assignment.househemnet.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.assignment.househemnet.properties.ListRepository
import com.assignment.househemnet.properties.ListViewModel

class ListViewModelFactory (private val listRepository: ListRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListViewModel::class.java)) {
            return ListViewModel(listRepository) as T
        }
        throw IllegalArgumentException("Unknown VM name")
    }

}
