package uz.xsoft.mobilebank.data.source.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import uz.xsoft.mobilebank.data.models.request.SignUpRequest
import uz.xsoft.mobilebank.data.models.responses.TokenResponse

interface AuthApi {

    @POST("auth/sign-up")
    suspend fun signUp(@Body singUpRequest: SignUpRequest): Response<TokenResponse>

}