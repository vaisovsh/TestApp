package com.example.exam.mvp.presenter

import com.example.exam.mvp.contracts.IntroContracts

class IntroPresenter(private val view: IntroContracts.View) : IntroContracts.Presenter {

    override fun startButtonClicked() {
        view.openMainActivity()
    }
}