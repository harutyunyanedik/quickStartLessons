package com.example.quickstartlessons.practicalLesson
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.example.quickstartlessons.MainActivity
import com.example.quickstartlessons.databinding.FragmentDialogBinding


class FragmentDialog(private val callBack:(String)->Unit) : DialogFragment() {
    private val viewModel: AddTextViewModel by viewModels()
    private lateinit var binding: FragmentDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainActivity().getText(KEY)
        binding.dialogButton.setOnClickListener {
            val text = binding.editTextDialog.text.toString()
            for (i in 1..10) {
                val value = i.toString()
                mainActivity().saveData(KEY, value)
                if (text == value) {
                    callBack.invoke(text)
                    dismiss()

                } else {
                    Toast.makeText(context, "You have entered wrong data ", Toast.LENGTH_SHORT).show()
                    dismiss()
                }
              break
            }

        }
    }
    companion object{
        private const val KEY="key"
    }
}
fun Fragment.mainActivity()=requireActivity() as MainActivity