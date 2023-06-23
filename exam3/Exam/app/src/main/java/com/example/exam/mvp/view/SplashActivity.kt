package com.example.exam.mvp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exam.R
import com.example.exam.mvp.contracts.SplashContract
import com.example.exam.mvp.presenter.SplashPresenter
import java.util.*

class SplashActivity : AppCompatActivity(), SplashContract.View {
    private lateinit var presenter: SplashContract.Presenter
    private lateinit var time: Timer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        presenter = SplashPresenter(this)
        entering()
    }

    override fun entering() {
        presenter.startActivity()
    }

    override fun openActivity(number: Int) {
        time = Timer()
        time.schedule(object : TimerTask() {
            override fun run() {
                if(number == 1){
                    val act = Intent(this@SplashActivity, IntroActivity::class.java)
                    startActivity(act)
                    finish()
                }else{
                    val act = Intent(this@SplashActivity,MainActivity::class.java)
                    startActivity(act)
                    finish()
                }
            }
        }, 2000)
    }
}