package com.example.quickstartlessons.module.login
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.quickstartlessons.MainActivity
import com.example.quickstartlessons.databinding.FragmentSignInPageBinding

class SignInFragment : ViewExtension() {


    private lateinit var binding:FragmentSignInPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=FragmentSignInPageBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       openNewPage()
        binding.forgotPassword.setOnClickListener {
            findNavController().navigate()
        }
    }
    private fun openNewPage(){
      val login= mainActivity().getLoginPassword(LOGIN_KEY)
       val password= mainActivity().getLoginPassword(PASSWORD_KEY)
        binding.buttonSignIn.setOnClickListener {
            mainActivity().setLoginPassword(login,"name")
            mainActivity().setLoginPassword(password,"surname")
            if(binding.login.text.toString()!="name" || binding.password.text.toString()!="surname"){
                Toast.makeText(context,"Wrong username or password", Toast.LENGTH_SHORT).show()
            } else{
                startActivity(Intent(context,MainActivity::class.java))
            }
        }
    }
    companion object {
      private  const val LOGIN_KEY="login"
        private const val  PASSWORD_KEY="password"
    }
}