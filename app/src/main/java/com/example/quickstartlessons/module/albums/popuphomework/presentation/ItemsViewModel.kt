package com.example.quickstartlessons.module.albums.popuphomework.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quickstartlessons.module.albums.popuphomework.data.ItemsData

class ItemsViewModel : ViewModel() {
    private val _itemsList = MutableLiveData<List<ItemsAdapter>>()
    val itemsList: LiveData<List<ItemsAdapter>>
        get() = _itemsList

    fun add(itemsData: ItemsData) {
        if (_itemsList.value == null){
            _itemsList.value = listOf(itemsData)
        }else {
            val list = _itemsList.value?.toMutableList()
            list?.add(itemsData)
            _itemsList.value = list?.toList()
        }
    }
}