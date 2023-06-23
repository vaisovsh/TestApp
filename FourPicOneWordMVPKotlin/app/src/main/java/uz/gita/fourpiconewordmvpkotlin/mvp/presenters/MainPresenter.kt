package uz.gita.fourpiconewordmvpkotlin.mvp.presenters

import uz.gita.fourpiconewordmvpkotlin.mvp.contracts.MainContract
import uz.gita.fourpiconewordmvpkotlin.mvp.models.MainModel

class MainPresenter constructor(private val mainView:MainContract.View):MainContract.Presenter {
    private val maiModel:MainContract.Model = MainModel()

    override fun loadCurrentQuestion() {
        mainView.setQuestionPos(maiModel.getCurrentQuestionPos())
        mainView.setImagesToView(maiModel.getCurrentQuestionImages())
    }

    override fun startGameActivity() {
        mainView.goToGameActivity()
    }


}