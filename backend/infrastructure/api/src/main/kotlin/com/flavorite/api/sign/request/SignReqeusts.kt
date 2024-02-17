package com.flavorite.api.sign.request

import com.flavorite.global.enum.UserRole
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Size

data class SignUpRequest(
    @field:Size(message = "아이디는 [4 ~ 12] 글자로 구성됩니다.", min = 4, max = 12)
    val serviceUserId: String,
    @field:Size(message = "비밀번호는 [8 ~ 16] 글자로 구성됩니다.", min = 8, max = 16)
    val password: String,
    @field:Size(message = "닉네임은 [2 ~ 8] 글자로 구성됩니다.", min = 2, max = 8)
    val nickname: String,
    @field:Email(message = "이메일 형식이 올바르지 않습니다.", regexp = "^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+\$")
    val email: String,
    val address: String,
    val userRole: String = UserRole.USER.name
)

data class SignInRequest(
    val serviceUserId: String,
    val password: String,
)