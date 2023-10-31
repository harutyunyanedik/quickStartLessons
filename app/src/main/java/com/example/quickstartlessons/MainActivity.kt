package com.example.quickstartlessons

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.quickstartlessons.android.getUserNameFromPref
import com.example.quickstartlessons.android.putUserNameToPref
import com.example.quickstartlessons.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val resultLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) {
//        binding.image.setImageURI(it)
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.button2.setOnClickListener {
            binding.webView.settings.javaScriptEnabled = true
            binding.webView.webViewClient = WebViewClient()
            binding.webView.loadUrl("https://www.youtube.com/")
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            when (requestCode) {
                ACTIVITY_TWO_REQUEST_CODE -> {
                    val resultValue = data?.getStringExtra("key")
                    binding.editText.setText(resultValue)
                }

                IMAGE_CHOOSER_REQUEST_CODE -> {

                }
            }
        }
    }

    private fun shareIntent() {
        val intent = Intent(Intent.ACTION_SEND)
        val shareBody = "Here is the share content body"
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, shareBody)
        startActivity(Intent.createChooser(intent, "share"))
    }

    private fun emailIntent() {
        val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:to@gmail.com"))
        startActivity(emailIntent)
    }

    private fun phoneCallWithPermissionIntent() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE), 100)
        } else {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:" + "+37499308898")
            startActivity(intent)
        }
    }

    private fun phoneCallIntent() {
        val intent = Intent(Intent.ACTION_CALL)
        intent.data = Uri.parse("tel:" + "+37499308898")
        startActivity(intent)
    }

    private fun imageChooser() {
        val i = Intent()
        i.type = "image/*"
        i.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(i, "Select Picture"), IMAGE_CHOOSER_REQUEST_CODE)
    }

    private fun openBrowser() {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"))
        startActivity(browserIntent)
    }

    companion object {
        const val ACTIVITY_EXTRA_KEY = "activity_extra_key"
        const val ACTIVITY_TWO_REQUEST_CODE = 200
        const val IMAGE_CHOOSER_REQUEST_CODE = 11
    }
}