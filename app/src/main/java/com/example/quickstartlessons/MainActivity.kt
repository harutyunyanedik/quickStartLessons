package com.example.quickstartlessons

import android.os.Bundle
import android.util.Log
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


    private var number1 = 0.0
    private var number2 = 0.0
    private var result = 0.0
    private var lastOperator: Operator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculator_layout)
        initViews()
        initListeners()

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

    private fun initListeners() {
        button0.setOnClickListener {
            if (lastOperator == Operator.EQUAL) {
                textViewScreen.text = "0"
            }
            printText(getString(R.string.button_0))
        }
        button1.setOnClickListener {
            if (lastOperator == Operator.EQUAL) {
                textViewScreen.text = "0"
                lastOperator = null
            }
            printText(getString(R.string.button_1))
        }
        button2.setOnClickListener {
            if (lastOperator == Operator.EQUAL) {
                textViewScreen.text = "0"
                lastOperator = null
            }
            printText(getString(R.string.button_2))
        }
        button3.setOnClickListener {
            if (lastOperator == Operator.EQUAL) {
                textViewScreen.text = "0"
                lastOperator = null
            }
            printText(getString(R.string.button_3))
        }
        button4.setOnClickListener {
            if (lastOperator == Operator.EQUAL) {
                textViewScreen.text = "0"
                lastOperator = null
            }
            printText(getString(R.string.button_4))
        }
        button5.setOnClickListener {
            if (lastOperator == Operator.EQUAL) {
                textViewScreen.text = "0"
                lastOperator = null
            }
            printText(getString(R.string.button_5))
        }
        button6.setOnClickListener {
            if (lastOperator == Operator.EQUAL) {
                textViewScreen.text = "0"
                lastOperator = null
            }
            printText(getString(R.string.button_6))
        }
        button7.setOnClickListener {
            if (lastOperator == Operator.EQUAL) {
                textViewScreen.text = "0"
                lastOperator = null
            }
            printText(getString(R.string.button_7))
        }
        button8.setOnClickListener {
            if (lastOperator == Operator.EQUAL) {
                textViewScreen.text = "0"
                lastOperator = null
            }
            printText(getString(R.string.button_8))
        }
        button9.setOnClickListener {
            if (lastOperator == Operator.EQUAL) {
                textViewScreen.text = "0"
                lastOperator = null
            }
            printText(getString(R.string.button_9))
        }
        buttonDot.setOnClickListener {
            if (lastOperator == Operator.EQUAL) {
                textViewScreen.text = "0"
                lastOperator = null

            }
            printText(getString(R.string.button_dot))
        }
        buttonSum.setOnClickListener {
            printText(Operator.PLUS.str)
            checkResult(Operator.PLUS.str)
            lastOperator = Operator.PLUS
        }
        buttonMinus.setOnClickListener {
            printText(Operator.MINUS.str)
            checkResult(Operator.MINUS.str)
            lastOperator = Operator.MINUS
        }
        buttonMultiplication.setOnClickListener {
            printText(Operator.MULTIPLICATION.str)
            checkResult(Operator.MULTIPLICATION.str)
            lastOperator = Operator.MULTIPLICATION
        }

        buttonDivision.setOnClickListener {
            printText(Operator.DIVISION.str)
            checkResult(Operator.DIVISION.str)
            lastOperator = Operator.DIVISION
        }
        buttonC.setOnClickListener {
            textViewScreen.text = "0"
            number1 = 0.0
            number2 = 0.0
            result = 0.0
            lastOperator = null
        }
        buttonEqual.setOnClickListener {
            printText(Operator.EQUAL.str)
            checkResult("")
            lastOperator = Operator.EQUAL
        }
        buttonBack.setOnClickListener {
            val number = textViewScreen.text.toString()
            if (number.contains("+") ||
                number.contains("-") ||
                number.contains("*") ||
                number.contains("/")
            ) {
                lastOperator = null
            }
            if (number != "0") {
                if (number.length == 1) {
                    textViewScreen.text = "0"
                } else {
                    textViewScreen.text = number.substring(0, number.length - 1)
                }
            }
        }
    }

    private fun printText(text: String) {
        val screenText = textViewScreen.text.toString()
        if (screenText == "0" && text != ".") {
            textViewScreen.text = text
        } else if (screenText.contains("+") ||
            screenText.contains("-") ||
            screenText.contains("*") ||
            screenText.contains("/")
        ) {
            textViewScreen.text = text
        } else {
            textViewScreen.text = screenText + text
        }
    }

    private fun checkResult(operator: String) {
        try {
            with(textViewScreen.text.toString()) {
                when (lastOperator) {
                    Operator.PLUS -> {
                        number2 = substring(0, length - 1).toDouble()
                        result = number1 + number2
                        number1 = result
                        if (result % 1 == 0.0) {
                            textViewScreen.text = "${result.toInt()}$operator"
                        } else {
                            textViewScreen.text = "$result$operator"
                        }

                    }

                    Operator.MINUS -> {
                        number2 = substring(0, length - 1).toDouble()
                        result = number1 - number2
                        number1 = result
                        if (result % 1 == 0.0) {
                            textViewScreen.text = "${result.toInt()}$operator"
                        } else {
                            textViewScreen.text = "$result$operator"
                        }
                    }

                    Operator.MULTIPLICATION -> {
                        number2 = substring(0, length - 1).toDouble()
                        result = number1 * number2
                        number1 = result
                        if (result % 1 == 0.0) {
                            textViewScreen.text = "${result.toInt()}$operator"
                        } else {
                            textViewScreen.text = "$result$operator"
                        }
                    }

                    Operator.DIVISION -> {
                        try {
                            number2 = substring(0, length - 1).toDouble()
                            result = number1 / number2
                            number1 = result
                            if (result % 1 == 0.0) {
                                textViewScreen.text = "${result.toInt()}$operator"
                            } else {
                                textViewScreen.text = "$result$operator"
                            }
                        } catch (e: Exception){
                            textViewScreen.text = getString(R.string.cannot_divide_by_zero)
                            number1 = 0.0
                            number2 = 0.0
                            lastOperator = null
                        }


                    }

                    else -> {
                        if (this == "+" || this == "-" || this == "*" || this == "/" || this == "=") {
                            textViewScreen.text = "0$operator"
                        } else {
                            number1 = substring(0, length - 1).toDouble()
                            if (number1 % 1 == 0.0) {
                                textViewScreen.text = "${number1.toInt()}$operator"
                            } else {
                                textViewScreen.text = "$number1$operator"
                            }
                        }
                    }
                }
            }

        }
        catch (e: Exception) {
            if (number1 % 1 == 0.0) {
                textViewScreen.text = "${number1.toInt()}$operator"
            } else {
                textViewScreen.text = "$number1$operator"
            }

        }

    }

}