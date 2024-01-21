package com.flavorite.common.command

import com.flavorite.common.command.port.`in`.SignUpInPort
import com.flavorite.common.command.port.out.SignUpOutPort
import com.flavorite.common.query.UserQueryService
import com.flavorite.global.advice.transaction.Tx
import com.flavorite.global.exception.AlreadyUserException
import com.flavorite.global.exception.ErrorCode
import org.springframework.stereotype.Service

@Service
class SigningService(
    private val userQueryService: UserQueryService,
    private val signUpOutPort: SignUpOutPort,
) : SignUpInPort {

    override fun execute(command: SignUpInPort.SignUpCommand) {
        validateUserExist(command.serviceUserId)
        signUp(command)
    }

    private fun signUp(command: SignUpInPort.SignUpCommand) = Tx.write {
        signUpOutPort.execute(
            SignUpOutPort.SignUpCommand(
                serviceUserId = command.serviceUserId,
                password = command.password,
                nickname = command.nickname,
                email = command.email,
                address = command.address,
                userRole = command.userRole,
            )
        )
    }

    private fun validateUserExist(serviceUserId: String) = Tx.read {
        if (userQueryService.existServiceUserId(serviceUserId)) {
            throw AlreadyUserException(ErrorCode.ALREADY_USER)
        }
    }

}
