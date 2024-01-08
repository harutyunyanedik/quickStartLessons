package com.example.quickstartlessons.module.albums.newpresenttation

import android.os.Parcel
import android.os.Parcelable
import androidx.lifecycle.LiveData

class SingleEventLiveData() :LiveData<Model>(), Parcelable {
    constructor(parcel: Parcel) : this() {

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SingleEventLiveData> {
        override fun createFromParcel(parcel: Parcel): SingleEventLiveData {
            return SingleEventLiveData(parcel)
        }

        override fun newArray(size: Int): Array<SingleEventLiveData?> {
            return arrayOfNulls(size)
        }
    }

}




