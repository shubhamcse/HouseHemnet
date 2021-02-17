package com.assignment.househemnet.properties

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assignment.househemnet.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListViewModel(private val listRepository: ListRepository) : ViewModel() {

    private val propertyItems = MutableLiveData<Resource<PropertyItems>>()

    init {
        fetchProperties()
    }

    private fun fetchProperties() {
        viewModelScope.launch(Dispatchers.IO) {
            propertyItems.postValue(listRepository.getProperties())
        }
    }

    fun getProperties(): LiveData<Resource<PropertyItems>> {
        return propertyItems
    }
}
