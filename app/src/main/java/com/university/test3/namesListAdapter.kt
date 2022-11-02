package com.university.test3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class namesListAdapter (
    private val context: Context,
    private val names: List<AlbumNames>,
    val listener: (AlbumNames) -> Unit
) : RecyclerView.Adapter<namesListAdapter.vHolder>()
{
    class vHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val coverImg: ImageView = itemView.findViewById(R.id.albumCover)
        val tvName: TextView = itemView.findViewById(R.id.tvAlbumName)

        fun bindView(name: AlbumNames, listener: (AlbumNames) -> Unit){
            coverImg.setImageResource(name.cover)
            tvName.text = name.name
            itemView.setOnClickListener { listener(name) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): vHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item1, parent, false)
        return vHolder(itemView)
    }

    override fun onBindViewHolder(holder: vHolder, position: Int) {
        holder.bindView(names[position],listener)
        val curItem = names[position]
        holder.coverImg.setImageResource(curItem.cover)
        holder.tvName.text = curItem.name
    }

    override fun getItemCount() = names.size
}