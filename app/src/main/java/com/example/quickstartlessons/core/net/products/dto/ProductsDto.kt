package com.example.quickstartlessons.core.net.products.dto

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ProductsDto(
    @SerializedName("products")
    val products: List<ProductDto>
) :Serializable, List<ProductsDto> {
    override val size: Int
        get() = TODO("Not yet implemented")

    override fun contains(element: ProductsDto): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsAll(elements: Collection<ProductsDto>): Boolean {
        TODO("Not yet implemented")
    }

    override fun get(index: Int): ProductsDto {
        TODO("Not yet implemented")
    }

    override fun indexOf(element: ProductsDto): Int {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun iterator(): Iterator<ProductsDto> {
        TODO("Not yet implemented")
    }

    override fun lastIndexOf(element: ProductsDto): Int {
        TODO("Not yet implemented")
    }

    override fun listIterator(): ListIterator<ProductsDto> {
        TODO("Not yet implemented")
    }

    override fun listIterator(index: Int): ListIterator<ProductsDto> {
        TODO("Not yet implemented")
    }

    override fun subList(fromIndex: Int, toIndex: Int): List<ProductsDto> {
        TODO("Not yet implemented")
    }
}