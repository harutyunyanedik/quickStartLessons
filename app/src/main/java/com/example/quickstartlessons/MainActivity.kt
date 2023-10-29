package com.example.quickstartlessons

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.quickstartlessons.databinding.DataLayoutBinding

class MainActivity : AppCompatActivity() {
private lateinit var binding: DataLayoutBinding

//    private lateinit var btn_0: Button
//    private lateinit var btn_1: Button
//    private lateinit var btn_2: Button
//    private lateinit var btn_3: Button
//    private lateinit var btn_4: Button
//    private lateinit var btn_5: Button
//    private lateinit var btn_6: Button
//    private lateinit var btn_7: Button
//    private lateinit var btn_8: Button
//    private lateinit var btn_9: Button
//    private lateinit var btn_plus: Button
//    private lateinit var btn_minus: Button
//    private lateinit var btn_drop: Button
//    private lateinit var btn_multiply: Button
//    private lateinit var btn_dot: Button
//    private lateinit var btn_back: Button
//    private lateinit var btn_equals: Button
//    private lateinit var result_text: TextView
//    private lateinit var btn_brackets: Button
//    private lateinit var btn_brackets_close: Button
//    private lateinit var btn_AC: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.data_layout)
        binding.password.setOnClickListener{
           val intent=Intent(this,ActivityLogin::class.java)
            startActivity(intent)
        }


//               operashion()
//        btn_0.setOnClickListener { settextFind("0") }
//        btn_1.setOnClickListener { settextFind("1") }
//        btn_2.setOnClickListener { settextFind("2") }
//        btn_3.setOnClickListener { settextFind("3") }
//        btn_4.setOnClickListener { settextFind("4") }
//        btn_5.setOnClickListener { settextFind("5") }
//        btn_6.setOnClickListener { settextFind("6") }
//        btn_7.setOnClickListener { settextFind("7") }
//        btn_8.setOnClickListener { settextFind("8") }
//        btn_9.setOnClickListener { settextFind("9") }
//
//
//        btn_plus.setOnClickListener { settextFind("+") }
//        btn_minus.setOnClickListener { settextFind("-") }
//        btn_drop.setOnClickListener { settextFind("/") }
//        btn_multiply.setOnClickListener { settextFind("*") }
//        btn_dot.setOnClickListener { settextFind(".") }
//        btn_brackets.setOnClickListener { settextFind("(") }
//        btn_brackets_close.setOnClickListener { settextFind(")") }
//        btn_equals.setOnClickListener {
//            try {
//                val ex = ExpressionBuilder(result_text.text.toString()).build()
//                val result = ex.evaluate()
//
//                val longRes=result.toLong()
//                if(result==longRes.toDouble()){
//                    result_text.text=longRes.toString()
//                }else
//                    result_text.text=result.toString()
//            } catch (e: Exception) {
//                Log.d("Error", "message: ${e.message}")
//            }
//        }
//
//        btn_back.setOnClickListener {
//            val str = result_text.text.toString()
//            if (str.isEmpty()) {
//                result_text.text = str.substring(0, str.length - 1)
//                result_text.text = ""
//            }
//        }
//        btn_AC.setOnClickListener { clearCalculator()}
//
//    }
//
//    fun operashion() {
//        btn_0 = findViewById(R.id.btn_zero)
//        btn_1 = findViewById(R.id.btn_one)
//        btn_2 = findViewById(R.id.btn_two)
//        btn_3 = findViewById(R.id.btn_three)
//        btn_4 = findViewById(R.id.btn_four)
//        btn_5 = findViewById(R.id.btn_five)
//        btn_6 = findViewById(R.id.btn_six)
//        btn_7 = findViewById(R.id.btn_seven)
//        btn_8 = findViewById(R.id.btn_eight)
//        btn_9 = findViewById(R.id.btn_nine)
//        btn_plus = findViewById(R.id.btn_plus)
//        btn_minus = findViewById(R.id.btn_minus)
//        btn_drop = findViewById(R.id.btn_drop)
//        btn_multiply = findViewById(R.id.btn_multiply)
//        btn_dot = findViewById(R.id.btn_dot)
//        btn_back = findViewById(R.id.btn_back)
//        btn_equals = findViewById(R.id.btn_equals)
//        result_text = findViewById(R.id.result_text)
//        btn_brackets = findViewById(R.id.btn_bracket)
//        btn_brackets_close = findViewById(R.id.btn_brackets_close)
//        btn_AC = findViewById(R.id.btn_AC)
//        btn_equals = findViewById(R.id.btn_equals)
//    }
//
//    fun settextFind(str: String) {
//        result_text.append(str)
//    }
//
//    fun clearCalculator() {
//        result_text.text = ""
   }

}