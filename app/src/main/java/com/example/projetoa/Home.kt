

package com.example.projetoa

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
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
                     val intent = Intent (this, Profile::class.java)
                        startActivity(intent)
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
        val imageViews: List<ImageView> = listOf(
            findViewById(R.id.imageView1),
            findViewById(R.id.imageView2),
            findViewById(R.id.imageView3),
            findViewById(R.id.imageView4),
            findViewById(R.id.imageView5),
            findViewById(R.id.imageView6),
            findViewById(R.id.imageView7),
            findViewById(R.id.imageView8),
            findViewById(R.id.imageView9),
            findViewById(R.id.imageView10),
            findViewById(R.id.imageView11),
            findViewById(R.id.imageView12)
        )

        val imagens = listOf(R.drawable.lana, R.drawable.megan, R.drawable.angelina, R.drawable.nicole, R.drawable.yvonne, R.drawable.mia, R.drawable.kid, R.drawable.birulinho, R.drawable.moro, R.drawable.nine, R.drawable.xandao, R.drawable.saitama)

        for (i in imageViews.indices) {
            Glide.with(this)
                .load(imagens[i])
                .apply(RequestOptions.bitmapTransform(CircleCrop()))
                .into(imageViews[i])
        }
    }
}