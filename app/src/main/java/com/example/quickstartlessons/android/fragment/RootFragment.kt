package com.example.quickstartlessons.android.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.R
import com.example.quickstartlessons.android.Model
import com.example.quickstartlessons.android.adapter.AdapterRootFragment
import com.example.quickstartlessons.android.dialogs.showAlertDialog
import com.example.quickstartlessons.databinding.ItemFragmentRootBinding

class RootFragment : Fragment() {
    private lateinit var binding: ItemFragmentRootBinding
   private var adapter =AdapterRootFragment()
    val list= mutableListOf<Model>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ItemFragmentRootBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
     setupRecyclerView()
         binding.recyclerView.setOnLongClickListener {
             showAlertDialog {


             }
         }
    }
    fun onItemClick(position:Int){
         list.remove(list[position])


    }
    private  fun setupRecyclerView() {
        binding.recyclerView.adapter=adapter
        binding.recyclerView.layoutManager=LinearLayoutManager(requireContext())
        adapter.updateData(createNewList())
    }

    private fun createDeleteList():List<Model>{
        for (i in 0..20){
            list.add(Model("Title  $i"))

        }
        return list
    }

   private fun createNewList():List<Model>{
        val list = mutableListOf<Model>()
        for (i in 0..20){
            list.add(Model("Title  $i"))

        }
        return list
    }
    companion object {
        fun newInstance() = RootFragment()
    }
}