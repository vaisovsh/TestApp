package uz.infinity.dictionary.database

import android.content.Context
import android.database.Cursor

class MyDatabase private constructor(context: Context) : CopyHelper(context, "dicuz.db") {
    companion object {
        private var database: MyDatabase? = null
        fun init(context: Context) {
            database = MyDatabase(context)
        }

        fun getDatabase(): MyDatabase = database!!
    }

    fun getAllWords(): Cursor {
        System.currentTimeMillis()
        val cursor =getDatabase().rawQuery("select * from dictionary", null)
        System.currentTimeMillis()
        return cursor
    }
}



