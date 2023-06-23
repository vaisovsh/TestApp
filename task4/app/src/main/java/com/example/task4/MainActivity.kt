package com.example.task4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var items: MutableList<Data>
    private lateinit var myAdapter: MyAdapter
    private lateinit var myRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myAdapter = MyAdapter()
        loadContactsToList()

        myRecyclerView = findViewById(R.id.myRecycleView)
        myAdapter.setUserListToRV(items)
        myRecyclerView.adapter = myAdapter
        myRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun loadContactsToList() {
        items = ArrayList()
        for ( i in 1..102){
            if (i%3==0){
                items.add(Data(R.drawable.img_1,"PEPSI","2.3"))
            }
            if (i%3==1){
                items.add(Data(R.drawable.img,"COCA COLA","3.6"))
            }
            if (i%3==2){
                items.add(Data(R.drawable.img_2,"STARBUCKS","7.9"))
            }

        }

        items.shuffle()

    }
}