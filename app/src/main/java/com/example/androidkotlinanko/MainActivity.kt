package com.example.androidkotlinanko

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.frameLayout
import org.jetbrains.anko.setContentView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)
    }
}
