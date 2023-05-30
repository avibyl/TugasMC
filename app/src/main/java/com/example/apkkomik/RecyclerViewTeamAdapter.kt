package com.example.apkkomik

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewTeamAdapter (
    private val context : Context,
    private val teams : List<GP>,
    private val listener : (GP) -> Unit)
    : RecyclerView.Adapter<RecyclerViewTeamAdapter.TeamViewHolder>() {

    class TeamViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val image = view.findViewById<ImageView>(R.id.imgTeam)

        fun bindView(gp: GP, listener: (GP) -> Unit) {
            image.setImageResource(gp.imgGp)
            itemView.setOnClickListener { listener (gp) }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder =
        TeamViewHolder(
            LayoutInflater.from(context).inflate(R.layout.gp_team, parent, false)
        )

    override fun getItemCount(): Int = teams.size

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bindView(teams[position], listener)
    }
}
