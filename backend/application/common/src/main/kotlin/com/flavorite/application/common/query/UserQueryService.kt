package com.flavorite.application.common.query

import com.flavorite.application.common.query.port.MemberQueryPort
import com.flavorite.exception.ErrorCode
import com.flavorite.exception.NotFoundUserException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@Service
class UserQueryService(
    private val memberQueryPort: MemberQueryPort
) {
    fun getMemberForSecurity(userId: String) =
        memberQueryPort.selectSecurityMemberBy(userId)
            ?: throw NotFoundUserException(ErrorCode.NOT_FOUND_USER)
}
