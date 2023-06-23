package com.example.myapplication.ui.game

import com.example.myapplication.model.QuestionData
import com.example.myapplication.repository.AppRepository

class GameModel : GameContract.Model {
    private val repository = AppRepository.getInstance()
    private val list = ArrayList<QuestionData>()
    private var currentPos = 0

    init {
        list.addAll(repository.list)
    }

    override fun nextQuestionData(): QuestionData {
        return list[currentPos ++]
    }
}

