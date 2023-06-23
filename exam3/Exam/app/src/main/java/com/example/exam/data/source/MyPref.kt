package com.example.exam.data.source

import android.content.Context
import android.content.SharedPreferences
import com.example.exam.App.App
import com.example.exam.data.model.ContactData

class MyPref private constructor(){
    private var preference: SharedPreferences = App.context.getSharedPreferences("USER_DATA",Context.MODE_PRIVATE)

    companion object{
        lateinit var myPref: MyPref

        fun getInstance() : MyPref {
            if(!this::myPref.isInitialized){
                myPref = MyPref()
            }
            return myPref
        }
    }


    fun saveData(userData :String){
        preference.edit().putString("DATA",userData).apply()
    }

    fun getData() =
        preference.getString("DATA","");

    fun saveIntroIsActive(state: Boolean){
        preference.edit().putBoolean("isActive",state).apply()
    }

    fun getIntroIsActive():Boolean{
        return preference.getBoolean("isActive",true)
    }
}