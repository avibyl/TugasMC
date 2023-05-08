@file:Suppress("DEPRECATION")

package com.example.apkkomik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailRider : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_rider)

        val detail = intent.getParcelableExtra<GP>(ContenActivity.INTENT_PARCELABLE)

        val img = findViewById<ImageView>(R.id.iDetail)
        val nama = findViewById<TextView>(R.id.dDetail)
        val bl = findViewById<TextView>(R.id.bDetail)
        val tm = findViewById<TextView>(R.id.tDetail)
        val dc = findViewById<TextView>(R.id.decDetail)

        img.setImageResource(detail!!.imgGp)
        nama.text = detail.nama
        bl.text = detail.belakang
        tm.text = detail.team
        dc.text = detail.Deskripsi

        val back = findViewById<ImageView>(R.id.kembali)
        back.setOnClickListener {
            val intent = Intent(this, ContenActivity::class.java)
            startActivity(intent)
            }

        }
}