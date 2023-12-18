package com.example.quickstartlessons.module.albums.albumDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickstartlessons.R
import com.example.quickstartlessons.adapters.ImagesRecyclerViewAdapter
import com.example.quickstartlessons.databinding.FragmentAlbumDetailsBinding
import com.example.quickstartlessons.module.albums.data.model.responce.AlbumDto
import com.example.quickstartlessons.module.albums.data.net.datasource.AlbumDataSource
import com.google.gson.JsonObject
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Array.getInt

class AlbumDetailsFragment : Fragment() {

    private val args:AlbumDetailsFragmentArgs by navArgs()
    private lateinit var binding: FragmentAlbumDetailsBinding
    private var item: MutableList<AlbumDto> = mutableListOf()
    private var adapter: ImagesRecyclerViewAdapter = ImagesRecyclerViewAdapter{
        findNavController().navigate(R.id.action_albumDetailsFragment_to_detailsFragment)
        //findNavController().navigate(AlbumDetailsFragmentDirections.actionAlbumDetailsFragmentToDetailsFragment("10"))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        args.albumId
        findNavController().navigateUp()
        binding = FragmentAlbumDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupItems()
    }

    private fun setupItems() {
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
        adapter.updateData(createItems())
    }

    private fun createItems(): List<AlbumDto> {
         val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val albumDataSource = retrofit.create(AlbumDataSource::class.java)
        val call = albumDataSource.getAlbums()

                val list = ArrayList<AlbumDto>()
                for (i in 0 until list.size) {
                    val user = list[i] as JSONObject
                    val items = AlbumDto(
                        user.getInt("id"),
                        user.getString("title"),
                        user.getString("thumbnailUrl")
                    )
                    list.add(items)
                }
                for (i in 0 until item.size) {
                    item.add(list[i])
                }
                return item
            }

    private  fun parsData(mainObject:JSONObject):List<AlbumDto> {
        val list = ArrayList<AlbumDto>()
        val dataArray = mainObject.getJSONObject("").getJSONArray("")
        for (i in 0 until dataArray.length()) {
            val user = dataArray[i] as JSONObject
            val items = AlbumDto(
                user.getInt("id"),
                user.getString("title"),
                user.getString("thumbnailUrl")
            )
            list.add(items)
        }
        return list
    }

        }

