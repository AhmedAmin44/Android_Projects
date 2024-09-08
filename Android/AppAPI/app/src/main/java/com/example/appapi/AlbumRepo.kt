package com.example.appapi

import javax.inject.Inject

class AlbumRepo @Inject constructor(val apiServices:ApiServices) {
    suspend fun getAlbumList():List<Album>{
        return apiServices.getAlbum()
    }

}
