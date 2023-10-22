package com.example.quickstartlessons

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var button1: Button
    lateinit var button2: Button
    lateinit var button3: Button
    lateinit var button4: Button
    lateinit var button5: Button
    lateinit var button6: Button
    lateinit var button7: Button
    lateinit var button8: Button
    lateinit var button9: Button
    lateinit var button0: Button
    lateinit var buttonEquals: Button
    lateinit var buttonMinus: Button
    lateinit var buttonPlus: Button
    lateinit var buttonMultiple: Button
    lateinit var buttonDivide: Button
    lateinit var buttonC: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_calculator)
        textView.findViewById(R.id.math_operetion)
        button0.findViewById(R.id.button0)
        button1.findViewById(R.id.button1)
        button2.findViewById(R.id.button0)
        button3.findViewById(R.id.button0)
        button4.findViewById(R.id.button0)
        button5.findViewById(R.id.button0)
        button6.findViewById(R.id.button0)
        button7.findViewById(R.id.button0)
        button8.findViewById(R.id.button0)
        button9.findViewById(R.id.button0)
        buttonEquals.findViewById(R.id.equals)
        buttonMinus.findViewById(R.id.minus)
        buttonMultiple.findViewById(R.id.multiple)
        buttonPlus.findViewById(R.id.plus)
        buttonDivide.findViewById(R.id.divide)
        buttonC.findViewById(R.id.buttonC)

        button0.setOnClickListener {
            textView.text = (textView.text.toString() + "0")
        }
        button1.setOnClickListener {
            textView.text = (textView.text.toString() + "1")
        }
        button2.setOnClickListener {
            textView.text = (textView.text.toString() + "2")
        }
        button3.setOnClickListener {
            textView.text = (textView.text.toString() + "3")
        }
        button4.setOnClickListener {
            textView.text = (textView.text.toString() + "4")
        }
        button5.setOnClickListener {
            textView.text = (textView.text.toString() + "5")
        }
        button6.setOnClickListener {
            textView.text = (textView.text.toString() + "6")
        }
        button7.setOnClickListener {
            textView.text = (textView.text.toString() + "7")
        }
        button8.setOnClickListener {
            textView.text = (textView.text.toString() + "8")
        }
        button9.setOnClickListener {
            textView.text = (textView.text.toString() + "9")
        }
        buttonPlus.setOnClickListener {
            textView.text = (textView.text.toString() + "+")
        }
        buttonMinus.setOnClickListener {
            textView.text = (textView.text.toString() + "-")
        }
        buttonMultiple.setOnClickListener {
            textView.text = (textView.text.toString() + "*")
        }
        buttonDivide.setOnClickListener {
            textView.text = (textView.text.toString() + "/")
        }
        buttonEquals.setOnClickListener {
            textView.text = (textView.text.toString() + "=")
        }
        buttonC.setOnClickListener {
            var str: String = textView.text.toString()
            if (!str.equals("")) {
                str = str.substring(0, str.length - 1)
                textView.text = str
            }
        }
        buttonMinus.setOnClickListener {
            val str: String = textView.text.toString()
            if (!str.get(index = str.length - 1).equals("-")) {
                textView.text = (textView.text.toString() + "-")
            }
        }
        buttonMultiple.setOnClickListener {
            val str: String = textView.text.toString()
            if (!str.get(index = str.length - 1).equals("*")) {
                textView.text = (textView.text.toString() + "*")
            }
        }
    }
}


