package com.studioneko.helppls

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ColorsAdapter(private val dataSet: List<RvItem>) :
    RecyclerView.Adapter<ColorsAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val nameText: TextView
        val priceText: TextView

        init{
            nameText = view.findViewById(R.id.nameText)
            priceText = view.findViewById(R.id.priceText)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_colors, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataSet[position]
        holder.nameText.text = item.nameText
        holder.priceText.text = item.priceText
    }

    override fun getItemCount(): Int {
        return dataSet.count()
    }
}