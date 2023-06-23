package uz.xsoft.mobilebank.data.models.common

import uz.xsoft.mobilebank.data.models.request.SignUpRequest

data class SignUpData(
    val phone: String,
    val password: String,
    val firstName: String,
    val lastName: String,
    val bornDate: String,
    val gender: String
)


fun SignUpData.toRequest() = SignUpRequest(phone, password, firstName, lastName, bornDate, gender)