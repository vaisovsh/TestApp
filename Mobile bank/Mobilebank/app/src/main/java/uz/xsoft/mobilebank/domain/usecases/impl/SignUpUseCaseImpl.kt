package uz.xsoft.mobilebank.domain.usecases.impl

import kotlinx.coroutines.flow.Flow
import uz.xsoft.mobilebank.data.models.common.SignUpData
import uz.xsoft.mobilebank.domain.repositories.AuthRepository
import uz.xsoft.mobilebank.domain.usecases.SignUpUseCase
import javax.inject.Inject

class SignUpUseCaseImpl @Inject constructor(private val repository: AuthRepository) : SignUpUseCase {
    override fun singUp(signUpData: SignUpData): Flow<Result<Unit>> = repository.signUp(signUpData)

}