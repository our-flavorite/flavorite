package com.flavorite.domain.user

import com.flavorite.domain.user.value.*

data class User(
    private val userId: UserId,
    private val nickname: Nickname,
    private val email: Email,
    private val password: Password,
    private val address: Address,
)
