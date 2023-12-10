package com.example.quickstartlessons.module.albums.newpresenttation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.databinding.FragmentHeaderPageBinding

class HeaderPageFragment : Fragment() {
    private lateinit var binding: FragmentHeaderPageBinding
    private val adapter: ItemsRecyclerViewAdapter = ItemsRecyclerViewAdapter()
    private val item: MutableList<Model> = mutableListOf()
    var title: String = ""
     var massage: String = ""
         var n = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = arguments?.getString(TITLE_KEY).toString()
        massage = arguments?.getString(MASSAGE_KEY).toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHeaderPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.plusButton.setOnClickListener {
            setupItems()
            showPopUp()
        }
    }

    private fun showPopUp() {
        val showPopUp = PopUpFragment(massage, title)
        showPopUp.show((activity as AppCompatActivity).supportFragmentManager, "showPopUp")
    }

    private fun setupItems() {
        binding.recyclerView.adapter = this.adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter.updateData(createImages(title,massage))

    }

    private fun createImages(title:String,massage:String): MutableList<Model> {
        for (i in 0..n) {
            item.add(Model(title,massage))
        }
        return item
    }

    companion object {
        @JvmStatic
        fun newInstance() = HeaderPageFragment().apply {
            arguments = Bundle().apply {
                putString(TITLE_KEY, title)
                putString(MASSAGE_KEY, massage)
            }
        }
        const val TITLE_KEY = "title_key"
        const val MASSAGE_KEY = "massage_key"
    }
}