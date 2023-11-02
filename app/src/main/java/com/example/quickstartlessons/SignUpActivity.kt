package com.example.quickstartlessons

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.quickstartlessons.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var biding: ActivitySignUpBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        biding.buttonRegister.setOnClickListener {
            if (biding.editTextEnterUserName.text.isNotBlank() &&
                biding.editTextEnterEmail.text.isNotBlank() &&
                biding.editTextEnterPhoneNumber.text.isNotBlank() &&
                biding.editTextEnterPassword.text.isNotBlank() &&
                biding.editTextRepeatPassword.text.isNotBlank()) {

                if (biding.editTextEnterPassword.text.toString() == biding.editTextRepeatPassword.text.toString()){
                    if (!UsersList.findUserByUserName(biding.editTextEnterUserName.text.toString())){
                        val user = User(biding.editTextEnterUserName.text.toString(),
                            biding.editTextEnterEmail.text.toString(),
                            biding.editTextEnterPhoneNumber.text.toString().toInt(),
                            biding.editTextEnterPassword.text.toString())
                        UsersList.addUser(user)
                        putUserNameAndPassword(user.username, user.password)
                        finish()
                    } else {
                        Toast.makeText(this, "A user with that username exists", Toast.LENGTH_SHORT).show()
                    }

                } else {
                    Toast.makeText(this, getString(R.string.passwords_do_not_match), Toast.LENGTH_SHORT).show()
                }


            } else {
                Toast.makeText(this, getString(R.string.please_fill_in_all_fields), Toast.LENGTH_SHORT).show()
            }
        }

    }
}