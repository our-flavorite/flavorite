package com.flavorite.application.common.usecases

import com.flavorite.application.common.dto.command.SignInCommand

interface SignInUseCase {

    fun execute(command: SignInCommand)
}