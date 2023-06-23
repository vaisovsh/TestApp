package uz.gita.fourpiconewordmvpkotlin.mvp.models

import uz.gita.fourpiconewordmvpkotlin.domain.Repository
import uz.gita.fourpiconewordmvpkotlin.mvp.contracts.MainContract

class MainModel:MainContract.Model {
    private val repository:Repository = Repository.getInstance()

    override fun getCurrentQuestionPos()=
        repository.getCurrentQuestionPos()


    override fun getCurrentQuestionImages(): List<Int> {
        return repository.getCurrentQuestionData().imageQuestions
    }
}