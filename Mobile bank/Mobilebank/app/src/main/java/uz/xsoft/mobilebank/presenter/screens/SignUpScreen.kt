package uz.xsoft.mobilebank.presenter.screens

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.xsoft.mobilebank.R
import uz.xsoft.mobilebank.data.models.common.SignUpData
import uz.xsoft.mobilebank.databinding.ScreenSignUpBinding
import uz.xsoft.mobilebank.presenter.viewmodels.SignUpViewModel
import uz.xsoft.mobilebank.presenter.viewmodels.impl.SignUpViewModelImpl

@AndroidEntryPoint
class SignUpScreen : Fragment(R.layout.screen_sign_up) {
    private val viewModel: SignUpViewModel by viewModels<SignUpViewModelImpl>()
    private val viewBinding: ScreenSignUpBinding by viewBinding(ScreenSignUpBinding::bind)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.loadingLiveData.observe(viewLifecycleOwner, loadingObserver)
        viewModel.messageLiveData.observe(viewLifecycleOwner, messageObserver)
        viewModel.successLiveData.observe(viewLifecycleOwner, successObserver)

        viewBinding.btnSignUp.setOnClickListener {
            viewModel.signUp(
                SignUpData(
                    "+998977607608",
                    "qwerty",
                    "Rustam",
                    "Akbaraliyev",
                    "969822000000",
                    "0"
                )
            )
        }

    }


    private val messageObserver = Observer<String> {
        Log.d("TTT", "message $it")
    }

    private val successObserver = Observer<Unit> {
        Log.d("TTT", "successObserver")

    }

    private val loadingObserver = Observer<Boolean> {
        Log.d("TTT", "loadingObserver $it")
    }


}