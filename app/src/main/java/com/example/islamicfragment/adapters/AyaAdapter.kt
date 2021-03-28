package com.example.islamicfragment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamicfragment.R
import kotlinx.android.synthetic.main.item_aya.view.*
import kotlinx.android.synthetic.main.item_sura.view.*

class AyaAdapter(val items:List<String>): RecyclerView.Adapter<AyaAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val aya = itemView.aya
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_aya,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val aya = items[position]
        holder.aya.setText(aya+"{${position+1}}")
    }

    override fun getItemCount(): Int {
        return items.size
    }
}