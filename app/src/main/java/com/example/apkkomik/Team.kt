package com.example.apkkomik

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth

class Team : AppCompatActivity() {

    private var gridLayoutManager : GridLayoutManager? = null
    private var teamList = mutableListOf<GP>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team)

        val rider = findViewById<ImageView>(R.id.home)
        rider.setOnClickListener {
            val intent = Intent(this, home::class.java)
            startActivity(intent)
        }

        val team = findViewById<ImageView>(R.id.team)
        team.setOnClickListener {
            val intent = Intent(this, Team::class.java)
            startActivity(intent)
        }

        val cal = findViewById<ImageView>(R.id.calender)
        cal.setOnClickListener {
            val intent = Intent(this, calender::class.java)
            startActivity(intent)
        }

        val log = findViewById<ImageView>(R.id.logout)
        log.setOnClickListener {
            logout()
        }

        teamList = ArrayList()


        val recyclerView = findViewById<RecyclerView>(R.id.RecyclerViewTEAM)
        gridLayoutManager = GridLayoutManager(applicationContext, 1,
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
            R.drawable.aprilia,
            "",
            "",
            "",
            "",
        )
        teamList.add(gp_view)

        gp_view = GP(
            R.drawable.honda,
            "",
            "",
            "",
            "",
        )
        teamList.add(gp_view)

        gp_view = GP(
            R.drawable.gasgas,
            "",
            "",
            "",
            "",
        )
        teamList.add(gp_view)

        gp_view = GP(
            R.drawable.gresini,
            "",
            "",
            "",
            "",
        )
        teamList.add(gp_view)

        gp_view = GP(
            R.drawable.lcr,
            "",
            "",
            "",
            "",
        )
        teamList.add(gp_view)

        gp_view = GP(
            R.drawable.rnf,
            "",
            "",
            "",
            "",
        )
        teamList.add(gp_view)

        gp_view = GP(
            R.drawable.yamaha,
            "",
            "",
            "",
            "",
        )
        teamList.add(gp_view)
    }

    //    Function signOut dari akun dan berpindah halaman dengan memangggil function navigateToLoginPage
    private fun logout() {
        FirebaseAuth.getInstance().signOut()
        navigateToLoginPage()
    }

    //    Function untuk berpindah halaman
    private fun navigateToLoginPage() {
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
}


