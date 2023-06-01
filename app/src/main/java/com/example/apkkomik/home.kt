package com.example.apkkomik

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apkkomik.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class home : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENTS"
    }

    private var gridLayoutManager : GridLayoutManager? = null
    private var gpList = mutableListOf<GP>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

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
                    "Height : 176 cm | Weight : 67 kg\n" +
                    "World Championship Titles : 1 MotoGP | 1 Moto2",)
            gpList.add(gp_view)

        gp_view = GP(
            R.drawable.mm,
            "Marc",
            "Marquez",
            "Repsol Honda Team",
            "Bike : Honda\n" +
                    "Date of Birth : 1993-02-17\n" +
                    "Place of Birth : Carvera\n" +
                    "Height : 169 cm | Weight : 64 kg" +
                    "World Championship Titles : 6 MotoGP | 1 Moto2 | 1 125cc",)
            gpList.add(gp_view)

        gp_view = GP(
            R.drawable.fq,
            "Fabio",
            "Quartararo",
            "Yamaha Racing Team",
            "Bike : Yamaha\n" +
                    "Date of Birth : 1999-04-20\n" +
                    "Place of Birth : Nice\n" +
                    "Height : 169 cm | Weight : 64 kg" +
                    "World Championship Titles : 1 MotoGP",)
            gpList.add(gp_view)

        gp_view = GP(
            R.drawable.af,
            "Aleix",
            "Espargaro",
            "Aprilia Racing ",
            "Bike : Aprilia\n" +
                    "Date of Birth : 1997-01-14\n" +
                    "Place of Birth : Granollers\n" +
                    "Height : 176 cm | Weight : 67 kg" +
                    "World Championship Titles : 0 All Categories",)
            gpList.add(gp_view)

        gp_view = GP(
            R.drawable.ar,
            "Alex",
            "Rinz",
            "LCR Honda Castrol",
            "Bike : Honda\n" +
                    "Date of Birth : 1995-12-08\n" +
                    "Place of Birth : Barcelona\n" +
                    "Height : 176 cm | Weight : 72 kg" +
                    "World Championship Titles : 0 All Categories",)
            gpList.add(gp_view)

        gp_view = GP(
            R.drawable.bb,
            "Brand",
            "Binder",
            "Red Bull KTM Factory Racing",
            "Bike : KTM\n" +
                    "Date of Birth : 1995-08-11\n" +
                    "Place of Birth : Potchefstroom\n" +
                    "Height : 170 cm | Weight : 63 kg" +
                    "World Championship Titles : 1 Moto3",)
        gpList.add(gp_view)

        gp_view = GP(
            R.drawable.af,
            "Augusto",
            "Fernandez",
            "GASGAS Factory Racing Tech 3",
            "Bike : GASGAS\n" +
                    "Date of Birth : 1997-01-14\n" +
                    "Place of Birth : Torino\n" +
                    "Height : 176 cm | Weight : 67 kg",)
        gpList.add(gp_view)

        gp_view = GP(
            R.drawable.eb,
            "Enea",
            "Bastianini",
            "Ducati Lenovo Team",
            "Bike : Ducati\n" +
                    "Date of Birth : 1997-01-14\n" +
                    "Place of Birth : Torino\n" +
                    "Height : 176 cm | Weight : 67 kg",)
        gpList.add(gp_view)

        gp_view = GP(
            R.drawable.fd,
            "Fabio",
            "Di Giannantonio",
            "Geresini Racing MotoGp",
            "Bike : Ducati\n" +
                    "Date of Birth : 1997-01-14\n" +
                    "Place of Birth : Torino\n" +
                    "Height : 176 cm | Weight : 67 kg",)
        gpList.add(gp_view)

        gp_view = GP(
            R.drawable.fm,
            "Franco",
            "Morbideli",
            "Monster Energy Yamaha MotoGP",
            "Bike : YAHAMA\n" +
                    "Date of Birth : 1997-01-14\n" +
                    "Place of Birth : Torino\n" +
                    "Height : 176 cm | Weight : 67 kg",)
        gpList.add(gp_view)

        gp_view = GP(
            R.drawable.il,
            "Iker",
            "Lecuona",
            "Repsol Honda Team",
            "Bike : Honda\n" +
                    "Date of Birth : 1997-01-14\n" +
                    "Place of Birth : Torino\n" +
                    "Height : 176 cm | Weight : 67 kg",)
        gpList.add(gp_view)

        gp_view = GP(
            R.drawable.jf,
            "Jonas",
            "Folger",
            "GASGAS Factory Racing Tech 3",
            "Bike : GASGAS\n" +
                    "Date of Birth : 1997-01-14\n" +
                    "Place of Birth : Torino\n" +
                    "Height : 176 cm | Weight : 67 kg",)
        gpList.add(gp_view)

        gp_view = GP(
            R.drawable.jm,
            "Joan",
            "Mir",
            "Racing Honda Team",
            "Bike : Honda\n" +
                    "Date of Birth : 1997-01-14\n" +
                    "Place of Birth : Torino\n" +
                    "Height : 176 cm | Weight : 67 kg",)
        gpList.add(gp_view)

        gp_view = GP(
            R.drawable.jmm,
            "Jack",
            "Miller",
            "Red bull KTM Factory Racing",
            "Bike : KTM\n" +
                    "Date of Birth : 1997-01-14\n" +
                    "Place of Birth : Torino\n" +
                    "Height : 176 cm | Weight : 67 kg",)
        gpList.add(gp_view)

        gp_view = GP(
            R.drawable.jmmm,
            "Jorge",
            "Martin",
            "Prima Pramac Racing",
            "Bike : Ducati\n" +
                    "Date of Birth : 1997-01-14\n" +
                    "Place of Birth : Torino\n" +
                    "Height : 176 cm | Weight : 67 kg",)
        gpList.add(gp_view)

        gp_view = GP(
            R.drawable.jz,
            "Johann",
            "Zarco",
            "Prima Pramac Racing",
            "Bike : Ducati\n" +
                    "Date of Birth : 1997-01-14\n" +
                    "Place of Birth : Torino\n" +
                    "Height : 176 cm | Weight : 67 kg",)
        gpList.add(gp_view)

        gp_view = GP(
            R.drawable.lm,
            "Luca",
            "Marini",
            "Mooney VR46 Racing Team",
            "Bike : Ducati\n" +
                    "Date of Birth : 1997-01-14\n" +
                    "Place of Birth : Torino\n" +
                    "Height : 176 cm | Weight : 67 kg",)
        gpList.add(gp_view)

        gp_view = GP(
            R.drawable.ls,
            "Lorenzo",
            "Savadori",
            "Aprilia Racing",
            "Bike : Aprilia\n" +
                    "Date of Birth : 1997-01-14\n" +
                    "Place of Birth : Torino\n" +
                    "Height : 176 cm | Weight : 67 kg",)
        gpList.add(gp_view)

        gp_view = GP(
            R.drawable.mb,
            "Marco",
            "Bezzecchi",
            "Mooney VR46 Racing Team",
            "Bike : Ducati\n" +
                    "Date of Birth : 1997-01-14\n" +
                    "Place of Birth : Torino\n" +
                    "Height : 176 cm | Weight : 67 kg",)
        gpList.add(gp_view)

        gp_view = GP(
            R.drawable.mo,
            "Miguel",
            "Oliviera",
            "CryptoDATA RNF MotoGP Team",
            "Bike : Yamaha\n" +
                    "Date of Birth : 1997-01-14\n" +
                    "Place of Birth : Torino\n" +
                    "Height : 176 cm | Weight : 67 kg",)
        gpList.add(gp_view)

        gp_view = GP(
            R.drawable.mp,
            "Michele",
            "Pirro",
            "Ducati Lenovo Team",
            "Bike : Ducati\n" +
                    "Date of Birth : 1997-01-14\n" +
                    "Place of Birth : Torino\n" +
                    "Height : 176 cm | Weight : 67 kg",)
        gpList.add(gp_view)

        gp_view = GP(
            R.drawable.mv,
            "Maverick",
            "Vinales",
            "Aprilia Racing",
            "Bike : Aprilia\n" +
                    "Date of Birth : 1997-01-14\n" +
                    "Place of Birth : Torino\n" +
                    "Height : 176 cm | Weight : 67 kg",)
        gpList.add(gp_view)

        gp_view = GP(
            R.drawable.tn,
            "Takaaki",
            "Nakagami",
            "LCR Honda IDEMITSU",
            "Bike : Honda\n" +
                    "Date of Birth : 1997-01-14\n" +
                    "Place of Birth : Torino\n" +
                    "Height : 176 cm | Weight : 67 kg",)
        gpList.add(gp_view)
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