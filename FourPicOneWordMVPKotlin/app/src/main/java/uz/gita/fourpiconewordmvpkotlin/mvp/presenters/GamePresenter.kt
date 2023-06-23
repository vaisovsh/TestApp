package uz.gita.fourpiconewordmvpkotlin.mvp.presenters

import uz.gita.fourpiconewordmvpkotlin.mvp.contracts.GameContract
import uz.gita.fourpiconewordmvpkotlin.mvp.models.GameModel

class GamePresenter constructor(private val gameView: GameContract.View):GameContract.Presenter {
    private val gameModel:GameContract.Model = GameModel()

    override fun loadCurrentQuestion() {
        gameView.showQuestionImagesToView(gameModel.questionData().imageQuestions)
        gameView.showVariantsToView(gameModel.questionData().variant)
        gameView.setVisibilityToAnswer(gameModel.questionData().answer.length)
    }

    override fun answerBtnClick(string: String) {
        gameView.undotextfromanswer(string)

    }


    override fun variantBtnClick(string: String) {
        gameView.setTextToAnswer(gameView.getFirstEmptyPos(),string)
    }

    override fun finishActivity() {
//
    }

    override fun checkAnswerm() {
        gameView.checkAnswers(gameModel.questionData().answer)
    }

    override fun loadNextQuestion() {

        gameModel.saveCurrentQuestionPos((gameModel.currentQuestionPos()+1))
        loadCurrentQuestion()
    }


}