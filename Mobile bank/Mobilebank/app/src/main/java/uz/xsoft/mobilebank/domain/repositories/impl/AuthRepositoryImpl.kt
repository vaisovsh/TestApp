package uz.xsoft.mobilebank.domain.repositories.impl

import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.xsoft.mobilebank.data.models.common.SignUpData
import uz.xsoft.mobilebank.data.models.common.toRequest
import uz.xsoft.mobilebank.data.models.responses.MessageResponse
import uz.xsoft.mobilebank.data.source.api.AuthApi
import uz.xsoft.mobilebank.domain.repositories.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val authApi: AuthApi, private val gson: Gson) : AuthRepository {
    private var token: String = ""

    override fun signUp(singUpData: SignUpData): Flow<Result<Unit>> = flow<Result<Unit>> {

        val response = authApi.signUp(singUpData.toRequest())

        when (response.code()) {
            in 200..299 -> {
                val data = response.body() ?: return@flow
                token = data.token
                emit(Result.success(Unit))
            }

            else -> {
                val messageResponse = gson.fromJson(response.errorBody()?.string().toString(), MessageResponse::class.java)

                emit(Result.failure(Exception(messageResponse.message)))
            }
        }

    }
        .catch { emit(Result.failure(Exception("Internetga ulangaman tarmoqni tekshirib ko'ring!"))) }
        .flowOn(Dispatchers.IO)
}