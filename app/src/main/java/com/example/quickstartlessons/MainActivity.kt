package com.example.quickstartlessons

import android.annotation.SuppressLint
import android.media.TimedText
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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
        calculate.numberEntering.text = StringBuilder(0)
        var number1 = 0
        var number2 = 0
        var operator=" "
        calculate.oneButton.setOnClickListener {
            calculate.numberEntering.append(calculate.oneButton.text)
        }
        calculate.twoButton.setOnClickListener {
            calculate.numberEntering.append(calculate.twoButton.text)
        }
        calculate.threeButton.setOnClickListener {
            calculate.numberEntering.append(calculate.threeButton.text)
        }
        calculate.fourButton.setOnClickListener {
            calculate.numberEntering.append(calculate.fourButton.text)
        }
        calculate.fiveButton.setOnClickListener {
            calculate.numberEntering.append(calculate.fiveButton.text)
        }
        calculate.sixButton.setOnClickListener {
            calculate.numberEntering.append(calculate.sixButton.text)
        }

        calculate.sevenButton.setOnClickListener {
            calculate.numberEntering.append(calculate.sevenButton.text)
        }

        calculate.eightButton.setOnClickListener {
            calculate.numberEntering.append(calculate.eightButton.text)
        }
        calculate.nineButton.setOnClickListener {
            calculate.numberEntering.append(calculate.nineButton.text)
        }
        calculate.zeroButton.setOnClickListener {
            calculate.numberEntering.append(calculate.zeroButton.text)
        }
        calculate.delete.setOnClickListener {
            val newText = calculate.numberEntering.text.toString()
            if (newText.isNotEmpty()) {
                calculate.numberEntering.text = newText.substring(0, newText.length - 1)
                calculate.result.setText(" ")
            }
        }

        calculate.operatorPlus.setOnClickListener {
            val p=calculate.numberEntering.append(calculate.operatorPlus.text)
            operator=p.toString()
        }
        calculate.multiply.setOnClickListener {
            val l=calculate.numberEntering.append(calculate.multiply.text)
            operator=l.toString()

        }
        calculate.operatorMinus.setOnClickListener {
            val m=calculate.numberEntering.append(calculate.operatorMinus.text)
            operator=m.toString()
        }
        calculate.divisionButton.setOnClickListener {
            val d= calculate.numberEntering.append(calculate.divisionButton.text)
            operator=d.toString()
        }
        number1
        number2=calculate.numberEntering.text.lastIndex
        calculate.equalButton.setOnClickListener {
            when (operator) {
                calculate.operatorPlus.text -> calculate.result.text=(number1 + number2).toString()

                calculate.operatorMinus.text -> calculate.result.text =
                    (number1 - number2).toString()

                calculate.divisionButton.text -> calculate.result.text =
                    (number1.toDouble() / number2.toDouble()).toString()

                calculate.multiply.text -> calculate.result.text = (number1 * number2).toString()

            }
        }
    }
}






















