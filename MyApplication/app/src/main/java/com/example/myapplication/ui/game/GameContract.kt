package com.example.myapplication.ui.game

import com.example.myapplication.model.QuestionData

interface GameContract {
    interface Model {
        fun nextQuestionData() : QuestionData
    }

    interface View {
        fun describeQuestionData(data: QuestionData)
        fun showAnswer(value : String, index : Int)
        fun getFirstEmptyPos() : Int
    }

    interface Presenter {
        fun loadNextQuestion()
        fun clickVariantButton(value: String)
    }
}