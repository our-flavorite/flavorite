package com.flavorite.application.common.command.usecases

interface SignInUseCase {

    fun execute(command: SignInCommand)

    data class SignInCommand(
        val userId: String,
        val password: String
    )
}


