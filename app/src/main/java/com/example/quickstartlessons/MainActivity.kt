package com.example.quickstartlessons

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var textViewScreen: TextView
    private lateinit var button0: Button
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var buttonDot: Button
    private lateinit var buttonEqual: Button
    private lateinit var buttonSum: Button
    private lateinit var buttonMinus: Button
    private lateinit var buttonMultiplication: Button
    private lateinit var buttonDivision: Button
    private lateinit var buttonBack: Button
    private lateinit var buttonC: Button

    private var screenText = StringBuilder("")
    private var number1 = ""
    private var number2 = ""
    private var result = 0.0
    private var lastOperator = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculator_layout)
        initViews()
        button0.setOnClickListener {
            printText(it)
        }
        button1.setOnClickListener {
            printText(it)
        }
        button2.setOnClickListener {
            printText(it)
        }
        button3.setOnClickListener {
            printText(it)
        }
        button4.setOnClickListener {
            printText(it)
        }
        button5.setOnClickListener {
            printText(it)
        }
        button6.setOnClickListener {
            printText(it)
        }
        button7.setOnClickListener {
            printText(it)
        }
        button8.setOnClickListener {
            printText(it)
        }
        button9.setOnClickListener {
            printText(it)
        }
        buttonDot.setOnClickListener {
            printText(it)
        }
        buttonSum.setOnClickListener {
            printText(it)
            checkResult(it)
            lastOperator = "+"
        }
        buttonMinus.setOnClickListener {
            printText(it)
            checkResult(it)
            lastOperator = "-"
        }
        buttonMultiplication.setOnClickListener {
            printText(it)
            checkResult(it)
            lastOperator = "*"
        }

        buttonDivision.setOnClickListener {
            printText(it)
            checkResult(it)
            lastOperator = "/"
        }
        buttonC.setOnClickListener {
            screenText.clear()
            number1 = ""
            number2 = ""
            result = 0.0
            lastOperator = ""
            textViewScreen.text = result.toString()
        }
        buttonEqual.setOnClickListener {
            printText(it)
            checkResult(it)
            number1 = ""
            number2 = ""
            lastOperator = ""
        }
        buttonBack.setOnClickListener {
            if (screenText.isNotBlank()){
                screenText = screenText.deleteCharAt(screenText.length - 1)
                textViewScreen.text = screenText
            }
        }
    }

    private fun initViews() {
        textViewScreen = findViewById(R.id.textViewScreen)
        button0 = findViewById(R.id.button0)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        buttonDot = findViewById(R.id.buttonDot)
        buttonEqual = findViewById(R.id.buttonEqual)
        buttonSum = findViewById(R.id.buttonSum)
        buttonMinus = findViewById(R.id.buttonMinus)
        buttonMultiplication = findViewById(R.id.buttonMultiplication)
        buttonDivision = findViewById(R.id.buttonDivision)
        buttonBack = findViewById(R.id.buttonBack)
        buttonC = findViewById(R.id.buttonC)
    }

    private fun printText(view: View) {
        val button = view as Button
        val text = button.text.toString()
        screenText.append(text)
        textViewScreen.text = screenText


    }

    private fun checkResult(view: View) {
        val button = view as Button
        val operator = button.text.toString()
        try {
            with(screenText) {
                if (contains("+") || contains("-") || contains("*") || contains("/") || contains("=")) {
                    if (number1.isBlank()) {
                        number1 = deleteCharAt(toString().length - 1).toString()
                        clear()
                    } else {
                        number2 = deleteCharAt(toString().length - 1).toString()
                        clear()
                        when (lastOperator) {
                            "+" -> {
                                result = number1.toDouble() + number2.toDouble()
                                number1 = result.toString()
                                textViewScreen.text = "$number1$operator"
                            }

                            "-" -> {
                                result = number1.toDouble() - number2.toDouble()
                                number1 = result.toString()
                                textViewScreen.text = "$number1$operator"
                            }

                            "*" -> {
                                result = number1.toDouble() * number2.toDouble()
                                number1 = result.toString()
                                textViewScreen.text = "$number1$operator"
                            }

                            "/" -> {
                                try {
                                    result = number1.toDouble() / number2.toDouble()
                                    number1 = result.toString()
                                    textViewScreen.text = "$number1$operator"

                                } catch (e: Exception){
                                    Toast.makeText(
                                        this@MainActivity,
                                        e.toString(),
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }


                            }
                        }
                    }
                }
            }

        } catch (e: Exception){
            textViewScreen.text = "$number1$operator"
        }

    }

}