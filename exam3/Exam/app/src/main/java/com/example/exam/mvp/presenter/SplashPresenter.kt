package com.example.exam.mvp.presenter

import com.example.exam.mvp.contracts.SplashContract
import com.example.exam.mvp.model.SplashModel

class SplashPresenter(private val view: SplashContract.View) : SplashContract.Presenter {
    private val model = SplashModel()
    override fun startActivity() {
        if (model.getIntroIsActive()) {
            view.openActivity(1)
            model.saveIntroIsActive(false)
        } else {
            view.openActivity(0)
        }
    }
}