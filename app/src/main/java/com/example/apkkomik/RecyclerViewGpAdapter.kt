package com.example.apkkomik

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView


class RecyclerViewGpAdapter(
    private val context : Context,
    private val gps : List<GP>,
    private val listener : (GP) -> Unit)
: RecyclerView.Adapter<RecyclerViewGpAdapter.ResepViewHolder>() {

    class ResepViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val image = view.findViewById<ImageView>(R.id.imgGP)

        fun bindView(gp: GP, listener: (GP) -> Unit) {
            image.setImageResource(gp.imgGp)
            itemView.setOnClickListener { listener (gp) }

        }
    }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResepViewHolder =
            ResepViewHolder(
                LayoutInflater.from(context).inflate(R.layout.gp_item, parent, false)
            )

        override fun getItemCount(): Int = gps.size

        override fun onBindViewHolder(holder: ResepViewHolder, position: Int) {
            holder.bindView(gps[position], listener)
        }
    }
