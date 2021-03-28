package com.example.islami123.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamicfragment.R
import kotlinx.android.synthetic.main.item_hadeth.view.*

class HadethAdapter(val item: List<Hadeth>): RecyclerView.Adapter<HadethAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val Hadeth = itemView.hadeth_no
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.item_hadeth,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val Hadeth = item[position]
        holder.Hadeth.setText(Hadeth.title)
        holder.Hadeth.setText(Hadeth.content)
        if (onItemClickListener!=null){
            holder.itemView.setOnClickListener {
                onItemClickListener?.onItemClick(position,content = "")
            }
        }
    }

    var onItemClickListener:OnItemClickListener?=null

    interface OnItemClickListener{
        fun onItemClick(position: Int, content: String)
    }
    override fun getItemCount(): Int {
        return item.size
    }
}