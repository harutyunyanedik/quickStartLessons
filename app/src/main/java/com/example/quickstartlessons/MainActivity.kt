package com.example.quickstartlessons

import android.annotation.SuppressLint
import android.media.TimedText
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.quickstartlessons.databinding.LayoutCalculateBinding
import java.lang.StringBuilder
import javax.xml.xpath.XPathExpression
import kotlin.concurrent.fixedRateTimer
import kotlin.math.min

class MainActivity : AppCompatActivity() {
    private lateinit var calculate: LayoutCalculateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        calculate = DataBindingUtil.setContentView(this, R.layout.layout_calculate)

    }
}
























