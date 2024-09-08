package com.example.appapi

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import missing.namespace.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var viewModel: AlbumViewModel by viewModels()
    private lateinit var albumAdapter: AlbumsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel=ViewModelProvider(this).get(AlbumViewModel::class.java)
        setContentView(binding.root)
        albumAdapter = AlbumsAdapter()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = albumAdapter
        }
        viewModel.album.observe(this, Observer { albumList ->
            albumList.forEach { album ->
                Log.i("User", album.userId.toString())
                Log.i("User", album.id.toString())
                Log.i("User", album.title)
            }
            albumAdapter.submitList(albumList)
        })
    }
}
