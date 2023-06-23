package uz.gita.fourpiconewordmvpkotlin.mvp.views

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import uz.gita.fourpiconewordmvpkotlin.R
import uz.gita.fourpiconewordmvpkotlin.mvp.contracts.GameContract
import uz.gita.fourpiconewordmvpkotlin.mvp.presenters.GamePresenter
import uz.gita.fourpiconewordmvpkotlin.utils.Constants.*

class GameActivity : AppCompatActivity(), GameContract.View {
    private lateinit var presenter: GameContract.Presenter

    private lateinit var questionsImg: MutableList<ImageView>
    private lateinit var variants: MutableList<TextView>
    private lateinit var answers: MutableList<TextView>

    private var ansCount = 0
    private var count = 0

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        presenter = GamePresenter(this)

        findViews()

        presenter.loadCurrentQuestion()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun findViews() {
        questionsImg = ArrayList(4)

        questionsImg.add(findViewById<ImageView>(R.id.image1))
        questionsImg.add(findViewById<ImageView>(R.id.image2))
        questionsImg.add(findViewById<ImageView>(R.id.image3))
        questionsImg.add(findViewById<ImageView>(R.id.image4))

        val parentViewGroupOfAnswers = findViewById<LinearLayout>(R.id.answers)

        answers = ArrayList(MAX_ANSWERS.value)
        for (i in 0 until MAX_ANSWERS.value) {
            val btn: TextView = parentViewGroupOfAnswers.getChildAt(i) as TextView
            btn.tag = i
            answers.add(btn)
        }

        variants = ArrayList(MAX_VARIANTS.value)
        val parentViewGroupOfVariants = findViewById<RelativeLayout>(R.id.variants)
        for (i in 0 until MAX_VARIANTS.value) {
            val btn = parentViewGroupOfVariants.getChildAt(i)
            btn.tag = i
            variants.add(btn as TextView)
        }

        addClickActions()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun addClickActions() {
        for (i in 0 until MAX_VARIANTS.value) {
            variants[i].setOnClickListener {
                if (count<ansCount){
                val st = (it as TextView).text
                it.setBackgroundResource(R.drawable.shadow_answers_default)

                presenter.variantBtnClick(st.toString())
                (it as TextView).isClickable = false
                count++
                Log.d("SSS", "addClickActions: $count va anscountm:$ansCount")
                if (count==ansCount){

                    presenter.checkAnswerm()
                }}
            }
        }


        for (i in 0 until MAX_ANSWERS.value) {
            answers[i].setOnClickListener {ansver->
                val st = (ansver as TextView).text
                presenter.answerBtnClick(st.toString())
                count--
                ansver.setBackgroundResource(R.drawable.bg_answers)
                ansver.isClickable = false
                ansver.text = ""
                if (count<ansCount)
                    answers.forEach { it.setTextColor(getColor(R.color.white))}
                }
            }
        }


    override fun showQuestionImagesToView(questionImages: List<Int>) {
        for (i in 0 until MAX_IMAGES.value) {
            this.questionsImg[i].setImageResource(questionImages[i])
        }
    }

    override fun showVariantsToView(variant: String) {
        for (i in 0 until MAX_VARIANTS.value) {
            variants[i].text = variant[i].toString()
        }
    }

    override fun setVisibilityToAnswer(answerLength: Int) {
        //ansverlani nicca javobliqini orsatadi qolganini gone qiladi

        ansCount = answerLength

        for (i in 0 until answerLength) {
            answers[i].visibility = View.VISIBLE
        }

        for (i in answerLength until MAX_ANSWERS.value) {
            answers[i].visibility = View.GONE
        }
    }

    override fun clearOldData() {
        for (answerBtn in answers) {
            answerBtn.text = ""
        }

        for (variantBtn in variants) {
            variantBtn.isEnabled = true
        }
    }

    override fun closeActivity() {
        finish()
    }

    override fun showDialog() {
//        val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(this)
//            .setCancelable(false)
//            .setTitle("Congratulations!")
//            .setMessage("Siz yutdingiz, o'yinni davom etirasizmi?")
//            .setPositiveButton("Ha") { dialogInterface, i ->
//                presenter.loadNextQuestion()
//                dialogInterface.cancel()
//            }
//            .setNegativeButton("Yo'q"){dialogInterface, i ->
//                dialogInterface.cancel()
//                presenter.finishActivity()
//            }
//
//        val alertDialog = dialogBuilder.create()
//        alertDialog.show()
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.custom_finish_dialog)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val btnFinish: AppCompatButton = dialog.findViewById(R.id.textViewFinish)
        val txtTotal: TextView = dialog.findViewById(R.id.txt_TotalCoins)
        txtTotal.text = "Your total coin is 20coin"

        btnFinish.setOnClickListener {
            dialog.dismiss()
            clearOldData()
            presenter.loadNextQuestion()
            reloadVariants()
            count = 0
//            this.finish()   hozr utgannan kn taza malumotlani jaylab izinnan pasotsiyani saqlab qoyamz
        }
        dialog.create()
        dialog.show()
    }

    override fun setTextToAnswer(pos: Int, letter: String) {
        answers[pos].text = letter
        answers[pos].isClickable = true
    }


    override fun setEnabledVariantByPos(pos: Int, state: Boolean) {
        variants[pos].isEnabled = state
    }

    override fun wrongAnswerAnimation() {
        YoYo.with(Techniques.Shake).duration(600).playOn(findViewById(R.id.answers))
    }


    override fun setWrongColorToAnswers() {

        for(i in 0 until MAX_ANSWERS.value){
            answers[i].setTextColor(resources.getColor(R.color.red))
        }
    }

    override fun setDefaultColorToAnswers() {
        for(i in 0 until MAX_ANSWERS.value){
            answers[i].setTextColor(resources.getColor(R.color.white))
        }
    }

    override fun getFirstEmptyPos(): Int {
        for (i in answers.indices){
            if (answers[i].visibility==View.VISIBLE && answers[i].text.isEmpty()){
                return i
            }
        }
        return -1
    }

    override fun undotextfromanswer(stringm: String) {
        for (i in variants.indices){
            Log.d("SSS", "undotextfromanswer stringm: ${stringm} ,varinati ${(variants[i] as TextView).text.toString()}")
            if (variants[i].text.toString().equals(stringm) && !variants[i].isClickable){
                variants[i].isClickable = true
            variants[i].setBackgroundResource(R.drawable.bg_variants)
            break}
        }
    }
    fun reloadVariants(){
        variants.forEach {
            it.setBackgroundResource(R.drawable.bg_variants)
            it.isClickable = true }
    }

    override fun checkAnswers(string: String) {
        val sb = StringBuilder()
        answers.forEach {
            sb.append(it.text.toString())
        }

        if (string.equals(sb.toString())){
            showDialog()
        }else{
            Toast.makeText(this,"wrong!!!",Toast.LENGTH_SHORT).show()
            wrongAnswerAnimation()
            setWrongColorToAnswers()
        }
    }



    override fun onBackPressed() {
        super.onBackPressed()
        presenter.finishActivity()
    }
}