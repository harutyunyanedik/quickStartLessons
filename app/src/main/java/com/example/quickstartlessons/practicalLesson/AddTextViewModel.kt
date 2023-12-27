package com.example.quickstartlessons.practicalLesson

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddTextViewModel:ViewModel() {

   private val _liveDataAddText = MutableLiveData<List<AddTextData>>()
    val liveDataAddText:LiveData<List<AddTextData>>
        get()=_liveDataAddText

    fun addText(text:AddTextData){
            val list=_liveDataAddText.value?.toMutableList()
            list?.add(text)
            _liveDataAddText.value=list?.toList()
        }
    }

