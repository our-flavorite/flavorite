package com.flavorite.application.common.command.usecases

import com.flavorite.domain.member.value.Password
import com.flavorite.domain.member.value.UserId


interface SignInUseCase {

    fun execute(command: SignInCommand)

    data class SignInCommand(
        val userId: UserId,
        val password: Password
    )
}


