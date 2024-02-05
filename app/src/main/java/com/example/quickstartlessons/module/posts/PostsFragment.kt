package com.example.quickstartlessons.module.posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.databinding.FragmentPostsBinding
import com.example.quickstartlessons.module.base.fragment.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class PostsFragment : BaseFragment() {
    private lateinit var binding: FragmentPostsBinding
    private lateinit var adapter: PostsAdapter
    private val viewModel by viewModel<PostsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPostsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getProducts()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        observeLivedata()
    }

    private fun setupViews() {
        binding.postsRecyclerView.adapter = adapter
        binding.postsRecyclerView.layoutManager = LinearLayoutManager(requireContext())

    }

    private fun observeLivedata() {
        viewModel.postsLiveData.observe(viewLifecycleOwner) {
            adapter.updateData(listOf())
        }
        viewModel.postsErrorLiveData.observe(viewLifecycleOwner) {
            showErrorMessageDialog("Error Dialog", it ?: "Unknown error")
        }
    }
}