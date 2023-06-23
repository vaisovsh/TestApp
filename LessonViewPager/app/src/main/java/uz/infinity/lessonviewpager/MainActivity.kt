package uz.infinity.lessonviewpager

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.viewpager2.widget.ViewPager2
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator
import uz.infinity.lessonviewpager.adapter.TaskSixAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonBack = findViewById<AppCompatImageView>(R.id.buttonBack)
        val buttonSkip = findViewById<AppCompatTextView>(R.id.buttonSkip)
        val buttonAction = findViewById<AppCompatTextView>(R.id.buttonAction)

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val adapter = TaskSixAdapter(this)
        viewPager.adapter = adapter

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
//                Toast.makeText(this@MainActivity, "POSITION = $position", Toast.LENGTH_SHORT).show()
                when (position) {
                    0 -> {
                        buttonBack.visibility = View.INVISIBLE
                        buttonSkip.visibility = View.VISIBLE
                        buttonAction.text = "Next"
                    }
                    1 -> {
                        buttonBack.visibility = View.VISIBLE
                        buttonSkip.visibility = View.VISIBLE
                        buttonAction.text = "Next"
                    }
                    else -> {
                        buttonBack.visibility = View.VISIBLE
                        buttonSkip.visibility = View.INVISIBLE
                        buttonAction.text = "Start"
                    }
                }
            }
        })

//        viewPager.unregisterOnPageChangeCallback()
//        viewPager.isUserInputEnabled = false

        buttonBack.setOnClickListener {
            viewPager.currentItem --
        }

        buttonAction.setOnClickListener {
            if (viewPager.currentItem != 2)
                viewPager.currentItem ++
        }

        val dots = findViewById<WormDotsIndicator>(R.id.worm_dots_indicator)
        dots.attachTo(viewPager)
    }
}

// dots attach vp    +
// buttonAction text
// button back
// skip

