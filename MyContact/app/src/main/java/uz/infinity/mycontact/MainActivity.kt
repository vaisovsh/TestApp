package uz.infinity.mycontact

import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private var pos: Int = 0
    private lateinit var addButton: FloatingActionButton
    private lateinit var contactRV: RecyclerView
    private val list = ArrayList<ContactData>()
    private val adapter = ContactAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadView()
    }

    private fun loadView() {
        addButton = findViewById(R.id.btnAdd)
        contactRV = findViewById(R.id.contactList)

        contactRV.adapter = adapter
        contactRV.layoutManager = LinearLayoutManager(this)
        val helper = object : ItemTouchHelper.SimpleCallback(UP or DOWN, LEFT or RIGHT) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                TODO("Not yet implemented")
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                if (direction == LEFT) Toast.makeText(this@MainActivity, "LEFT", Toast.LENGTH_SHORT).show()
                else Toast.makeText(this@MainActivity, "RIGHT", Toast.LENGTH_SHORT).show()
            }
        }
        val itemTouchHelper = ItemTouchHelper(helper)
        itemTouchHelper.attachToRecyclerView(contactRV)
        clickOrEvent()
    }

    private fun clickOrEvent() {
        addButton.setOnClickListener {
            Log.d("TTT", "click")
            val addDialog = CustomAddDialog(this)
            addDialog.setDialogListener { name, phone ->
                val contactData = ContactData(pos++, R.drawable.ic_user, name, phone)
                list.add(contactData)
                adapter.submitList(list)
            }
            addDialog.show()
        }
    }


}