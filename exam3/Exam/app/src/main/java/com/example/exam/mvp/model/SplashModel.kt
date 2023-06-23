package com.example.exam.mvp.model

import com.example.exam.Repository.Repository
import com.example.exam.mvp.contracts.SplashContract

class SplashModel : SplashContract.Model{
    val repository = Repository.getInstance()
    override fun saveIntroIsActive(state: Boolean) {
        repository.saveIntroIsActive(state)
    }

    override fun getIntroIsActive() : Boolean{
        return repository.getIntroIsActive()
    }
}