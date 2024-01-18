package com.example.quickstartlessons.module.data

class ProductMapper {

    fun productDtoToProduct(productDto: ProductDto) = Product(
        productDto.id,
        productDto.title,
        productDto.description,
        productDto.price,
        productDto.imageUrl)

    fun listProductsDtoToListProducts(productsDto: ProductsDto?) : List<Product>? {
        productsDto?.let {
            val list = mutableListOf<Product>()
            for (i in it.products){
                list.add(productDtoToProduct(i))
            }
            return list
        }
        return null
    }

    fun listStringToListCategory(list: List<String>?) : List<Category>? {
        list?.let {
            val listCategory = mutableListOf<Category>()
            for (i in it){
                listCategory.add(Category(i))
            }
            return listCategory
        }
        return null
    }
}