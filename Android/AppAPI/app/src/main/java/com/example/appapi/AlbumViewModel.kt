package com.example.appapi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class AlbumViewModel @Inject constructor(
    private val albumRepo: AlbumRepo
) : ViewModel() {

    private val _albumList = MutableLiveData<List<Album>>()
    val album: LiveData<List<Album>> = _albumList

    init {
        fetchAlbum()
    }

    // Function to fetch the album list
    private fun fetchAlbum() {
        viewModelScope.launch {
            val response = albumRepo.getAlbumList()
            _albumList.postValue(response)
        }
    }
}
