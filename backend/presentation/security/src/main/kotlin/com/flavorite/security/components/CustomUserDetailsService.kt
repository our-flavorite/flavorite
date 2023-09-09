package com.flavorite.security.components

import com.flavorite.application.common.query.UserQueryService
import com.flavorite.application.common.query.dto.SecurityMemberDto
import com.flavorite.security.domain.SecurityUser
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(
    private val securityUserQueryService: UserQueryService
) : UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        val dto = securityUserQueryService.getMemberForSecurity(username.orEmpty())
        return dto.toSecurityMember()
    }

}

private fun SecurityMemberDto.toSecurityMember() = SecurityUser(
    email,
    username,
    address,
    password,
    roles,
    registerDate,
    modifyDate
)
