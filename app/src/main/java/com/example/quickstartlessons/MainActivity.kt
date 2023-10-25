package com.example.quickstartlessons

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculator)


        val button0 = findViewById<Button>(R.id.button0)
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val button5 = findViewById<Button>(R.id.button5)
        val button6 = findViewById<Button>(R.id.button6)
        val button7 = findViewById<Button>(R.id.button7)
        val button8 = findViewById<Button>(R.id.button8)
        val button9 = findViewById<Button>(R.id.button9)
        val calculation = findViewById<TextView>(R.id.calculation)
        val result = findViewById<TextView>(R.id.result)
        val clear = findViewById<Button>(R.id.clear)
        val backspace = findViewById<Button>(R.id.backspace)
        val addition = findViewById<Button>(R.id.addition)
        val minus = findViewById<Button>(R.id.minus)
        val multiplication = findViewById<Button>(R.id.multiplication)
        val division = findViewById<Button>(R.id.division)
        val equal = findViewById<Button>(R.id.buttonEqual)



        button0.setOnClickListener { setTextFields("0") }
        button1.setOnClickListener { setTextFields("1") }
        button2.setOnClickListener { setTextFields("2") }
        button3.setOnClickListener { setTextFields("3") }
        button4.setOnClickListener { setTextFields("4") }
        button5.setOnClickListener { setTextFields("5") }
        button6.setOnClickListener { setTextFields("6") }
        button7.setOnClickListener { setTextFields("7") }
        button8.setOnClickListener { setTextFields("8") }
        button9.setOnClickListener { setTextFields("9") }


        addition.setOnClickListener { setTextFields("+") }
        minus.setOnClickListener { setTextFields("-") }
        multiplication.setOnClickListener { setTextFields("*") }
        division.setOnClickListener { setTextFields("/") }


        clear.setOnClickListener {
            calculation.text = ""
            result.text = ""
        }

        backspace.setOnClickListener {
            val str = calculation.text.toString()
            if (str.isNotEmpty()) {
                calculation.text = str.substring(0, str.length - 1)
                result.text = ""
            }

        }
        equal.setOnClickListener {
            try {
                val ex = ExpressionBuilder(calculation.text.toString()).build()
                val result = ex.evaluate()
            } catch (e: Exception) {

            }

        }

    }

    private fun setTextFields(s: String) {
        val calculation = findViewById<TextView>(R.id.calculation)
        calculation.append(s)
    }


}
//
