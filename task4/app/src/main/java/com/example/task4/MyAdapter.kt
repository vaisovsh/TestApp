package com.example.task4

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private lateinit var itemDataList: MutableList<Data>
    fun setUserListToRV(itemDataList: MutableList<Data>) {
        this.itemDataList = itemDataList
    }

     inner class MyViewHolder constructor(view: View) : RecyclerView.ViewHolder(view) {
        private val img: ImageView = view.findViewById(R.id.image)
        private val textTitle: TextView = view.findViewById(R.id.textTitle)
         private val textWay: TextView=view.findViewById(R.id.masofa)

       fun bind(){
           val data = itemDataList[adapterPosition]
           img.setImageResource(data.img)
           textTitle.text=data.textTitle
           textWay.text=data.textWay

       }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int =itemDataList.size
}
