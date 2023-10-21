package com.example.quickstartlessons

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btn_0: Button
    private lateinit var btn_1: Button
    private lateinit var btn_2: Button
    private lateinit var btn_3: Button
    private lateinit var btn_4: Button
    private lateinit var btn_5: Button
    private lateinit var btn_6: Button
    private lateinit var btn_7: Button
    private lateinit var btn_8: Button
    private lateinit var btn_9: Button
    private lateinit var btn_plus: Button
    private lateinit var btn_minus: Button
    private lateinit var btn_drop: Button
    private lateinit var btn_multiply: Button
    private lateinit var btn_dot: Button
    private lateinit var btn_back: Button
    private lateinit var btn_equals: Button
    private lateinit var btn_result_text: Button
    private lateinit var btn_brackets: Button
    private lateinit var btn_brackets_close: Button
    private lateinit var btn_AC: Button

    private var currentOperand: Double = 0.0
    private var currentOperator: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_linear)
        operashion()
        btn_0.setOnClickListener {
            numberClick("0")
        }
        btn_1.setOnClickListener {
            numberClick("1")
        }
        btn_2.setOnClickListener {
            numberClick("2")
        }
        btn_3.setOnClickListener {
            numberClick("3")
        }
        btn_4.setOnClickListener {
            numberClick("4")
        }
        btn_5.setOnClickListener {
            numberClick("5")
        }
        btn_6.setOnClickListener {
            numberClick("6")
        }
        btn_7.setOnClickListener {
            numberClick("7")
        }
        btn_8.setOnClickListener {
            numberClick("8")
        }
        btn_9.setOnClickListener {
            numberClick("")
        }
        btn_plus.setOnClickListener {
            operatorClick("+")
        }
        btn_minus.setOnClickListener {
            operatorClick("-")
        }
        btn_drop.setOnClickListener {
            operatorClick("/")
        }
        btn_multiply.setOnClickListener {
            operatorClick("*")
        }
        btn_dot.setOnClickListener {
            operatorClick(".")
        }
        btn_brackets.setOnClickListener {
            operatorClick("(")
        }
        btn_brackets_close.setOnClickListener {
            operatorClick(")")
        }
        btn_back.setOnClickListener {
            val str = btn_result_text.text.toString()
            if (str.isEmpty()) {
                btn_result_text.text = str.substring(0, str.length - 1)
            }
        }
        btn_equals.setOnClickListener {
            calculateResult()
        }
        btn_AC.setOnClickListener {
            clearCalculator()
        }
    }
    fun operashion() {
        btn_0 = findViewById(R.id.btn_zero)
        btn_1 = findViewById(R.id.btn_one)
        btn_2 = findViewById(R.id.btn_two)
        btn_3 = findViewById(R.id.btn_three)
        btn_4 = findViewById(R.id.btn_four)
        btn_5 = findViewById(R.id.btn_five)
        btn_6 = findViewById(R.id.btn_six)
        btn_7 = findViewById(R.id.btn_seven)
        btn_8 = findViewById(R.id.btn_eight)
        btn_9 = findViewById(R.id.btn_nine)
        btn_plus = findViewById(R.id.btn_plus)
        btn_minus = findViewById(R.id.btn_minus)
        btn_drop = findViewById(R.id.btn_drop)
        btn_multiply = findViewById(R.id.btn_multiply)
        btn_dot = findViewById(R.id.btn_dot)
        btn_back = findViewById(R.id.btn_back)
        btn_equals = findViewById(R.id.btn_equals)
        btn_result_text = findViewById(R.id.result_text)
        btn_brackets = findViewById(R.id.btn_bracket)
        btn_brackets_close = findViewById(R.id.btn_brackets_close)
        btn_AC = findViewById(R.id.btn_AC)
    }

    fun numberClick(number: String) {
        val currentText = btn_result_text.text.toString()
        btn_result_text.text = buildString {
            append(currentText)
            append(number)
        }
    }

    fun operatorClick(operator: String) {
        currentOperator = operator
        currentOperand = btn_result_text.text.toString().toDouble()
        btn_result_text.text = ""
    }
    fun clearCalculator() {
        btn_result_text.text = ""
        currentOperand = 0.0
        currentOperator = ""
    }
    fun calculateResult() {
        val operand = btn_result_text.toString().toDouble()
        var result = 0.0
        when (currentOperator) {
            "+" -> result = currentOperand + operand
            "-" -> result = currentOperand + operand
            "/" -> result = currentOperand + operand
            "*" -> result = currentOperand + operand
        }
        btn_result_text.text = result.toString()
    }
}