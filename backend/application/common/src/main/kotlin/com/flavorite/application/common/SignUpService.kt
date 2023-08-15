package com.flavorite.application.common

import com.flavorite.application.common.dto.command.SignUpCommand
import com.flavorite.application.common.exception.AlreadyUserException
import com.flavorite.application.common.exception.ErrorCode
import com.flavorite.application.common.port.SignUpMemberPort
import com.flavorite.application.common.port.SimpleMemberPort
import com.flavorite.application.common.usecases.SignUpUseCase
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SignUpService(
    private val signUpMemberPort: SignUpMemberPort,
    private val simpleMemberPort: SimpleMemberPort
) : SignUpUseCase {

    @Transactional
    override fun execute(command: SignUpCommand) {
        simpleMemberPort.selectBy(command.email)
            ?.let {
                throw AlreadyUserException(ErrorCode.ALREADY_USER)
            }
            ?: signUpMemberPort.execute(command)
    }
}