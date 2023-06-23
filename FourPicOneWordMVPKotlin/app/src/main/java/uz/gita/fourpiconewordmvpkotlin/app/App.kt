package uz.gita.fourpiconewordmvpkotlin.app

import android.app.Application
import android.content.Context
import uz.gita.fourpiconewordmvpkotlin.data.source.MyPref
import uz.gita.fourpiconewordmvpkotlin.domain.Repository

class App : Application() {
    companion object{
        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this

        MyPref.init()
        Repository.init()

    }
}