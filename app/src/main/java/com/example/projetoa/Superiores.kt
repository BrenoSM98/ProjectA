package com.example.projetoa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide

class Superiores : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superiores)

        showGif()  // Exibe o GIF animado

    }
    fun showGif() {
        val imageView:ImageView = findViewById(R.id.roscaGifImageView)  // Carrega e exibe o GIF na ImageView especificada
        Glide.with(this).load(R.drawable.super5gif).into(imageView)
    }
}
