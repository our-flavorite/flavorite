package com.flavorite.domain.member

import com.flavorite.domain.member.enums.UserRole
import com.flavorite.domain.member.value.*

data class Member(
    private val userId: UserId,
    private val username: Username,
    private val email: Email,
    private val password: Password,
    private val address: Address,
    private val roles: List<UserRole>
)
