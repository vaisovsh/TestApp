package com.example.exam.mvp.presenter

import android.util.Log
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.exam.data.model.ContactData
import com.example.exam.mvp.contracts.MainContracts
import com.example.exam.mvp.model.MainModel
import com.google.android.material.snackbar.Snackbar

class MainPresenter (val view : MainContracts.View): MainContracts.Presenter{
    private var model: MainContracts.Model = MainModel()
    private val dataList: ArrayList<ContactData> = model.getListData()
    private lateinit var simpleCallBack: ItemTouchHelper.SimpleCallback


    override fun saveListData(data: ContactData) {
        dataList.add(data)
        model.saveListData(dataList)

        view.userAdded(dataList)
    }

    override fun getListData(): ArrayList<ContactData> {
        return model.getListData()
    }

    override fun clickedAddButton() {
        view.setClickAction()
    }

    override fun simpleCallbackSetRecycler() {
        simpleCallBack = object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }


            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val temp = dataList[viewHolder.adapterPosition]
                dataList.removeAt(position)
                view.itemDeletedNotify(position)
                model.saveListData(dataList)
                view.setListTOAdapter(dataList)

                Snackbar.make(viewHolder.itemView,"Do you want to delete?",Snackbar.LENGTH_LONG).setAction("Undo"){
                    dataList.add(position,temp)
                    model.saveListData(dataList)
                    view.itemInsertedNotify(position)
                }.show()
            }


        }

        view.setSimpleCallBack(simpleCallBack)

    }
}


