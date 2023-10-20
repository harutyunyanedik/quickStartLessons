package com.example.quickstartlessons

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val math_operation = findViewById<TextView>(R.id.math_operation)
    private val btn_zero = findViewById<TextView>(R.id.btn_zero)
    private val btn_one = findViewById<TextView>(R.id.btn_one)
    private val btn_two = findViewById<TextView>(R.id.btn_two)
    private val btn_three = findViewById<TextView>(R.id.btn_three)
    private val btn_four = findViewById<TextView>(R.id.btn_four)
    private val btn_five = findViewById<TextView>(R.id.btn_five)
    private val btn_six = findViewById<TextView>(R.id.btn_six)
    private val btn_seven = findViewById<TextView>(R.id.btn_seven)
    private val btn_eight = findViewById<TextView>(R.id.btn_eight)
    private val btn_nine = findViewById<TextView>(R.id.btn_nine)

    private val btn_plus = findViewById<TextView>(R.id.btn_plus)
    private val btn_minus = findViewById<TextView>(R.id.btn_minus)
    private val btn_mult = findViewById<TextView>(R.id.btn_multiply)
    private val btn_drop = findViewById<TextView>(R.id.btn_drop)
    private val btn_bracket = findViewById<TextView>(R.id.btn_bracket)
    private val btn_bracketclose = findViewById<TextView>(R.id.btn_brackets_close)
    private val btn_dot = findViewById<TextView>(R.id.btn_dot)

    private val btn_AC = findViewById<TextView>(R.id.btn_AC)
    private val btn_back = findViewById<TextView>(R.id.btn_back)
    private val result_text = findViewById<TextView>(R.id.result_text)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_linear)


        btn_zero.setOnClickListener { showTextFields("0") }
        btn_one.setOnClickListener { showTextFields("1") }
        btn_two.setOnClickListener { showTextFields("2") }
        btn_three.setOnClickListener { showTextFields("3") }
        btn_four.setOnClickListener { showTextFields("4") }
        btn_five.setOnClickListener { showTextFields("5") }
        btn_six.setOnClickListener { showTextFields("6") }
        btn_seven.setOnClickListener { showTextFields("7") }
        btn_eight.setOnClickListener { showTextFields("8") }
        btn_nine.setOnClickListener { showTextFields("9") }

        btn_plus.setOnClickListener { showTextFields("+") }
        btn_minus.setOnClickListener { showTextFields("-") }
        btn_mult.setOnClickListener { showTextFields("*") }
        btn_drop.setOnClickListener { showTextFields("/") }
        btn_bracket.setOnClickListener { showTextFields("(") }
        btn_bracketclose.setOnClickListener { showTextFields(")") }
        btn_dot.setOnClickListener { showTextFields(".") }

        btn_AC.setOnClickListener {
            math_operation.text = ""
        }
        btn_back.setOnClickListener {
            val str = math_operation.text.toString()
            if (str.isEmpty()) {
                math_operation.text = str.substring(0, str.length - 1)
            }
            result_text.text = ""
        }
    }

    fun showTextFields(str: String) {
        math_operation.append(str)
    }

}