package com.example.quickstartlessons.module.albums.popuphomework.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quickstartlessons.module.albums.popuphomework.data.ItemsData

class ItemsViewModel: ViewModel() {
    private val _itemList = MutableLiveData<List<ItemsData>>()
    val itemsList: LiveData<List<ItemsData>>
        get() = itemsList

    fun addItems(itemsData: ItemsData){
        if (_itemList.value != null){
            val list = _itemList.value?.toMutableList()
            list.let {
                it?.add(itemsData)
                _itemList.value = it
            }
        }else {
            _itemList.value = listOf(itemsData)
        }
    }
}