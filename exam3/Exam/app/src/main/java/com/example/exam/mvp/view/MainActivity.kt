package com.example.exam.mvp.view

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exam.App.App
import com.example.exam.R
import com.example.exam.adapter.MyAdapter
import com.example.exam.data.model.ContactData
import com.example.exam.mvp.contracts.MainContracts
import com.example.exam.mvp.presenter.MainPresenter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import de.hdodenhof.circleimageview.CircleImageView

class MainActivity : AppCompatActivity(), MainContracts.View {
    private lateinit var addButton: FloatingActionButton
    private lateinit var placeHolder: TextView
    private lateinit var presenter: MainContracts.Presenter
    private lateinit var myAdapter: MyAdapter
    private lateinit var myRecycler: RecyclerView
    private lateinit var myItemTouchHelper: ItemTouchHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findView()
        presenter = MainPresenter(this)
        addButtonClicked()


        checkIsEmpty()

        presenter.simpleCallbackSetRecycler()
    }

    private fun checkIsEmpty() {
        val temp = presenter.getListData()
        if (temp.size != 0) {
            myAdapter = MyAdapter()
            myAdapter.setItems(presenter.getListData())
            myRecycler = findViewById(R.id.recyclerId)
            myRecycler.adapter = myAdapter
            myRecycler.layoutManager = LinearLayoutManager(this)
            myRecycler.visibility = View.VISIBLE
            placeHolder.visibility = View.GONE
        }

    }

    private fun findView() {
        addButton = findViewById(R.id.addId)
        placeHolder = findViewById(R.id.placeHolderId)
    }

    override fun addButtonClicked() {
        addButton.setOnClickListener {
            presenter.clickedAddButton()
        }
    }


    override fun setClickAction() {
        var id: Int = -1
        var lastId: Int = -1
        val dialog: Dialog = Dialog(this)
        dialog.setContentView(R.layout.bg_dialog)
        dialog.setCancelable(false)
        dialog.show()

        val fullNameId = dialog.findViewById<EditText>(R.id.fullnameId)
        val phoneNumberId = dialog.findViewById<EditText>(R.id.phoneNumberId)
        val saveButtonID = dialog.findViewById<Button>(R.id.saveId)
        val containerImages = dialog.findViewById<LinearLayout>(R.id.containerImages)

        for (i in 0 until containerImages.childCount) {
            val child = containerImages.getChildAt(i) as CircleImageView
            child.setOnClickListener {
                child.setBackgroundResource(R.drawable.bg_image)
                id = i
                if (lastId == -1) {
                    lastId = id
                } else {
                    containerImages.getChildAt(lastId).setBackgroundResource(R.color.white)
                    lastId = i
                }
            }
        }


        saveButtonID.setOnClickListener {
            dialog.dismiss()
            myRecycler = findViewById(R.id.recyclerId)
            myRecycler.visibility = View.VISIBLE
            presenter.saveListData(
                ContactData(
                    fullNameId.text.toString(), phoneNumberId.text.toString(), when (id) {
                        0 -> {
                            R.drawable.img_1
                        }
                        1 -> {
                            R.drawable.img_2
                        }
                        2 -> {
                            R.drawable.img_3
                        }
                        3 -> {
                            R.drawable.img_4
                        }
                        4 -> {
                            R.drawable.img_5
                        }
                        else -> {
                            R.drawable.img_1
                        }
                    }
                )
            )

        }

    }

    override fun userAdded(data: ArrayList<ContactData>) {
        placeHolder.visibility = View.GONE
        myAdapter = MyAdapter()
        myRecycler = findViewById(R.id.recyclerId)
        myAdapter.setItems(data)
        myRecycler.adapter = myAdapter
        myRecycler.layoutManager = LinearLayoutManager(this)

    }

    override fun itemDeletedNotify(pos: Int) {
        myAdapter.notifyItemRemoved(pos)
    }

    override fun setSimpleCallBack(callback: ItemTouchHelper.SimpleCallback) {
        myItemTouchHelper = ItemTouchHelper(callback)
        myItemTouchHelper.attachToRecyclerView(myRecycler)
    }

    override fun setListTOAdapter(list: ArrayList<ContactData>) {
        myAdapter.setItems(list)
        if (list.size == 0)
            placeHolder.visibility = View.VISIBLE
    }

    override fun itemInsertedNotify(pos: Int) {
        myAdapter.notifyItemInserted(pos)
    }


}