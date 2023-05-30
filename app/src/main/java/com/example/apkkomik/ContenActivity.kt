package com.example.apkkomik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ContenActivity : AppCompatActivity() {

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENTS"
    }

    private var gridLayoutManager : GridLayoutManager? = null
    private var gpList = mutableListOf<GP>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conten)

        val btnteam = findViewById<Button>(R.id.btnteam)
        btnteam.setOnClickListener {
            val intent = Intent(this, Team::class.java)
            startActivity(intent)
        }


        gpList = ArrayList()


        val recyclerView = findViewById<RecyclerView>(R.id.RecyclerViewRIDER)
        gridLayoutManager = GridLayoutManager(applicationContext, 2,
            LinearLayoutManager.VERTICAL,false)

        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)
        recyclerView.adapter = RecyclerViewGpAdapter(this, gpList){
            val intent = Intent(this, DetailRider::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }

        GPlistData()

    }

    private fun GPlistData(){
        var gp_view = GP(
            R.drawable.fb1,
            "Francesco",
            "Bagnaia",
            "Ducati Lenovo Team",
            "Bike : Ducati\n" +
                    "Date of Birth : 1997-01-14\n" +
                    "Place of Birth : Torino\n" +
                    "Height : 176 cm | Weight : 67 kg",)
            gpList.add(gp_view)

        gp_view = GP(
            R.drawable.fb1,
            "",
            "",
            "",
            "",)
            gpList.add(gp_view)

        gp_view = GP(
            R.drawable.fb1,
            "",
            "",
            "",
            "")
            gpList.add(gp_view)

        gp_view = GP(
            R.drawable.fb1,
            "",
            "",
            "",
            "")
            gpList.add(gp_view)

        gp_view = GP(
            R.drawable.fb1,
            "",
            "",
            "",
            "")
            gpList.add(gp_view)
    }
}