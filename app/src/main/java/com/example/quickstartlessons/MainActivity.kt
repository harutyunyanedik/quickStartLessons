package com.example.quickstartlessons

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.quickstartlessons.databinding.ActivityMainBinding
import com.example.quickstartlessons.module.albums.newpresenttation.HeaderPageFragment
import com.example.quickstartlessons.module.albums.newpresenttation.Model
import com.example.quickstartlessons.module.albums.newpresenttation.PopUpFragment
import com.example.quickstartlessons.module.albums.newpresenttation.ViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences
    private val items: MutableList<Model> = mutableListOf()
    private val viewModel:ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        sharedPreferences = getSharedPreferences("main_act_shared_pref", MODE_PRIVATE)
        val fragment = HeaderPageFragment.newInstance {
            showPopUp()
                    }
        supportFragmentManager.beginTransaction().add(R.id.activity_container, fragment).commit()
    }

    private fun showPopUp() {
        val showPopUp = PopUpFragment { itemTitle, itemMassage ->
            val sharedTitles =  sharedPreferences.edit()
            sharedTitles.putString("title_key",itemTitle)
            sharedTitles.apply()
            val sharedMassages = sharedPreferences.edit()
            sharedMassages.putString("massages_key",itemMassage)
            sharedMassages.apply()
           // putTitleToPref(itemTitle).toString()
           // putMassageToPref(itemMassage).toString()

            val t = sharedPreferences.getString("title_key","").toString()
            val m = sharedPreferences.getString("massages_key","").toString()
           // val t = getTitleFromPref().toString()
           // val m = getMassageFromPref().toString()
            if ((itemTitle == t && t.isNotEmpty()) && (itemMassage == m && m.isNotEmpty())) {
                Toast.makeText(this, "Your title and massage is copy", Toast.LENGTH_LONG).show()
            }
            items.add(Model(t, m))
            viewModel.listLiveData.value = items

            Toast.makeText(this, "Your title  is $t", Toast.LENGTH_LONG).show()
            Toast.makeText(this, "Your  massage is $m", Toast.LENGTH_LONG).show()

        }
        showPopUp.show(supportFragmentManager, "showPopUp")
    }
}




