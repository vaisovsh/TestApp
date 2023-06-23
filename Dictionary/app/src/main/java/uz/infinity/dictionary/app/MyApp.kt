package uz.infinity.dictionary.app

import android.app.Application
import uz.infinity.dictionary.database.MyDatabase

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        MyDatabase.init(this)
    }
}