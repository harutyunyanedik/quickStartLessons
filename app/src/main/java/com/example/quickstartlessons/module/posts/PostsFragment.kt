package com.example.quickstartlessons.module.posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.databinding.FragmentPostsBinding
import com.example.quickstartlessons.module.base.fragment.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class PostsFragment : BaseFragment() {

    private lateinit var binding: FragmentPostsBinding
    private val viewModel: PostsViewModel by viewModel()
    private val adapter = PostsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getPosts()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPostsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        observeLiveData()
    }

    private fun setupViews() {
        binding.recyclerViewPosts.adapter = adapter
        binding.recyclerViewPosts.layoutManager = LinearLayoutManager(requireContext())
        binding.textViewPosts.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun observeLiveData() {
        viewModel.postsLiveData.observe(viewLifecycleOwner) {
            adapter.updateData(it?.posts)
        }
        viewModel.postsErrorLiveData.observe(viewLifecycleOwner) {
            
        }
    }

}