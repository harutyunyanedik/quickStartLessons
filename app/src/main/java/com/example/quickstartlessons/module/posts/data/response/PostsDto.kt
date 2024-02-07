package com.example.quickstartlessons.module.posts.data.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PostsDto(
    @SerializedName("posts")
    val posts: List <PostDto>
) : Serializable

