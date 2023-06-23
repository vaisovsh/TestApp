package uz.gita.fourpiconewordmvpkotlin.mvp.contracts

import uz.gita.fourpiconewordmvpkotlin.data.model.QuestionData

interface GameContract {

    interface Model {
        fun questionData(): QuestionData
        fun currentQuestionPos(): Int

        fun saveCurrentQuestionPos(pos: Int)
    }

    interface Presenter {
        fun loadCurrentQuestion()
        fun answerBtnClick(string: String)
        fun variantBtnClick(string: String)

        fun finishActivity()
        fun checkAnswerm()

        fun loadNextQuestion()
    }

    interface View {
        fun showQuestionImagesToView(questionImages: List<Int>)

        fun showVariantsToView(variant: String)
        fun setVisibilityToAnswer(answerLength: Int)
        fun clearOldData()
        fun closeActivity()
        fun showDialog()

        fun setTextToAnswer(pos: Int, letter: String)

        fun setEnabledVariantByPos(pos: Int, state: Boolean)

        fun wrongAnswerAnimation()

        fun setWrongColorToAnswers()

        fun setDefaultColorToAnswers()

        fun getFirstEmptyPos():Int

        fun undotextfromanswer(string: String)

        fun checkAnswers(string: String)

    }
}