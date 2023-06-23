package uz.gita.fourpiconewordmvpkotlin.mvp.views

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import uz.gita.fourpiconewordmvpkotlin.R
import uz.gita.fourpiconewordmvpkotlin.mvp.contracts.MainContract
import uz.gita.fourpiconewordmvpkotlin.mvp.presenters.MainPresenter
import uz.gita.fourpiconewordmvpkotlin.utils.Constants.*

class MainActivity : AppCompatActivity(), MainContract.View {
    private lateinit var playButton: AppCompatButton
    private lateinit var aboutButton: AppCompatButton
    private lateinit var questionsImg: MutableList<ImageView>
    private lateinit var currentQuestionPos: AppCompatTextView

    private lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this)
        findViews()
        connectClickActions()
    }

    override fun onResume() {
        super.onResume()
        presenter.loadCurrentQuestion()
    }

    private fun findViews() {
        questionsImg = ArrayList()

        questionsImg.add(findViewById<ImageView>(R.id.image1))
        questionsImg.add(findViewById<ImageView>(R.id.image2))
        questionsImg.add(findViewById<ImageView>(R.id.image3))
        questionsImg.add(findViewById<ImageView>(R.id.image4))

        currentQuestionPos = findViewById<AppCompatTextView>(R.id.textQuestionPos)

        playButton = findViewById<AppCompatButton>(R.id.buttonPlay)
        aboutButton = findViewById<AppCompatButton>(R.id.buttonAbout)
    }

    private fun connectClickActions() {
        playButton.setOnClickListener {
            presenter.startGameActivity()
        }

        aboutButton.setOnClickListener {
            Toast.makeText(this, "About btn does not work", Toast.LENGTH_SHORT).show()
        }
    }

    override fun setImagesToView(images: List<Int>) {
        for (i in 0 until MAX_IMAGES.value) {
            questionsImg[i].setImageResource(images[i])
        }
    }

    @SuppressLint("SetTextI18n")
    override fun setQuestionPos(pos: Int) {
        currentQuestionPos.text = (pos + 1).toString()
    }

    override fun goToGameActivity() {
        startActivity(Intent(this@MainActivity, GameActivity::class.java))
    }
}