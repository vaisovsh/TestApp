package com.example.myapplication.repository

import com.example.myapplication.R
import com.example.myapplication.model.QuestionData

class AppRepository private constructor() {
    companion object {
        private lateinit var instance: AppRepository  // ! null

        fun getInstance(): AppRepository {
            if (!(::instance.isInitialized))
                instance = AppRepository()
            return instance
        }
    }

    val list = ArrayList<QuestionData>()

    init {
        loadData()
    }

    private fun loadData() {
        list.add(
            QuestionData(
                R.drawable.ananas,
                R.drawable.apple,
                R.drawable.pomegranate,
                R.drawable.banana,
                "AFKFDPRUOYGHIPIT",
                "FRUIT"
            )
        )

        list.add(
            QuestionData(
                R.drawable.ferrari_1,
                R.drawable.ferrari_2,
                R.drawable.ferrari_3,
                R.drawable.ferrari_4,
                "FLLEROUFRJRAIROI",
                "FERRARI"
            )
        )
    }
}






