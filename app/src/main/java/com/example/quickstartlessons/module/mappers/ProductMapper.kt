package com.example.quickstartlessons.module.mappers

import com.example.quickstartlessons.module.category.data.model.Category
import com.example.quickstartlessons.module.product.data.model.Product
import com.example.quickstartlessons.module.product.data.net.response.ProductDto
import com.example.quickstartlessons.module.product.data.net.response.ProductsDto

class ProductMapper {

    fun productDtoToProduct(productDto: ProductDto) = Product(
        id = productDto.id,
        title = productDto.title,
        description = productDto.description,
        price = productDto.price,
        imageUrl = productDto.imageUrl
    )

    fun listProductsDtoToListProducts(productsDto: ProductsDto?): List<Product>? {
        productsDto?.let {
            val list = mutableListOf<Product>()
            for (i in it.products) {
                list.add(productDtoToProduct(i))
            }
            return list
        }
        return null
    }

    fun listStringToListCategory(list: List<String>?): List<Category>? {
        list?.let {
            val listCategory = mutableListOf<Category>()
            for (i in it) {
                listCategory.add(Category(i))
            }
            return listCategory
        }
        return null
    }
}