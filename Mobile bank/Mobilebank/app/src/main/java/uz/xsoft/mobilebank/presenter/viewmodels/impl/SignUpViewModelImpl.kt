package uz.xsoft.mobilebank.presenter.viewmodels.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.xsoft.mobilebank.data.models.common.SignUpData
import uz.xsoft.mobilebank.domain.usecases.SignUpUseCase
import uz.xsoft.mobilebank.presenter.viewmodels.SignUpViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModelImpl @Inject constructor(private val useCase: SignUpUseCase) : ViewModel(), SignUpViewModel {

    override val successLiveData: MutableLiveData<Unit> = MutableLiveData()
    override val messageLiveData: MutableLiveData<String> = MutableLiveData()
    override val loadingLiveData: MutableLiveData<Boolean> = MutableLiveData(false)

    override fun signUp(signUpData: SignUpData) {
        loadingLiveData.value = true

        useCase.singUp(signUpData)
            .onEach { loadingLiveData.value = false }
            .onEach { it.onSuccess { successLiveData.value = Unit } }
            .onEach { it.onFailure { e -> messageLiveData.value = e.message } }
            .launchIn(viewModelScope)
    }
}