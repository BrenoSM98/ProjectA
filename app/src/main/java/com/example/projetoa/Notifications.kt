package com.example.projetoa

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class Notifications : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    private var selectedItem = R.id.nav_notifications

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifications)

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
                    val intent = Intent (this, Profile::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_notifications -> {
                    true
                }
                else -> false
            }
        }
    }
}