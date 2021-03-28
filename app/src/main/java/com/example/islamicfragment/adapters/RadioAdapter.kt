package com.example.islamicfragment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamicfragment.Api.RadioResponse
import com.example.islamicfragment.Api.RadiosItem
import com.example.islamicfragment.R
import kotlinx.android.synthetic.main.channel.view.*
import kotlinx.android.synthetic.main.item_aya.view.*
import kotlinx.android.synthetic.main.item_sura.view.*
import java.nio.channels.Channel

class RadioAdapter(var items:List<RadiosItem?>?): RecyclerView.Adapter<RadioAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val title = itemView.title
        val play = itemView.play
        val stop = itemView.stop
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.channel,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val items = items?.get(position)
        holder.title.setText(items?.name)
        if (onPlayClickListener!=null) {
            holder.play.setOnClickListener {
                onPlayClickListener?.onItemClick(position,items!!)
            }
        }
        if (onStopClickListener!=null) {
            holder.stop.setOnClickListener {
                onStopClickListener?.onItemClick(position,items!!)
            }
        }
    }
    fun changeData( items:List<RadiosItem?>?){
        this.items = items
        notifyDataSetChanged()
    }

    var onPlayClickListener:OnItemClickListener?=null
    var onStopClickListener:OnItemClickListener?=null
    var onItemClickListener: OnItemClickListener?=null
    interface OnItemClickListener{
        fun onItemClick(position: Int, RadioUrl:RadiosItem)
    }
    override fun getItemCount(): Int {
        return items?.size?:0
    }
}