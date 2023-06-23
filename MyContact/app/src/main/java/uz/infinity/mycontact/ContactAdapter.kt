package uz.infinity.mycontact

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter : ListAdapter<ContactData, ContactAdapter.ContactViewHolder>(ContactDiffUtil) {

    object ContactDiffUtil : DiffUtil.ItemCallback<ContactData>() {
        override fun areItemsTheSame(oldItem: ContactData, newItem: ContactData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ContactData, newItem: ContactData): Boolean {
            return oldItem.fullName == newItem.fullName &&
                    oldItem.img == newItem.img &&
                    oldItem.phone == newItem.phone
        }
    }

    inner class ContactViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val txtFullName = itemView.findViewById<TextView>(R.id.txtFullName)
        private val txtPhone = itemView.findViewById<TextView>(R.id.txtPhone)
        private val imgAvatar = itemView.findViewById<ImageView>(R.id.imgAvatar)

        init {

        }

        fun bind() {
            val item = getItem(adapterPosition)
            txtFullName.text = item.fullName
            txtPhone.text = item.phone
            imgAvatar.setImageResource(item.img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ContactViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false))

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind()
    }
}