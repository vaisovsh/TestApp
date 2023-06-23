package uz.infinity.dictionary

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.infinity.dictionary.adapter.CursorAdapter
import uz.infinity.dictionary.database.MyDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var database: MyDatabase
    private lateinit var adapter: CursorAdapter
    private lateinit var handle: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database = MyDatabase.getDatabase()
        val cursor = database.getAllWords()
        adapter = CursorAdapter(cursor)

        val rv = findViewById<RecyclerView>(R.id.dictionaryList)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter

        handle = Handler(Looper.getMainLooper())
        val searchView = findViewById<SearchView>(R.id.searchView)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.d("TTT", "query = $query")
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                handle.removeCallbacksAndMessages(null)
                handle.postDelayed({
                    Log.d("TTT", "newText = $newText")
                }, 3000)
                return true
            }
        })
    }
}


