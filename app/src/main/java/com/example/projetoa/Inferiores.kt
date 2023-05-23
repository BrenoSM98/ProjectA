package com.example.projetoa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide

class Inferiores : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inferiores)

        showGif()

    }

    fun showGif() {
        val imageView1: ImageView = findViewById(R.id.flexoraGifImageView)
        Glide.with(this).load(R.drawable.infer2gif).into(imageView1)

        val imageView2: ImageView = findViewById(R.id.agachaGifImageView)
        Glide.with(this).load(R.drawable.infer3gif).into(imageView2)

        val imageView3: ImageView = findViewById(R.id.panturrilhaGifImageView)
        Glide.with(this).load(R.drawable.infer5gif).into(imageView3)
    }
}