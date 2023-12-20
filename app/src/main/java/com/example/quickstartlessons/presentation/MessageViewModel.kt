package com.example.quickstartlessons.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MessageViewModel: ViewModel() {
    val message = MutableLiveData<String>()
}