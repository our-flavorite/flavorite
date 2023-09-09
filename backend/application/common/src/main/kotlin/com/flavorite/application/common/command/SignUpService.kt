package com.flavorite.application.common.command

import com.flavorite.application.common.command.exception.AlreadyUserException
import com.flavorite.application.common.command.exception.ErrorCode
import com.flavorite.application.common.command.port.FindUserPort
import com.flavorite.application.common.command.port.SignUpMemberPort
import com.flavorite.application.common.command.usecases.SignUpUseCase
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SignUpService(
    private val findUserPort: FindUserPort,
    private val signUpMemberPort: SignUpMemberPort
) : SignUpUseCase {

    @Transactional
    override fun execute(command: SignUpCommand) {
        findUserPort.selectMemberBy(command.email) ?: throw AlreadyUserException(ErrorCode.ALREADY_USER)
        signUpMemberPort.execute(command)
    }

}