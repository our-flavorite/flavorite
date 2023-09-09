package com.flavorite.application.common.query

import com.flavorite.application.common.command.exception.ErrorCode
import com.flavorite.application.common.command.exception.NotFoundUserException
import com.flavorite.application.common.query.dto.SecurityMemberDto
import com.flavorite.application.common.query.port.UserQueryPort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@Service
class UserQueryService (
    private val userQueryPort: UserQueryPort
){


    fun getMemberForSecurity(email: String): SecurityMemberDto =
        userQueryPort.selectSecurityMemberBy(email) ?: throw NotFoundUserException(ErrorCode.NOT_FOUND_USER)
}
