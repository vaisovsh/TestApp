package uz.gita.fourpiconewordmvpkotlin.domain

import uz.gita.fourpiconewordmvpkotlin.R
import uz.gita.fourpiconewordmvpkotlin.data.model.QuestionData
import uz.gita.fourpiconewordmvpkotlin.data.source.MyPref
import java.util.*
import kotlin.collections.ArrayList

class Repository private constructor() {
    private val questionsList: MutableList<QuestionData> = ArrayList()
    private val myPref: MyPref = MyPref.getInstance()

    init {
        initQuestions()
    }

//    companion object {
//        private lateinit var repository: Repository
//
//        fun getInstance(): Repository {
//            if (!this::repository.isInitialized) {
//                repository = Repository()
//            }
//            return repository
//        }
//    }
companion object {
    private lateinit var appRepository: Repository

    fun init() {
        if (!this::appRepository.isInitialized) appRepository = Repository()
    }

    fun getInstance(): Repository {
        return appRepository
    }
}

    fun saveCurrentQuestionByPos(pos: Int) {
        myPref.saveQuestionPos(pos)
    }

    fun getCurrentQuestionData():QuestionData =
        questionsList[myPref.getQuestionPos()]

    fun getCurrentQuestionPos():Int{
        return myPref.getQuestionPos()
    }


    private fun initQuestions() {
        questionsList.add(
            QuestionData(
                mutableListOf(
                    R.drawable.pic1_1,
                    R.drawable.pic1_2,
                    R.drawable.pic1_3,
                    R.drawable.pic1_4
                ), "WORK", generateVariant("WORK")
            )
        )
        questionsList.add(
            QuestionData(
                mutableListOf(
                    R.drawable.pic2_1,
                    R.drawable.pic2_2,
                    R.drawable.pic2_3,
                    R.drawable.pic2_4
                ), "COLOR", generateVariant("COLOR")
            )
        )
        questionsList.add(
            QuestionData(
                mutableListOf(
                    R.drawable.pic3_1,
                    R.drawable.pic3_2,
                    R.drawable.pic3_3,
                    R.drawable.pic3_4
                ), "WATER", generateVariant("WATER")
            )
        )
    }

    private fun generateVariant(answer: String): String {
        val variant: MutableList<Char> = ArrayList(14)
        val letters = listOf(
            'A', 'B', 'C', 'D', 'E', 'F', 'G',
            'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U',
            'V', 'W', 'X', 'Y', 'Z'
        )
        for (i in answer) {
            variant.add(i)
        }

        val random = Random()
        for (i in answer.length until 14) {
            variant.add(letters[random.nextInt(26)])
        }
        variant.shuffle()
        val sb = StringBuilder()
        for (i in variant.indices) {
            sb.append(variant[i])
        }

        return sb.toString()
    }
}

