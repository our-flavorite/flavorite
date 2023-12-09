package com.flavorite.application.common.command.domain

import com.flavorite.application.common.command.domain.value.*

class Member(
    val memberId: Long,
    val userId: UserId,
    val username: Username,
    val email: Email,
    val password: Password,
    val address: Address,
    val roles: List<UserRole>
)
