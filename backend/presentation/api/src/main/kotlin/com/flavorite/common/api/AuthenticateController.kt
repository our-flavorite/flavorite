package com.flavorite.common.api

import com.flavorite.application.common.command.usecases.SignInUseCase
import com.flavorite.application.common.command.usecases.SignUpUseCase
import com.flavorite.common.request.CommonRequest
import com.flavorite.security.components.SecurityPasswordEncoder
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthenticateController(
    private val signUpUseCase: SignUpUseCase,
    private val signInUseCase: SignInUseCase,
    private val securityPasswordEncoder: SecurityPasswordEncoder
) {

    @PostMapping("v1/api/sign/in")
    fun signIn(@RequestBody @Valid request: CommonRequest.SignIn) {
        val encodedPassword = securityPasswordEncoder.encode(request.password)
        signInUseCase.execute(request.toDtoWithPasswordEncrypt(encodedPassword))
    }

    @PostMapping("v1/api/sign/up")
    fun signUp(@RequestBody @Valid request: CommonRequest.SignUp) {
        val encodedPassword = securityPasswordEncoder.encode(request.password)
        signUpUseCase.execute(request.toDtoWithPasswordEncrypt(encodedPassword))
    }

    @GetMapping("ping")
    fun ping() {}

}

private fun CommonRequest.SignUp.toDtoWithPasswordEncrypt(encodedPassword: String) =
    SignUpUseCase.SignUpCommand(
        userId,
        email,
        username,
        address,
        encodedPassword,
        listOf("USER")
    )

private fun CommonRequest.SignIn.toDtoWithPasswordEncrypt(encodedPassword: String) =
    SignInUseCase.SignInCommand(
        userId,
        password
    )