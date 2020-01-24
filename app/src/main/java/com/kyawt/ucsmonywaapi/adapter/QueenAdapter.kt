package com.kyawt.ucsmonywaapi.adapter

import android.media.Image
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kyawt.ucsmonywaapi.Queen
import com.kyawt.ucsmonywaapi.R

class QueenViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
    var id = itemView.findViewById<TextView>(R.id.queen_id)
    var image = itemView.findViewById<ImageView>(R.id.queen_image)
    var name = itemView.findViewById<TextView>(R.id.queen_name)
    var voteCount = itemView.findViewById<TextView>(R.id.queen_vote_count)
}

class QueenAdapter(var queenList: List<Queen>): RecyclerView.Adapter<QueenViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QueenViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_queen, parent,false)
        return QueenViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.d("Size", queenList.size.toString())
        return queenList.size
    }

    override fun onBindViewHolder(holder: QueenViewHolder, position: Int) {
        holder.id.text = queenList[position].id
        holder.name.text = queenList[position].name
        holder.voteCount.text = queenList[position].voteCount.toString()
    }
}