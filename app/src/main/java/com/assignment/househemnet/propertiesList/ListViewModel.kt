package com.assignment.househemnet.propertiesList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assignment.househemnet.utils.Resource
import com.assignment.househemnet.utils.Status
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListViewModel(private val listRepository: ListRepository) : ViewModel() {

    private val propertyItems = MutableLiveData<Resource<PropertyItems>>()

    init {
        fetchProperties()
    }

    private fun fetchProperties() {
        viewModelScope.launch(Dispatchers.IO) {
            when(listRepository.getProperties().status){
                Status.LOADING -> {
                    propertyItems.postValue(Resource.loading(null))
                }
                Status.SUCCESS -> {
                    propertyItems.postValue(listRepository.getProperties())
                }
                Status.ERROR -> {
                    propertyItems.postValue(Resource.error(null, listRepository.getProperties().message))
                }
            }

        }
    }

    fun getProperties(): LiveData<Resource<PropertyItems>> {
        return propertyItems
    }
}
