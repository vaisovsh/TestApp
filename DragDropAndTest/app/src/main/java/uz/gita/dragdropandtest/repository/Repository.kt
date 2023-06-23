package uz.gita.dragdropandtest.repository

import uz.gita.dragdropandtest.data.QuestionData

interface Repository {
    fun getNextQuestion():QuestionData

}