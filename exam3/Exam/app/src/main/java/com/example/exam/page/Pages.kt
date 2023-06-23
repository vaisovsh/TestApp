package com.example.exam.page

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.exam.R

class Pages: Fragment(R.layout.page1) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val imageId = view.findViewById<ImageView>(R.id.image)
        val textId = view.findViewById<TextView>(R.id.textId)

        when(requireArguments().getInt("Position")){
            0 ->{
                imageId.setImageResource(R.drawable.pic1)
                textId.setText(R.string.text1)
            }
            1 ->{
                imageId.setImageResource(R.drawable.pic2)
                textId.setText(R.string.text2)
            }
            else ->{
                imageId.setImageResource(R.drawable.pic3)
                textId.setText(R.string.text3)
            }
        }
    }
}