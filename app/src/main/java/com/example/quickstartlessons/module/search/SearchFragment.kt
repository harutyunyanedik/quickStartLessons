package com.example.quickstartlessons.module.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.quickstartlessons.core.room.FavoriteManager
import com.example.quickstartlessons.databinding.FragmentSearchBinding
import com.example.quickstartlessons.module.base.fragment.BaseFragment
import com.example.quickstartlessons.module.home.ui.adapter.ProductsRecyclerViewAdapter
import com.example.quickstartlessons.module.search.viewModel.SearchViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 *  todo  petqa jaranges BaseFragment ic, qo mot hima crash a linum vortev du viewModel e sarqel es SearchFragment i scop ov,
 *  isk Search Fragmente chi jarangum ScopeFragment ic
 *  jaranges BaseFragment ic kuxxvi, vortec base e jaranguma Scope Fragment ic
 */
class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private val viewModel by viewModel<SearchViewModel>()
    private val favoriteManager: FavoriteManager by inject()

    private var adapter: ProductsRecyclerViewAdapter = ProductsRecyclerViewAdapter(onItemClick = {
        findNavController().navigate(SearchFragmentDirections.actionGlobalDescriptionFragment(it.id))
    }, updateFavorites = { isFavorite, product ->
        if (isFavorite) favoriteManager.insertProduct(product) else favoriteManager.deleteProductById(product)
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val it = binding.searchText.text.toString() // todo onCreate um binding e der init exac chi stex ches kara senc ban anes, searchi request e petqa anes SearchEditText i aftertextChanged i mej
        viewModel.Search(name = it)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        observeLiveData()
        setUpViewModel()
        binding.backButton.setOnClickListener { // todo tar setupListeners fun i mej
            findNavController().navigateUp()
        }

    }

    private fun setupViews() {
        favoriteManager.getAllProducts().observe(viewLifecycleOwner) {
            binding.rvItemOfProducts.layoutManager = GridLayoutManager(requireContext(), 2)
            binding.rvItemOfProducts.adapter = adapter

        }
    }

    private fun observeLiveData() {
        viewModel.searchProductsLiveData.observe(viewLifecycleOwner) {
            adapter.updateData(it?.products)
            binding.resultText.isVisible = binding.searchText.text.toString().isEmpty()
        }
        viewModel.searchProductsErrorLiveData.observe(viewLifecycleOwner) {
            BaseFragment.showErrorMessageDialog("Error Dialog", it)
        }
        favoriteManager.getAllProducts().observe(viewLifecycleOwner) {
            adapter.updateFavorites(it.map { productEntity ->
                productEntity.id
            })
        }
    }

    private fun setUpViewModel() { // todo inch kap uni setUpViewModel anune editText in listener set anelu het? sarqi setupListeners fun u tar meje
        binding.searchText.doAfterTextChanged {
            it?.length?.let { length ->
                if (length > 2) {
                    viewModel.Search(name = it.toString())
                }
            }
        }
    }

}