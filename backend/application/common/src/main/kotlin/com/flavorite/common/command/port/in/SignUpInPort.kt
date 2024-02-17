package com.flavorite.common.command.port.`in`


interface SignUpInPort {

    fun execute(command: SignUpCommand)

    data class SignUpCommand(
        val serviceUserId: String,
        val password: String,
        val email: String,
        val nickname: String,
        val address: String,
        val userRole: String
    )

}
