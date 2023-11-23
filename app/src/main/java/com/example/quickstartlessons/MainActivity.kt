package com.example.quickstartlessons

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.quickstartlessons.databinding.ActivityMainBinding

import java.lang.Exception


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var num1 = 0.0
    private var num2 = 0.0
    private var result = 0.0
    private var lastOperator: Operator? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initOnClickLiseners()

    }
    private fun initOnClickLiseners(){
        binding.btn0.setOnClickListener {

            if (lastOperator == Operator.EQUAL) {
                binding.mathOperation.text = "0"
            }
            setTextField("0")

        }
        binding.btn1.setOnClickListener {

            if (lastOperator == Operator.EQUAL) {
                binding.mathOperation.text = "0"
                lastOperator = null
            }
            setTextField("1")
        }
        binding.btn2.setOnClickListener {

            if (lastOperator == Operator.EQUAL) {
                binding.mathOperation.text = "0"
                lastOperator = null
            }
            setTextField("2")
        }
        binding.btn3.setOnClickListener {
            setTextField("3")
            if (lastOperator == Operator.EQUAL) {
                binding.mathOperation.text = "0"
                lastOperator = null
            }
        }
        binding.btn4.setOnClickListener {

            if (lastOperator == Operator.EQUAL) {
                binding.mathOperation.text = "0"
                lastOperator = null
            }
            setTextField("4")
        }
        binding.btn5.setOnClickListener {

            if (lastOperator == Operator.EQUAL) {
                binding.mathOperation.text = "0"
                lastOperator = null
            }
            setTextField("5")
        }
        binding.btn6.setOnClickListener {

            if (lastOperator == Operator.EQUAL) {
                binding.mathOperation.text = "0"
                lastOperator = null
            }
            setTextField("6")
        }

        binding.btn7.setOnClickListener {

            if (lastOperator == Operator.EQUAL) {
                binding.mathOperation.text = "0"
                lastOperator = null
            }
            setTextField("7")
        }
        binding.btn8.setOnClickListener {

            if (lastOperator == Operator.EQUAL) {
                binding.mathOperation.text = "0"
                lastOperator = null
            }
            setTextField("8")
        }
        binding.btn9.setOnClickListener {

            if (lastOperator == Operator.EQUAL) {
                binding.mathOperation.text = "0"
                lastOperator = null
            }
            setTextField("9")
        }

        binding.btnPlus.setOnClickListener {
            setTextField(Operator.PLUS.string)
            setResultField(Operator.PLUS.string)
            lastOperator = Operator.PLUS
        }
        binding.btnMinus.setOnClickListener {
            setTextField(Operator.MINUS.string)
            setResultField(Operator.MINUS.string)
            lastOperator = Operator.MINUS
        }
        binding.btnMultiplier.setOnClickListener {
            setTextField(Operator.MULTIPLIER.string)
            setResultField(Operator.MULTIPLIER.string)
            lastOperator = Operator.MULTIPLIER
        }
        binding.btnDivision.setOnClickListener {
            setTextField(Operator.DIVISION.string)
            setResultField(Operator.DIVISION.string)
            lastOperator = Operator.DIVISION
        }


        binding.btnAC.setOnClickListener {
            binding.mathOperation.text = "0"
            binding.mathOperationResult.text = ""
            num1 = 0.0
            num2 = 0.0
            result = 0.0
            lastOperator = null
        }

        binding.btnBack.setOnClickListener {
            val str = binding.mathOperation.text.toString()
            if (str.contains("+") ||
                str.contains("-") ||
                str.contains("*") ||
                str.contains("/")
            ) {
                lastOperator = null
            }
            if (str.isNotEmpty()) {
                binding.mathOperation.text = str.substring(0, str.length - 1)
            } else {
                binding.mathOperation.text = "0"
            }

        }

        binding.btnEqual.setOnClickListener {
            setTextField(Operator.EQUAL.string)
            setResultField("")
            lastOperator = Operator.EQUAL
        }
    }

    fun setTextField(str: String) {
        val setText = binding.mathOperation.text.toString()
        if (setText == "0") {
            binding.mathOperation.text = str
        } else if (setText.contains("+") || setText.contains("-") || setText.contains(
                "*"
            ) || setText.contains("/")
        ) {
            binding.mathOperation.text = str
        } else {
            binding.mathOperation.text = setText + str
        }
    }

   private fun setResultField(operator: String) {
        try {
            with(binding.mathOperation.text.toString()) {
                when (lastOperator) {
                    Operator.PLUS -> {
                        num2 = substring(0, length - 1).toDouble()
                        result = num1 + num2
                        num1 = result
                        if (result % 1 == 0.0) {
                            binding.mathOperationResult.text = "${result.toInt()}$operator"
                        } else {
                            binding.mathOperationResult.text = "${result}$operator"
                        }
                    }

                    Operator.MINUS -> {
                        num2 = substring(0, length - 1).toDouble()
                        result = num1 - num2
                        num1 = result
                        if (result % 1 == 0.0) {
                            binding.mathOperationResult.text = "${result.toInt()}$operator"
                        } else {
                            binding.mathOperationResult.text = "${result}$operator"
                        }
                    }

                    Operator.MULTIPLIER -> {
                        num2 = substring(0, length - 1).toDouble()
                        result = num1 * num2
                        num1 = result
                        if (result % 1 == 0.0) {
                            binding.mathOperationResult.text = "${result.toInt()}$operator"
                        } else {
                            binding.mathOperationResult.text = "${result}$operator"
                        }
                    }

                    Operator.DIVISION -> {
                        try {
                            num2 = substring(0, length - 1).toDouble()
                            result = num1 / num2
                            num1 = result
                            if (result % 1 == 0.0) {
                                binding.mathOperationResult.text = "${result}$operator"
                            }
                        } catch (e: Exception) {
                            binding.mathOperationResult.text = "Error"
                            num1 = 0.0
                            num2 = 0.0
                            lastOperator = null
                        }
                    }

                    else -> {
                        if (this == "+" || this == "-" || this == "*" || this == "/" || this == "=") {
                            binding.mathOperation.text = "0"
                        } else {
                            num1 = substring(0, length - 1).toDouble()
                            if (num1 % 1 == 0.0) {
                                binding.mathOperationResult.text = "${num1.toInt()}$operator"
                            } else {
                                binding.mathOperationResult.text = "${num1}$operator"
                            }
                        }
                    }
                }

            }
        } catch (e: Exception) {
            if (num1 % 1 == 0.0) {
               binding.mathOperationResult.text = "${num1.toInt()}$operator"
            } else {
                binding.mathOperationResult.text = "$num1$operator"
            }
        }
    }
}