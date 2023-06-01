package com.example.apkkomik

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class CalenderAdapter (
    private val context : Context,
    private val cals : List<DataCalender>,
    private val listener : (DataCalender) -> Unit)
    : RecyclerView.Adapter<CalenderAdapter.CalenderViewHolder>() {

    class CalenderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val image = view.findViewById<ImageView>(R.id.imgCalender)

        fun bindView(cal: DataCalender, listener: (DataCalender) -> Unit) {
            image.setImageResource(cal.img)
            itemView.setOnClickListener { listener (cal) }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalenderViewHolder =
        CalenderViewHolder(
            LayoutInflater.from(context).inflate(R.layout.gp_calender, parent, false)
        )

    override fun getItemCount(): Int = cals.size

    override fun onBindViewHolder(holder: CalenderViewHolder, position: Int) {
        holder.bindView(cals[position], listener)
    }
}
