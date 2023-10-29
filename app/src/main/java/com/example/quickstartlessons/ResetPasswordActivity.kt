package com.example.quickstartlessons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.quickstartlessons.databinding.ActivityResetPasswordBinding

class ResetPasswordActivity : AppCompatActivity() {
    private lateinit var reset:ActivityResetPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        reset=DataBindingUtil.setContentView(this,R.layout.activity_reset_password)
        if(reset.sms.isChecked){
          reset.enterData.setText("Enter number phone")
        }else{
            reset.enterData.setText("E-mail")
        }
    }
}