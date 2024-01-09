package com.example.quickstartlessons.module.login
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quickstartlessons.MainActivity
import com.example.quickstartlessons.databinding.FragmentSignInPageBinding

class SignInFragment : Fragment() {


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
       val login= (requireActivity() as MainActivity).getLoginPassword(LOGIN_KEY)
        val password=(requireActivity() as MainActivity).getLoginPassword(PASSWORD_KEY)
        binding.buttonSignIn.setOnClickListener {
           if()
        }
    }
    companion object{
      private  const val LOGIN_KEY="login"
        private const val  PASSWORD_KEY="password"
    }
}