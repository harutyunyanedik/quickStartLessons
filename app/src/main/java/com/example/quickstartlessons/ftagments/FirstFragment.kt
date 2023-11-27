package com.example.quickstartlessons.ftagments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quickstartlessons.MainActivity
import com.example.quickstartlessons.android.Model
import com.example.quickstartlessons.android.ModelOne
import com.example.quickstartlessons.databinding.FirstFragmentBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FirstFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FirstFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val item: MutableList<Model> = mutableListOf()
        for (i in 1..11) {
            item.add(Model("Toyota-ն հետ է կանչում ավելի քան կես միլիոն ավտոմեքենա՝ անսարք արգելակների պատճառով", "https://news.am/img/news/79/41/14/220x220.jpg"))
        }
        val itemOne: MutableList<ModelOne> = mutableListOf()
        for (i in 1..11) {
            itemOne.add(ModelOne("News","@drawable/baseline_library_books_24"))
        }
        binding.secondRecyclerView
            .setOnClickListener {
            (requireActivity() as? MainActivity)?.replaceFragments(SecondFragment.newInstance())
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = FirstFragment()

    }
}