package com.flavorite.presentation.common.api

import com.flavorite.application.common.dto.command.SignUpCommand
import com.flavorite.application.common.usecases.SignUpUseCase
import com.flavorite.presentation.common.request.CommonRequest
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class SignUpController(
    private val signUpUseCase: SignUpUseCase
) {

    @PostMapping("/api/v1/signup")
    fun signup(@RequestBody @Valid request: CommonRequest.SignUp) {
        signUpUseCase.execute(request.toDto())
    }
}

private fun CommonRequest.SignUp.toDto(): SignUpCommand = SignUpCommand(
    username,
    email,
    password,
    address
)