package com.flavorite.common.query

import com.flavorite.common.query.port.`in`.UserQueryInPort
import com.flavorite.common.query.port.out.UserQueryOutPort
import com.flavorite.global.advice.transaction.Tx
import com.flavorite.global.exception.ErrorCode
import com.flavorite.global.exception.NotFoundUserException
import org.springframework.stereotype.Service

@Service
class UserQueryService(
    private val userQueryOutPort: UserQueryOutPort
) : UserQueryInPort {

    override fun existServiceUserId(serviceUserId: String): Boolean =
        Tx.read {
            userQueryOutPort.selectUserBy(serviceUserId) != null
        }

    override fun getMemberForSecurity(serviceUserId: String) = Tx.read {
        val securityUserDto = userQueryOutPort
            .selectSecurityUserBy(serviceUserId)
            ?: throw NotFoundUserException(ErrorCode.NOT_FOUND_USER)

        UserQueryInPort.SecurityUserDto(
            serviceUserId = securityUserDto.serviceUserId,
            password = securityUserDto.password,
            userRole = securityUserDto.userRole,
            createdDatetime = securityUserDto.createdDatetime,
            modifiedDatetime = securityUserDto.modifiedDatetime
        )
    }

}
