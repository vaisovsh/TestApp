package uz.infinity.dictionary.adapter

import android.annotation.SuppressLint
import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import uz.infinity.dictionary.R
import uz.infinity.dictionary.model.DictionaryData

class CursorAdapter(var cursor : Cursor) : Adapter<CursorAdapter.CursorViewHolder>() {

    inner class CursorViewHolder(private val view : View) :Recyc(view) {
        private val textTitle = view.findViewById<TextView>(R.id.title)
        private val textSubTitle = view.findViewById<TextView>(R.id.subTitle)
        private val imageRemember = view.findViewById<ImageView>(R.id.remember)

        fun bind(data : DictionaryData) {
            textTitle.text = data.english
            textSubTitle.text = data.uzbek
            if (data.favourite == 0) imageRemember.setImageResource(R.drawable.ic_bookmark)
            else imageRemember.setImageResource(R.drawable.ic_bookmark_select)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        CursorViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_dictionary, parent, false))

    @SuppressLint("Range")
    override fun onBindViewHolder(holder: CursorViewHolder, position: Int) {
        cursor.moveToPosition(position)
        val data = DictionaryData(
            cursor.getInt(cursor.getColumnIndex("id")),
            cursor.getString(cursor.getColumnIndex("english")),
            cursor.getString(cursor.getColumnIndex("type")),
            cursor.getString(cursor.getColumnIndex("uzbek")),
            cursor.getInt(cursor.getColumnIndex("favourite"))
        )
        holder.bind(data)
    }

    override fun getItemCount(): Int = cursor.count
}