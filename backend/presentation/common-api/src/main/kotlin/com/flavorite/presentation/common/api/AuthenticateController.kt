package com.flavorite.presentation.common.api

import com.flavorite.application.common.command.SignUpCommand
import com.flavorite.application.common.command.usecases.SignUpUseCase
import com.flavorite.presentation.common.request.CommonRequest
import com.flavorite.security.components.SecurityPasswordEncoder
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthenticateController(
    private val signUpUseCase: SignUpUseCase,
    private val securityPasswordEncoder: SecurityPasswordEncoder
) {

    @PostMapping("v1/api/sign/up")
    fun signUp(@RequestBody @Valid request: CommonRequest.SignUp) {
        val encodedPassword = securityPasswordEncoder.encode(request.password)
        signUpUseCase.execute(request.toDtoWithPasswordEncrypt(encodedPassword))
    }

}

private fun CommonRequest.SignUp.toDtoWithPasswordEncrypt(encodedPassword: String): SignUpCommand = SignUpCommand(
    email,
    username,
    address,
    encodedPassword,
    listOf("USER")
)