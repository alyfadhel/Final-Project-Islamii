package com.example.islamicfragment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamicfragment.R
import kotlinx.android.synthetic.main.item_sura.view.*

class SurasAdapter(val items:List<String>): RecyclerView.Adapter<SurasAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val suraName = itemView.sura_name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sura,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val suraName = items[position]
        holder.suraName.setText(suraName)
        if (onItemClickListener!=null){
            holder.itemView.setOnClickListener {
                onItemClickListener?.onItemClick(position,suraName)
            }
        }
    }


    var onItemClickListener: OnItemClickListener?=null
    interface OnItemClickListener{
        fun onItemClick(position: Int, name: String)
    }
    override fun getItemCount(): Int {
        return items.size
    }
}