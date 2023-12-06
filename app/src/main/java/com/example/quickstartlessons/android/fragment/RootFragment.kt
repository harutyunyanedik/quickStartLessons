package com.example.quickstartlessons.android.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quickstartlessons.R
import com.example.quickstartlessons.android.adapter.AdapterFirstImageView
import com.example.quickstartlessons.android.adapter.AdapterNewsImage
import com.example.quickstartlessons.android.base.BaseFragment
import com.example.quickstartlessons.android.model.RvModelImage
import com.example.quickstartlessons.android.model.RvNewsModel
import com.example.quickstartlessons.databinding.ItemRecyclerViewFragmentRootBinding


class RootFragment : BaseFragment() {
    private lateinit var binding: ItemRecyclerViewFragmentRootBinding
    private val adapterImage = AdapterFirstImageView {
        replaceFragment(FragmentImageView.newInstance(it))
    }
    private val adapterNews = AdapterNewsImage { url, text ->

        replaceFragment(FragmentSecondPage.newInstance(url, text))

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = ItemRecyclerViewFragmentRootBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()

    }


    private fun setupRecyclerView() {
        binding.recyclerViewNews.adapter = adapterNews
        binding.recyclerViewNews.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        adapterNews.updateData(createNewsList())
        binding.recyclerViewImage.adapter = adapterImage
        binding.recyclerViewImage.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        adapterImage.updateData(createImageList())

    }

    private fun createNewsList(): List<RvNewsModel> {
        val list = mutableListOf<RvNewsModel>()
        for (i in 0..10) {
            list.add(
                RvNewsModel(
                    "https://e1.pxfuel.com/desktop-wallpaper/457/295/desktop-wallpaper-png-backgrounds-for-picsart-blur-picsart-editing.jpg",
                    "Բնությունը մշտապես շարժվում է և զարգանում, ընդգրկում անօրգանական և օրգանական աշխարհները։ Անօրգանական աշխարհին են պատկանում տիեզերական մարմինները, ջուրը, հողը, օդը, ապարները, օգտակար հանածոները։ Բուսական և կենդանական օրգանիզմների ողջ բազմազանությունը կազմում է օրգանական աշխարհը։ Զարգացման ընթացքում անօրգանական բնությունը օրինաչափորեն առաջ է բերում օրգանական բնություն (կենսոլորտ)՝ մարդու կենսագործունեության համար բոլոր անհրաժեշտ պայմաններով։ Հասարակական կյանքը, արտադրությունը, մարդը և նրա բանականությունը գոյատևում են բնական նյութերի հենքի վրա, գործում բնական օրինաչափություններին համապատասխան։ Բնության ներդաշնակությունն ու հավասարակշռությունը պայմանավորված են բազմազան փոխադարձ կապերով, և 1 օղակի խախտումը կարող է կտրել երևույթների ամբողջ շղթան։ Ուստի բնության հետ հարաբերություններում անհրաժեշտ է ճանաչել ու ճիշտ կիրառել նրա օրինաչափությունները, տիրապետել բնության հետ ներդաշնակ ապրելու ..."
                )
            )
            list.add(RvNewsModel("https://e1.pxfuel.com/desktop-wallpaper/457/295/desktop-wallpaper-png-backgrounds-for-picsart-blur-picsart-editing.jpg", R.string.text_for_image.toString()))
            list.add(RvNewsModel("https://e1.pxfuel.com/desktop-wallpaper/457/295/desktop-wallpaper-png-backgrounds-for-picsart-blur-picsart-editing.jpg", R.string.text_for_image.toString()))
        }
        return list
    }

    private fun createImageList(): List<RvModelImage> {
        val list = mutableListOf<RvModelImage>()
        for (i in 0..10) {
            list.add(RvModelImage("https://e1.pxfuel.com/desktop-wallpaper/457/295/desktop-wallpaper-png-backgrounds-for-picsart-blur-picsart-editing.jpg"))
            list.add(RvModelImage("https://e1.pxfuel.com/desktop-wallpaper/457/295/desktop-wallpaper-png-backgrounds-for-picsart-blur-picsart-editing.jpg"))
            list.add(RvModelImage("https://e1.pxfuel.com/desktop-wallpaper/457/295/desktop-wallpaper-png-backgrounds-for-picsart-blur-picsart-editing.jpg"))
        }
        return list
    }

    companion object {
        @JvmStatic
        fun newInstance() = RootFragment()

    }
}