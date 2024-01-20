package com.flavorite.application.common.command.port

import com.flavorite.application.common.command.usecases.SignUpUseCase

interface SignUpMemberPort {

    fun execute(command: SignUpUseCase.SignUpCommand)
}