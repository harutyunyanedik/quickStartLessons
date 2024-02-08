package com.example.quickstartlessons.module.account.post

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.R
import com.example.quickstartlessons.databinding.FragmentPostBinding
import com.example.quickstartlessons.module.base.fragment.BaseFragment.Companion.showErrorMessageDialog
import org.koin.androidx.viewmodel.ext.android.viewModel


/**
 *  todo  petqa jaranges BaseFragment ic, qo mot hima crash a linum vortev du viewModel e sarqel es PostFragment i scop ov,
 */
class PostFragment : Fragment() {
    private lateinit var binding: FragmentPostBinding
    private val adapter = PostAdapter()
    private val viewModel by viewModel<PostViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.post()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPostBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        observe() // todo rename observeLiveData
    }

    private fun setupView() {
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun observe() {
        viewModel.postLiveData.observe(viewLifecycleOwner) {
            adapter.updateData(it)
        }
        viewModel.postErrorLiveData.observe(viewLifecycleOwner) {
            showErrorMessageDialog(getString(R.string.error_data), it.toString())
        }
    }
}