package com.flavorite.common.command.port.out

interface SignUpOutPort {

    fun execute(command: SignUpCommand)

    data class SignUpCommand(
        val serviceUserId: String,
        val password: String,
        val nickname: String,
        val email: String,
        val address: String,
        val userRole: String
    )
}