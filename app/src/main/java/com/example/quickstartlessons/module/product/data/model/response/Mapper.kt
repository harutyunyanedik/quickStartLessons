package com.example.quickstartlessons.module.product.data.model.response

class Mapper {
    fun productDtoToProduct(productDto: ProductDto) = Product(
        id = productDto.id,
        title = productDto.title,
        description = productDto.description,
        price = productDto.price,
        brand = productDto.brand,
        thumbnail = productDto.thumbnail,
    )

    fun listProductsDtoToListProducts(productsDto: ProductsDto?): List<Product>? {
        productsDto?.let {
            val list = mutableListOf<Product>()
            for (i in it.products)
                return list
        }
        return null
    }
}