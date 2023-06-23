package com.example.exam.mvp.contracts

interface SplashContract {
    interface Model{
        fun saveIntroIsActive(state: Boolean)
        fun getIntroIsActive(): Boolean
    }

    interface Presenter{
        fun startActivity()
    }

    interface View{
        fun entering()
        fun openActivity(number: Int)
    }
}