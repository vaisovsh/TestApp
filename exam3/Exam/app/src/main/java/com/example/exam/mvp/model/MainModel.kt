package com.example.exam.mvp.model

import com.example.exam.Repository.Repository
import com.example.exam.data.model.ContactData
import com.example.exam.mvp.contracts.MainContracts

class MainModel : MainContracts.Model{
    val repository = Repository.getInstance()

    override fun saveListData(list: ArrayList<ContactData>) {
        repository.saveListData(list)
    }

    override fun getListData(): ArrayList<ContactData> {
        return repository.getListData()
    }
}