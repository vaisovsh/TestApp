package com.example.exam.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exam.R
import com.example.exam.data.model.ContactData
import de.hdodenhof.circleimageview.CircleImageView


class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewholder>() {
    private lateinit var userItems: ArrayList<ContactData>

    fun setItems(items: ArrayList<ContactData>) {
        this.userItems = items
    }

    inner class MyViewholder(view: View) : RecyclerView.ViewHolder(view) {
        private val image: CircleImageView = view.findViewById(R.id.userImage)
        private val name: TextView = view.findViewById(R.id.name)
        private val phoneNumber: TextView = view.findViewById(R.id.phoneNumber)

        fun bind() {
            val data = userItems[adapterPosition]
            image.setImageResource(data.image)
            name.text = data.name
            phoneNumber.text = data.phoneNumber
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewholder {
        return MyViewholder(
            LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewholder, position: Int) {
        return holder.bind()
    }

    override fun getItemCount(): Int {
        return userItems.size
    }


}