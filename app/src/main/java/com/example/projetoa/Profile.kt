package com.example.projetoa

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class Profile : AppCompatActivity() {
    private lateinit var dadosTextView: TextView
    private lateinit var editButton: Button

    private val sharedPreferencesKey = "user_data"

    private lateinit var bottomNavigationView: BottomNavigationView
    private var selectedItem = R.id.nav_profile

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        dadosTextView = findViewById(R.id.dadosTextView)
        editButton = findViewById(R.id.editButton)

        val sharedPreferences = getSharedPreferences(sharedPreferencesKey, Context.MODE_PRIVATE)
        val nome = sharedPreferences.getString("nome", "")
        val idade = sharedPreferences.getString("idade", "")
        val sexo = sharedPreferences.getString("sexo", "")
        val cidade = sharedPreferences.getString("cidade", "")
        val objetivo = sharedPreferences.getString("objetivo", "")

        val dados = "Nome: $nome\nIdade: $idade\nSexo: $sexo\nCidade: $cidade\nObjetivo: $objetivo"
        dadosTextView.text = dados

        editButton.setOnClickListener{
            val intent = Intent(this, DataActivity::class.java)
            startActivity(intent)
        }

        bottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.selectedItemId = selectedItem
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
        selectedItem = item.itemId
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