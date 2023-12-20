package com.example.quickstartlessons.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.quickstartlessons.databinding.FragmentViewPagerBinding
import com.google.android.material.tabs.TabLayoutMediator


class MessageViewPagerFragment : Fragment() {

    private lateinit var binding: FragmentViewPagerBinding
    private lateinit var adapter: MessageViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewPagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        adapter = MessageViewPagerAdapter(childFragmentManager, viewLifecycleOwner.lifecycle)
        binding.viewPager.adapter = adapter
        val fragments = createList()
        adapter.updateData(fragments)

        TabLayoutMediator(binding.tabLayoutMessage, binding.viewPager) {tab, position ->
            when(fragments[position]) {
                is MessageFragment -> tab.text = "Message"
                is TitleFragment -> tab.text = "Title"
            }

        }.attach()
    }

    private fun createList() : List<Fragment>{
        val list = mutableListOf<Fragment>()
        list.add(MessageFragment.newInstance())
        list.add(TitleFragment.newInstance())
        return list
    }

    companion object {

        fun newInstance() = MessageViewPagerFragment()
    }
}