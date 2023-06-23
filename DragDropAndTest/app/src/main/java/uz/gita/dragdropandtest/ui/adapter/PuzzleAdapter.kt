package uz.gita.dragdropandtest.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.gita.dragdropandtest.R
import java.util.Objects

class PuzzleAdapter: ListAdapter<Int, PuzzleAdapter.MyViewHolder>(MyDiffUtil) {
    object MyDiffUtil : DiffUtil.ItemCallback<Int>() {
        override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == newItem
        }

    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val image = itemView.findViewById<ImageView>(R.id.item)

        fun bind() {
            val data = getItem(adapterPosition)
            image.setImageResource(data)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind()
    }
}