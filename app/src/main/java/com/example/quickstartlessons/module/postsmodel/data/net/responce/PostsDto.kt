package com.example.quickstartlessons.module.postsmodel.data.net.responce

import com.example.quickstartlessons.module.postsmodel.data.net.responce.PostDto
import com.google.gson.annotations.SerializedName

data class PostsDto(
    @SerializedName("posts")
    val posts: List<PostDto>
)
