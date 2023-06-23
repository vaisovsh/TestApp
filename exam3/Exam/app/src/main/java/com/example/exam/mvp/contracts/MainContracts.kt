package com.example.exam.mvp.contracts

import androidx.recyclerview.widget.ItemTouchHelper
import com.example.exam.data.model.ContactData

interface MainContracts {
    interface Model{
        fun saveListData(list: ArrayList<ContactData>)
        fun getListData() : ArrayList<ContactData>
    }
    interface Presenter{
        fun saveListData(data: ContactData)
        fun getListData() : ArrayList<ContactData>
        fun clickedAddButton()
        fun simpleCallbackSetRecycler()

    }

    interface View{
        fun addButtonClicked()
        fun setClickAction()
        fun userAdded(data: ArrayList<ContactData>)
        fun itemDeletedNotify(pos :Int)
        fun setSimpleCallBack(callback : ItemTouchHelper.SimpleCallback)
        fun setListTOAdapter(list: ArrayList<ContactData>)
        fun itemInsertedNotify(pos: Int)
    }
}