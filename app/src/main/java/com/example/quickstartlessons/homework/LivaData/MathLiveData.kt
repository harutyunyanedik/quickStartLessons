package com.example.quickstartlessons.homework.LivaData

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.time.format.TextStyle
import java.util.concurrent.atomic.AtomicBoolean

class SingleLiveEvent<String> :  MutableLiveData<String>(){

    private val pending = AtomicBoolean(false)
    private val observers = mutableSetOf<Observer<String>>()

    private val internalObserver = Observer<String> { it ->
        if (pending.compareAndSet(true, false)) {
            observers.forEach { observer ->
                observer.onChanged(it)
            }
        }
    }



}

