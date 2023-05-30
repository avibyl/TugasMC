package com.example.apkkomik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Team : AppCompatActivity() {

    private var gridLayoutManager : GridLayoutManager? = null
    private var teamList = mutableListOf<GP>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team)

        val btnteam = findViewById<Button>(R.id.teamrider)
        btnteam.setOnClickListener {
            val intent = Intent(this, ContenActivity::class.java)
            startActivity(intent)
        }

        teamList = ArrayList()


        val recyclerView = findViewById<RecyclerView>(R.id.RecyclerViewTEAM)
        gridLayoutManager = GridLayoutManager(applicationContext, 2,
            LinearLayoutManager.VERTICAL,false)

        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)
        recyclerView.adapter = RecyclerViewGpAdapter(this, teamList){
            val intent = Intent(this, Team::class.java)
            startActivity(intent)
        }

        GPlistData()

    }
    private fun GPlistData() {
        var gp_view = GP(
            R.drawable.fb1,
            "",
            "",
            "",
            "",
        )
        teamList.add(gp_view)

        gp_view = GP(
            R.drawable.fb1,
            "",
            "",
            "",
            "",
        )
        teamList.add(gp_view)
    }
}


