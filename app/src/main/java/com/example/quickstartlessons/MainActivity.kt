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
        val editText = mutableListOf<Any>()
        var number1 = 0
        var number2 = 0
        var operator = " "
        calculate.oneButton.setOnClickListener {
            editText.add(calculate.oneButton.text)
            calculate.numberEntering.text = editText.toString()
        }
        calculate.twoButton.setOnClickListener {
            editText.add(calculate.twoButton.text)
            calculate.numberEntering.text = editText.toString()
        }
        calculate.threeButton.setOnClickListener {
            editText.add(calculate.threeButton.text)
            calculate.numberEntering.text = editText.toString()
        }
        calculate.fourButton.setOnClickListener {
            editText.add(calculate.fourButton.text)
            calculate.numberEntering.text = editText.toString()
        }
        calculate.fiveButton.setOnClickListener {
            editText.add(calculate.fourButton.text)
            calculate.numberEntering.text = editText.toString()
        }
        calculate.sixButton.setOnClickListener {
            editText.add(calculate.sixButton.text)
            calculate.numberEntering.text = editText.toString()
        }

        calculate.sevenButton.setOnClickListener {
            editText.add(calculate.sevenButton.text)
            calculate.numberEntering.text = editText.toString()
        }

        calculate.eightButton.setOnClickListener {
            editText.add(calculate.eightButton.text)
            calculate.numberEntering.text = editText.toString()
        }
        calculate.nineButton.setOnClickListener {
            editText.add(calculate.nineButton.text)
            calculate.numberEntering.text = editText.toString()
        }
        calculate.zeroButton.setOnClickListener {
            editText.add(calculate.zeroButton.text)
            calculate.numberEntering.text = editText.toString()
        }
        calculate.delete.setOnClickListener {
            val newText = calculate.numberEntering.text.toString()
            if (newText.isNotEmpty()) {
                calculate.numberEntering.text = newText.substring(0, newText.length - 1)
                calculate.result.setText(" ")
            }
        }

        calculate.operatorPlus.setOnClickListener {
            val p = editText.add(calculate.operatorPlus.text)
            calculate.numberEntering.text = editText.toString()
            operator = p.toString()
        }
        calculate.multiply.setOnClickListener {
            val l = editText.add(calculate.multiply.text)
            calculate.numberEntering.text = editText.toString()
            operator = l.toString()

        }
        calculate.operatorMinus.setOnClickListener {
            val m = editText.add(calculate.operatorMinus.text)
            calculate.numberEntering.text = editText.toString()
            operator = m.toString()
        }
        calculate.divisionButton.setOnClickListener {
            val d = editText.add(calculate.divisionButton.text)
            calculate.numberEntering.text = editText.toString()
            operator = d.toString()
        }

        fun newList():MutableList<Any> {
            val list = mutableListOf<Any>()
            var currentNumber = ""
            for (i in calculate.numberEntering.text) {
                if (i.isDigit()) {
                    currentNumber += i
                } else {
                    list.add(currentNumber)
                    currentNumber = ""
                    list.add(i)
                }
            }
            if (currentNumber != "") {
                list.add(currentNumber)
            }
            return list
        }
            number1= newList()[0] as Int
            number2 = newList()[3] as Int
            calculate.equalButton.setOnClickListener {
                when (operator) {
                    calculate.operatorPlus.text -> calculate.result.text =
                        (number1 + number2).toString()

                    calculate.operatorMinus.text -> calculate.result.text =
                        (number1 - number2).toString()

                    calculate.divisionButton.text ->
                        if (number2 != 0) {
                            calculate.result.text =
                                (number1.toDouble() / number2.toDouble()).toString()
                        } else {
                            Toast.makeText(
                                this,
                                " number could not be divided by zero",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                    calculate.multiply.text -> calculate.result.text =
                        (number1 * number2).toString()

                }
            }
        }
    }






















