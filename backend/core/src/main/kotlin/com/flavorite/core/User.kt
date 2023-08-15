package com.flavorite.core

import com.flavorite.core.enum.UserRole
import com.flavorite.core.vo.Address
import com.flavorite.core.vo.Email
import com.flavorite.core.vo.Password
import com.flavorite.core.vo.Username

class User(
    val userId: Long,
    val username: Username,
    val email: Email,
    val password: Password,
    val address: Address,
    val roles: List<UserRole>
) {

}