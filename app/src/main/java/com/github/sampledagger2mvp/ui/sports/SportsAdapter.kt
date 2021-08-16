package com.github.sampledagger2mvp.ui.sports

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

import com.github.sampledagger2mvp.R
import com.github.sampledagger2mvp.model.SportsCommunities

class SportsAdapter(private val context: Context, private val list: MutableList<SportsCommunities>,
                    fragment: Fragment
): RecyclerView.Adapter<SportsAdapter.ListViewHolder>() {

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        var sportsCommunities = list[position]
        holder.name!!.setText(sportsCommunities.email)
        holder.email!!.setText(sportsCommunities.body)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.top_ccommunities_item_layout, parent, false)
        return SportsAdapter.ListViewHolder(itemView)
    }

     class ListViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var name = itemView.findViewById<TextView>(R.id.name)
        val email = itemView.findViewById<TextView>(R.id.email)

    }


}