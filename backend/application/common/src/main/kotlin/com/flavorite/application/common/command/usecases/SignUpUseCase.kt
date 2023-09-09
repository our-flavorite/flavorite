package com.flavorite.application.common.command.usecases

import com.flavorite.application.common.command.SignUpCommand

interface SignUpUseCase {

    fun execute(command: SignUpCommand)
}