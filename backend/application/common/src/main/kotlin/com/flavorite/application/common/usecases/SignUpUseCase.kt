package com.flavorite.application.common.usecases

import com.flavorite.application.common.dto.command.SignUpCommand

interface SignUpUseCase {

    fun execute(command: SignUpCommand)
}