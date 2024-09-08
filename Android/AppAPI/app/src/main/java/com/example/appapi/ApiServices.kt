package com.example.appapi

import retrofit2.Call
import retrofit2.http.GET

interface ApiServices {

    // Retrofit GET request for fetching the album list
    @GET("Album")
    fun getAlbum(): Call<List<Album>>
}
