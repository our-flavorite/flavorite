package com.flavorite.application.common

import com.flavorite.application.common.dto.command.SignUpCommand
import com.flavorite.application.common.port.UserSimplePort
import com.flavorite.application.common.usecases.SignUpUseCase
import org.springframework.stereotype.Service

@Service
class SignUpService(
    private val userSimplePort: UserSimplePort
) : SignUpUseCase {

    override fun execute(command: SignUpCommand) {
        TODO("Not yet implemented")
    }
}