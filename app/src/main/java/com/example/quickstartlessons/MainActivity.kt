package com.example.quickstartlessons

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var textView: EditText
    private lateinit var button_zero: Button
    private lateinit var button_clear: Button
    private lateinit var button_divide: Button
    private lateinit var button_multiply: Button
    private lateinit var button_add: Button
    private lateinit var button_minus: Button
    private lateinit var button_point: Button
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_calculator)

        textView = findViewById(R.id.textView)
        button_zero = findViewById(R.id.button_zero)
        button_clear = findViewById(R.id.button_clear)
        button_divide = findViewById(R.id.button_divide)
        button_multiply = findViewById(R.id.button_multiply)
        button_add = findViewById(R.id.button_add)
        button_minus = findViewById(R.id.button_minus)
        button_point = findViewById(R.id.button_point)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)

        textView.setOnClickListener {
            Log.d(TAG, "button1 clicked")
            Toast.makeText(this,"Please enter the value",Toast.LENGTH_SHORT).show()
        }
    }
    companion object {
        private const val TAG: String = "main_activity_tag"
    }









    }


