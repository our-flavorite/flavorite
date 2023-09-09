package com.flavorite.application.common.command.domain

import com.flavorite.application.common.command.domain.enums.UserRole
import com.flavorite.application.common.command.domain.vo.Address
import com.flavorite.application.common.command.domain.vo.Email
import com.flavorite.application.common.command.domain.vo.Password
import com.flavorite.application.common.command.domain.vo.Username

class User(
    val userId: Long,
    val username: Username,
    val email: Email,
    val password: Password,
    val address: Address,
    val roles: List<UserRole>
)
