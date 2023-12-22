package com.example.quickstartlessons.practicalLesson
import android.annotation.SuppressLint
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.databinding.DialogAddTextBinding
import com.example.quickstartlessons.databinding.ItemAddTextBinding


class FragmentAddText : Fragment() {
    private lateinit var inflater: LayoutInflater
    private lateinit var container: ViewGroup
    private lateinit var binding: ItemAddTextBinding
    private val items: MutableList<AddTextData> = mutableListOf()
    private val adapter = AdapterAddText {it->
        createNewText(AddTextData(it))
    }


    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ItemAddTextBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

    }

    private fun createNewText(item:AddTextData) {
        showAlertDialog {
            if (it) adapter.updateAdapter(items)
        }
    }

    private fun showAlertDialog(onItemClick: (Boolean) -> Unit) {

        val alertDialogBuilder = AlertDialog.Builder(requireContext())
        alertDialogBuilder.setTitle("Enter the text")


        val editText: DialogAddTextBinding = DialogAddTextBinding.inflate(inflater, container, false)
        val text = alertDialogBuilder.setMessage(editText.editTextDialog.text)

        alertDialogBuilder.setPositiveButton("Add") { _: DialogInterface, _: Int ->
            onItemClick.invoke(true)
            items.add(AddTextData(text.toString()))


        }
        alertDialogBuilder.setNegativeButton("Cancel") { _: DialogInterface, _: Int ->
            onItemClick.invoke(false)

        }

        val alertDialog: AlertDialog = alertDialogBuilder.create()
        if (!alertDialog.isShowing) {
            alertDialog.show()
        }
    }

}