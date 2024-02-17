package com.flavorite.security.service

import com.flavorite.common.query.port.`in`.UserQueryInPort
import com.flavorite.security.model.SecurityUser
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class CustomUserDetailService(
    private val userQueryInPort: UserQueryInPort
) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val securityUserDto = userQueryInPort.getMemberForSecurity(username)

        return SecurityUser(
            serviceUserId = securityUserDto.serviceUserId,
            encryptedPassword = securityUserDto.password,
            userRole = securityUserDto.userRole,
            createdDatetime = securityUserDto.createdDatetime,
            modifiedDatetime = securityUserDto.modifiedDatetime
        )

    }

}