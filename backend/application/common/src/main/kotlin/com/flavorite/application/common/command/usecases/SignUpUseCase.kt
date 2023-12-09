package com.flavorite.application.common.command.usecases

interface SignUpUseCase {

    fun execute(command: SignUpCommand)

    data class SignUpCommand(
        val userId: String,
        val email: String,
        val username: String,
        val address: String,
        val password: String,
        val roles: List<String>
    )

}
