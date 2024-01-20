package com.flavorite.application.common.command.usecases

import com.flavorite.domain.member.value.Address
import com.flavorite.domain.member.value.Email
import com.flavorite.domain.member.value.Password
import com.flavorite.domain.member.value.Username


interface SignUpUseCase {

    fun execute(command: SignUpCommand)

    data class SignUpCommand(
        val email: Email,
        val username: Username,
        val address: Address,
        val password: Password,
        val roles: List<String>
    )

}
