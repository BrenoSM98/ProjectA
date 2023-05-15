@file:Suppress("DEPRECATION")

package com.example.projetoa

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView


class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val bottomNavigationView:BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.nav_home -> {

                    true
                }
                R.id.nav_profile -> {
                    bottomNavigationView.setOnClickListener{
                     val intent = Intent (this, Profile::class.java)
                    }

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