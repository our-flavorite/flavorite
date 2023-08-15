package com.flavorite.presentation.common.api

import com.flavorite.application.common.dto.command.SignUpCommand
import com.flavorite.application.common.usecases.SignUpUseCase
import com.flavorite.presentation.common.request.CommonRequest
import com.flavorite.security.SecurityPasswordEncoder
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class SignUpController(
    private val signUpUseCase: SignUpUseCase,
    private val securityPasswordEncoder: SecurityPasswordEncoder
) {

    @PostMapping("v1/api/sign/up")
    fun signUp(@RequestBody @Valid request: CommonRequest.SignUp) {
        val encodedPassword = securityPasswordEncoder.encode(request.password)
        signUpUseCase.execute(request.toDtoWithPasswordEncrypt(encodedPassword))
    }

    @GetMapping("v1/api/sign/in")
    fun signIn(): String {
        return "login"
    }
}

private fun CommonRequest.SignUp.toDtoWithPasswordEncrypt(encodedPassword: String): SignUpCommand = SignUpCommand(
    email,
    username,
    address,
    encodedPassword,
    listOf("USER")
)