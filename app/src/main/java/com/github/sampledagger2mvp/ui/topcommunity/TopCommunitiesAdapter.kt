package com.github.sampledagger2mvp.ui.topcommunity

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

import com.github.sampledagger2mvp.R
import com.github.sampledagger2mvp.model.TopCommunities

class TopCommunitiesAdapter(private val context: Context, private val list: MutableList<TopCommunities>,
                            fragment: Fragment
): RecyclerView.Adapter<TopCommunitiesAdapter.ListViewHolder>() {

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        var topCommunities = list[position]
        holder.name!!.setText(topCommunities.name)
        holder.email!!.setText(topCommunities.email)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.top_ccommunities_item_layout, parent, false)
        return TopCommunitiesAdapter.ListViewHolder(itemView)
    }

     class ListViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var name = itemView.findViewById<TextView>(R.id.name)
        val email = itemView.findViewById<TextView>(R.id.email)

    }


}