package com.example.apkkomik

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth

class calender : AppCompatActivity() {
    private var gridLayoutManager : GridLayoutManager? = null
    private var calsList = mutableListOf<DataCalender>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calender)

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

        calsList = ArrayList()


        val recyclerView = findViewById<RecyclerView>(R.id.RecyclerViewCALENDER)
        gridLayoutManager = GridLayoutManager(applicationContext, 1,
            LinearLayoutManager.VERTICAL,false)

        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)
        recyclerView.adapter = CalenderAdapter(this, calsList){
            val intent = Intent(this, calender::class.java)
            startActivity(intent)
        }

        GPlistData()

    }
    private fun GPlistData() {
        var calender = DataCalender(
            R.drawable.gpspain,

        )
        calsList.add(calender)

        calender = DataCalender(
            R.drawable.prancis,
           
        )
        calsList.add(calender)

        calender = DataCalender(
            R.drawable.italy,
           
        )
        calsList.add(calender)

        calender = DataCalender(
            R.drawable.german,

            )
        calsList.add(calender)

        calender = DataCalender(
            R.drawable.belanda,

            )
        calsList.add(calender)

        calender = DataCalender(
            R.drawable.uk,

            )
        calsList.add(calender)

        calender = DataCalender(
            R.drawable.austria,

            )
        calsList.add(calender)

        calender = DataCalender(
            R.drawable.catalunya,

            )
        calsList.add(calender)

        calender = DataCalender(
            R.drawable.rimini,

            )
        calsList.add(calender)

        calender = DataCalender(
            R.drawable.india,

            )
        calsList.add(calender)

        calender = DataCalender(
            R.drawable.japan,

            )
        calsList.add(calender)

        calender = DataCalender(
            R.drawable.indonesia,

            )
        calsList.add(calender)

        calender = DataCalender(
            R.drawable.australia,

            )
        calsList.add(calender)

        calender = DataCalender(
            R.drawable.thailand,

            )
        calsList.add(calender)

        calender = DataCalender(
            R.drawable.malaysia,

            )
        calsList.add(calender)

        calender = DataCalender(
            R.drawable.qatar,

            )
        calsList.add(calender)

        calender = DataCalender(
            R.drawable.valencia,

            )
        calsList.add(calender)
        
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


