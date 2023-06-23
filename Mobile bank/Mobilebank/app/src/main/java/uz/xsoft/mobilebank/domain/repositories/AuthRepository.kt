package uz.xsoft.mobilebank.domain.repositories

import kotlinx.coroutines.flow.Flow
import uz.xsoft.mobilebank.data.models.common.SignUpData

interface AuthRepository {

    fun signUp(singUpData: SignUpData): Flow<Result<Unit>>
}