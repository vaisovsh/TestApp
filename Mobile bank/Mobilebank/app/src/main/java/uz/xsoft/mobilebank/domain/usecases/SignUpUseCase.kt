package uz.xsoft.mobilebank.domain.usecases

import kotlinx.coroutines.flow.Flow
import uz.xsoft.mobilebank.data.models.common.SignUpData

interface SignUpUseCase {
    fun singUp(signUpData: SignUpData): Flow<Result<Unit>>
}