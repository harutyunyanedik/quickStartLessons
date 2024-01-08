package com.example.quickstartlessons.module.albums.newpresenttation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

 class ViewModel : ViewModel() {

     val listLiveData: MutableLiveData<List<Model>> by lazy {
         MutableLiveData<List<Model>>()
     }
}
