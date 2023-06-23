package uz.gita.recyclerviewpractice

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private lateinit var itemDataList: MutableList<ItemViewData>
    fun setUserListToRV(itemDataList: MutableList<ItemViewData>) {
        this.itemDataList = itemDataList
    }

    private var count: Int = 0

    abstract inner class MyViewHolder constructor(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind()
    }

    inner class FirstItemViewHolder constructor(view:View):MyViewHolder(view){
        private val name:TextView = view.findViewById(R.id.name)
        private val date:TextView = view.findViewById(R.id.date)

        override fun bind() {
            val data = itemDataList[adapterPosition] as FirstItemData
            name.text = data.name
            date.text = data.date
        }
    }

    inner class SecondItemViewHolder constructor(view:View):MyViewHolder(view){
        private val title:TextView = view.findViewById(R.id.title2)
        private val variant1:TextView = view.findViewById(R.id.tvItem1)
        private val variant2:TextView = view.findViewById(R.id.tvItem2)
        private val variant3:TextView = view.findViewById(R.id.tvItem3)
        private val variant4:TextView = view.findViewById(R.id.tvItem4)

        override fun bind() {
            val data = itemDataList[adapterPosition] as SecondItemData

            title.text = data.title
            variant1.text = data.firstVariant
            variant2.text = data.secondVariant
            variant3.text = data.thirdVariant
            variant4.text = data.fourthVariant
        }

    }

    inner class ThirdItemViewHolder constructor(view:View):MyViewHolder(view){
        private val title:TextView = view.findViewById(R.id.title3)
        private val variant1:CheckBox = view.findViewById(R.id.tvVariant1)
        private val variant2:CheckBox = view.findViewById(R.id.tvVariant2)
        private val variant3:CheckBox = view.findViewById(R.id.tvVariant3)
        private val variant4:CheckBox = view.findViewById(R.id.tvVariant4)

        override fun bind() {
            val data = itemDataList[adapterPosition] as ThirdItemData

            title.text = data.title

            variant1.text = data.firstVariant
            variant2.text = data.secondVariant
            variant3.text = data.thirdVariant
            variant4.text = data.fourthVariant
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        Log.d("TTT", "${++count}")
        return when(viewType){
            0->{
                FirstItemViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.item_view1,parent,false)
                )
            }
            1->{
                SecondItemViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.item_view2,parent,false)
                )
            }
            else ->{
                ThirdItemViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.item_view3,parent,false)
                )
            }
        }
    }

    override fun onBindViewHolder(myViewHolder: MyViewHolder, position: Int) {
        return myViewHolder.bind()
    }

    override fun getItemCount(): Int {
        return itemDataList.size
    }

    override fun getItemViewType(position: Int): Int {
        return itemDataList[position].getItemType()
    }
}
