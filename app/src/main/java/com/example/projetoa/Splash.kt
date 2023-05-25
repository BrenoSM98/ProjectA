package com.example.projetoa

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide


class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        showGif() // Exibe o GIF na tela de splash

        supportActionBar?.hide() // Oculta a barra de ação da atividade

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@Splash,Start::class.java)
            startActivity(intent)},5000) // Cria um atraso de 5 segundos antes de iniciar a próxima atividade

    }
    fun showGif() {
        val imageView: ImageView = findViewById(R.id.splash)
        Glide.with(this).load(R.drawable.fitgoals).into(imageView)  // Carrega e exibe o GIF na ImageView especificada
    }
}