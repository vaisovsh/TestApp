package com.example.exam.mvp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import com.example.exam.R
import com.example.exam.adapter.ViewPagerAdapter
import com.example.exam.mvp.contracts.IntroContracts
import com.example.exam.mvp.presenter.IntroPresenter
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator

class IntroActivity : AppCompatActivity(), IntroContracts.View {
    private lateinit var viewPager: ViewPager2
    private val viewPagerAdapter = ViewPagerAdapter(this)
    private lateinit var dots: WormDotsIndicator
    private lateinit var nextButton: Button
    private lateinit var presenter: IntroPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        findViews()
        viewPager.adapter = viewPagerAdapter
        presenter = IntroPresenter(this)
        clickEvents()

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when(position){
                    0 ->{
                        nextButton.text = "Next"
                    }
                    1 ->{
                        nextButton.text = "Next"
                    }
                    else ->{
                        nextButton.text = "Start"
                    }
                }
            }
        })

        dots.attachTo(viewPager)
    }

    private fun findViews(){
        viewPager = findViewById(R.id.viewPager)
        dots = findViewById(R.id.worm_dots_indicator)
        nextButton = findViewById(R.id.nextButton)

    }

    private fun clickEvents(){
        nextButton.setOnClickListener{
            if(viewPager.currentItem != 2){
                viewPager.currentItem ++
            }
            else{
                presenter.startButtonClicked()
            }
        }
    }

    override fun openMainActivity() {
        val intent = Intent(this@IntroActivity,MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}