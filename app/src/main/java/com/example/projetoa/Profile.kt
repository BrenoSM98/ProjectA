package com.example.projetoa

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomnavigation.BottomNavigationView

class Profile : AppCompatActivity() {
    private lateinit var dadosTextView: TextView
    private lateinit var editButton: Button
    private lateinit var dadosViewModel: DadosViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        dadosViewModel = ViewModelProvider(this).get(DadosViewModel::class.java)

        dadosTextView = findViewById(R.id.dadosTextView)
        editButton = findViewById(R.id.editButton)

        val nome = dadosViewModel.nome
        val idade = dadosViewModel.idade
        val sexo = dadosViewModel.sexo
        val cidade = dadosViewModel.cidade
        val objetivo = dadosViewModel.objetivo

        val dados = "Nome: $nome\nIdade: $idade\nSexo: $sexo\nCidade: $cidade\nObjetivo: $objetivo"
        dadosTextView.text = dados

        editButton.setOnClickListener{
            val intent = Intent(this, DataActivity::class.java)
            startActivity(intent)
        }

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.nav_home -> {
                    val intent = Intent (this, Home::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_profile -> {
                    true
                }
                R.id.nav_notifications -> {
                    val intent = Intent (this, Notifications::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}