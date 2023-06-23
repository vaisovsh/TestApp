package uz.gita.dragdropandtest.repository.repositoryImpl

import uz.gita.dragdropandtest.R
import uz.gita.dragdropandtest.data.QuestionData
import uz.gita.dragdropandtest.repository.Repository

class RepositoryImpl : Repository {

    private var pos = 0
    private lateinit var questions: MutableList<QuestionData>

    init {
        loadQuestions()
    }

    private fun loadQuestions() {
        questions = ArrayList()
        questions.add(
            QuestionData(
                R.drawable.mult1,
                listOf(
                    R.drawable.mult1_1,
                    R.drawable.mult1_2,
                    R.drawable.mult1_3,
                    R.drawable.mult1_4,
                    R.drawable.mult1_5,
                ),
                listOf(
                    R.drawable.mult1_1,
                    R.drawable.mult1_2,
                    R.drawable.mult1_3,
                    R.drawable.mult1_4,
                    R.drawable.mult1_5,
                )
            )
        )
        questions.add(
            QuestionData(
                R.drawable.mult2,
                listOf(
                    R.drawable.mult2_1,
                    R.drawable.mult2_2,
                    R.drawable.mult2_3,
                    R.drawable.mult2_4,
                    R.drawable.mult2_5,
                ),
                listOf(
                    R.drawable.mult2_1,
                    R.drawable.mult2_2,
                    R.drawable.mult2_3,
                    R.drawable.mult2_4,
                    R.drawable.mult2_5,
                )
            )
        )
        questions.add(
            QuestionData(
                R.drawable.mult3,
                listOf(
                    R.drawable.mult3_1,
                    R.drawable.mult3_2,
                    R.drawable.mult3_3,
                    R.drawable.mult3_4,

                    ),
                listOf(
                    R.drawable.mult3_1,
                    R.drawable.mult3_2,
                    R.drawable.mult3_3,
                    R.drawable.mult3_4,
                )
            )
        )
        questions.add(
            QuestionData(
                R.drawable.mult4,
                listOf(
                    R.drawable.mult4_1,
                    R.drawable.mult4_2,
                    R.drawable.mult4_3,
                    R.drawable.mult4_4,
                    R.drawable.mult4_5

                    ),
                listOf(
                    R.drawable.mult4_1,
                    R.drawable.mult4_2,
                    R.drawable.mult4_3,
                    R.drawable.mult4_4,
                    R.drawable.mult4_5

                )
            )
        )


    }


    override fun getNextQuestion(): QuestionData {
        val list = ArrayList(
            questions[pos].questionList
        )
        list.shuffle()
        val data = QuestionData(questions[pos].answer, list, questions[pos].answerList)
        increasePosition()
        return data

    }

    private fun increasePosition() {
        pos++
        if (pos == 3) pos = 0
    }

}