package com.example.utsprojek

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.utsprojek.DataBerita

class DetailBeritaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_berita)

        val imageViewDetail = findViewById<ImageView>(R.id.imageViewDetail)
        val tvTitleDetail = findViewById<TextView>(R.id.tvTitleDetail)
        val tvDescDetail = findViewById<TextView>(R.id.tvDescDetail)

        val title = intent.getStringExtra("title")
        val desc = intent.getStringExtra("desc")
        val imageUrl = intent.getStringExtra("imageUrl")

        tvTitleDetail.text = title
        tvDescDetail.text = desc
        Glide.with(this).load(imageUrl).into(imageViewDetail)
    }
}