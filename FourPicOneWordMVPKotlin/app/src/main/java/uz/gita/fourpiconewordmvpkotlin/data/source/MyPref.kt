package uz.gita.fourpiconewordmvpkotlin.data.source

import android.content.Context
import android.content.SharedPreferences
import uz.gita.fourpiconewordmvpkotlin.app.App
import uz.gita.fourpiconewordmvpkotlin.domain.Repository

class MyPref private constructor() {
    private val preferences: SharedPreferences =
        App.appContext.getSharedPreferences("PREFERENCES", Context.MODE_PRIVATE)

    companion object {
        private lateinit var pref: MyPref

        fun init() {
            if (!this::pref.isInitialized) pref = MyPref()
        }

        fun getInstance(): MyPref {
            return pref
        }
    }
//    companion object {
//
//        private lateinit var myPref: MyPref
//
//        fun getInstance(): MyPref {
//            if (!this::myPref.isInitialized) {
//                myPref = MyPref()
//            }
//            return myPref
//        }
//    }

    fun saveQuestionPos(pos: Int) {
        preferences.edit().putInt("QUESTION_POS", pos).apply()
    }

    fun getQuestionPos(): Int {
        return preferences.getInt("QUESTION_POS", 0)
    }
}