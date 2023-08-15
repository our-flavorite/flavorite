package com.flavorite.application.common

import com.flavorite.application.common.dto.command.SignInCommand
import com.flavorite.application.common.dto.command.SignUpCommand
import com.flavorite.application.common.dto.value.SecurityMemberDto
import com.flavorite.application.common.exception.AlreadyUserException
import com.flavorite.application.common.exception.ErrorCode
import com.flavorite.application.common.exception.NotFoundUserException
import com.flavorite.application.common.port.SignUpMemberPort
import com.flavorite.application.common.port.SimpleMemberPort
import com.flavorite.application.common.usecases.SignInUseCase
import com.flavorite.application.common.usecases.SignUpUseCase
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AuthenticateService(
    private val signUpMemberPort: SignUpMemberPort,
    private val simpleMemberPort: SimpleMemberPort
) : SignUpUseCase, SignInUseCase {

    @Transactional
    override fun execute(command: SignUpCommand) {
        simpleMemberPort.selectMemberBy(command.email) ?: throw AlreadyUserException(ErrorCode.ALREADY_USER)
        signUpMemberPort.execute(command)
    }

    override fun execute(command: SignInCommand) {
        TODO("Not yet implemented")
    }

    @Transactional
    fun getMemberForSecurity(email: String): SecurityMemberDto =
        simpleMemberPort.selectSecurityMemberBy(email) ?: throw NotFoundUserException(ErrorCode.NOT_FOUND_USER)

}