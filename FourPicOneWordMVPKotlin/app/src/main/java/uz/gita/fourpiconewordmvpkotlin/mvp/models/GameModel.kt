package uz.gita.fourpiconewordmvpkotlin.mvp.models

import uz.gita.fourpiconewordmvpkotlin.data.model.QuestionData
import uz.gita.fourpiconewordmvpkotlin.domain.Repository
import uz.gita.fourpiconewordmvpkotlin.mvp.contracts.GameContract

class GameModel :GameContract.Model {
    private val repository = Repository.getInstance()

    override fun questionData(): QuestionData =
        repository.getCurrentQuestionData()

    override fun currentQuestionPos(): Int =
        repository.getCurrentQuestionPos()

    override fun saveCurrentQuestionPos(pos: Int) =
        repository.saveCurrentQuestionByPos(pos)
}