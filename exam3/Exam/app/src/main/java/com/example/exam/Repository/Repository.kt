package com.example.exam.Repository

import com.example.exam.data.model.ContactData
import com.example.exam.data.source.MyPref

class Repository private constructor() {
    val myPref: MyPref = MyPref.getInstance()

    companion object {
        lateinit var repositpory: Repository

        fun getInstance(): Repository {
            if (!::repositpory.isInitialized) {
                repositpory = Repository()
            }
            return repositpory
        }
    }


    fun saveListData(list: ArrayList<ContactData>) {
        val sb: StringBuilder = StringBuilder()
        for (i in 0 until list.size) {
            val data = list[i]
            sb.append(data.name).append("❁").append(data.phoneNumber).append("❁").append(data.image)
                .append("●")
        }

        sb.deleteCharAt(sb.length - 1)
        saveData(sb.toString())
    }

    fun getListData(): ArrayList<ContactData> {
        val data: String? = getData()
        val result: ArrayList<ContactData> = ArrayList()
        val arr = data?.split("●")
        if (arr != null) {
            for (userData in arr) {
                val item = userData.split("❁")
                if (item[0] != "")
                    result.add(ContactData(item[0], item[1], item[2].toInt()))
            }
        }

        return result
    }


    fun saveData(userData: String) {
        myPref.saveData(userData)
    }


    fun getData() =
        myPref.getData()

    fun saveIntroIsActive(state: Boolean) {
        myPref.saveIntroIsActive(state)
    }

    fun getIntroIsActive(): Boolean {
        return myPref.getIntroIsActive()
    }
}