package com.flavorite.application.common.command

import com.flavorite.application.common.command.port.SignUpMemberPort
import com.flavorite.application.common.command.usecases.SignInUseCase
import com.flavorite.application.common.command.usecases.SignUpUseCase
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SignUpService(
    private val signUpMemberPort: SignUpMemberPort
) : SignInUseCase, SignUpUseCase {

    @Transactional
    override fun execute(command: SignUpUseCase.SignUpCommand) {
        signUpMemberPort.execute(command)
    }

    @Transactional(readOnly = true)
    override fun execute(command: SignInUseCase.SignInCommand) {

    }

}