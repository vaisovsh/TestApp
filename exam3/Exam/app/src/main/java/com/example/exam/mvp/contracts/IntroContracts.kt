package com.example.exam.mvp.contracts

interface IntroContracts {
    interface Model{

    }

    interface Presenter{
        fun startButtonClicked()
    }

    interface View{
        fun openMainActivity()
    }
}