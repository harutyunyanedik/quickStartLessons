package com.example.quickstartlessons

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import com.example.quickstartlessons.databinding.ActivityMainBinding
import com.example.quickstartlessons.module.albums.pager_homework.AlbumsHeaderFragment
import com.example.quickstartlessons.module.albums.pager_homework.BaseFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        addFragment(AlbumsHeaderFragment.newInstance())
        isNetWorkAvailable()
    }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .add(R.id.container, fragment, fragment::class.java.simpleName)
            .addToBackStack(fragment::class.java.simpleName).commit()
    }

    private fun isNetWorkAvailable() {
        QuickStartApplication.networkStateLiveData.observe(this) {
            if (it) {
                Toast.makeText(this, "Internet is connected", Toast.LENGTH_SHORT).show()
                addLoader(false)
            } else {
                Toast.makeText(this, "No internet connection", Toast.LENGTH_SHORT).show()
              removeLoader(true)
            }
        }
    }
    companion object {
        var loaderLiveData: MutableLiveData<Boolean> = MutableLiveData()
        private fun addLoader(isShoLoader: Boolean) {
            MainActivity.loaderLiveData.postValue(true)
        }

        private fun removeLoader(isShoLoader: Boolean) {
            MainActivity.loaderLiveData.postValue(false)
        }
    }
}