package uz.gita.fourpiconewordmvpkotlin.mvp.contracts

interface MainContract {
    interface Model {
        fun getCurrentQuestionPos():Int
        fun getCurrentQuestionImages():List<Int>
    }

    interface Presenter {
        fun loadCurrentQuestion()
        fun startGameActivity()
    }

    interface View {
        fun setImagesToView(images:List<Int>)
        fun setQuestionPos(pos:Int)

        fun goToGameActivity()
        //fun goToAboutActivity()
    }
}