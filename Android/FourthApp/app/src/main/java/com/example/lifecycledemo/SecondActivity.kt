package com.example.lifecycledemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fourthapp.R

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }
}
