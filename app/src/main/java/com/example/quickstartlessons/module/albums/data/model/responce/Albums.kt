package com.example.quickstartlessons.module.albums.data.model.responce

import java.io.Serializable

data class Albums(
    val albums: List<AlbumDto>
) : Serializable
