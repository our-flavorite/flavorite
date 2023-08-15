package com.flavorite.security.components

import com.flavorite.application.common.AuthenticateService
import com.flavorite.application.common.dto.value.SecurityMemberDto
import com.flavorite.security.value.SecurityMember
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(
    private val authenticateService: AuthenticateService
) : UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        val dto = authenticateService.getMemberForSecurity(username.orEmpty())
        return dto.toSecurityMember()
    }

}

private fun SecurityMemberDto.toSecurityMember() = SecurityMember(
    email,
    username,
    address,
    password,
    roles,
    registerDate,
    modifyDate
)
