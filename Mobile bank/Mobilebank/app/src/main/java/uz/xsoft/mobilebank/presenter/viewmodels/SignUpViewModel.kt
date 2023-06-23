package uz.xsoft.mobilebank.presenter.viewmodels

import androidx.lifecycle.LiveData
import uz.xsoft.mobilebank.data.models.common.SignUpData

interface SignUpViewModel {
    val successLiveData: LiveData<Unit>
    val messageLiveData: LiveData<String>
    val loadingLiveData: LiveData<Boolean>
    fun signUp(signUpData: SignUpData)
}