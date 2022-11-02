package com.university.test3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class tracklistAdapter(
    private val trackList: ArrayList<TrackTitles>
) : RecyclerView.Adapter<tracklistAdapter.vHolder>() {
    class vHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvTrack: TextView = itemView.findViewById(R.id.tvSongTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): vHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item2, parent, false)
        return vHolder(itemView)
    }

    override fun onBindViewHolder(holder: vHolder, position: Int) {
        val curItem = trackList[position]
        holder.tvTrack.text = curItem.track
    }

    override fun getItemCount() = trackList.size
}