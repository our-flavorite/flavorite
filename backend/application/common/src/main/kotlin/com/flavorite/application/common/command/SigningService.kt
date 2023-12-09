package com.flavorite.application.common.command

import com.flavorite.application.common.command.port.FindUserPort
import com.flavorite.application.common.command.port.SignUpMemberPort
import com.flavorite.application.common.command.usecases.SignInUseCase
import com.flavorite.application.common.command.usecases.SignUpUseCase
import exception.AlreadyUserException
import exception.ErrorCode
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SigningService(
    private val findUserPort: FindUserPort,
    private val signUpMemberPort: SignUpMemberPort
) : SignInUseCase, SignUpUseCase {

    @Transactional
    override fun execute(command: SignUpUseCase.SignUpCommand) {
        findUserPort.selectMemberBy(command.email) ?: throw AlreadyUserException(ErrorCode.ALREADY_USER)
        signUpMemberPort.execute(command)
    }

    override fun execute(command: SignInUseCase.SignInCommand) {
        TODO("Not yet implemented")
    }

}