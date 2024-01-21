package com.flavorite.common.query.port.out

import java.time.LocalDateTime

interface UserQueryOutPort {

    fun selectUserBy(serviceUserId: String): UserDto?

    fun selectSecurityUserBy(serviceUserId: String): SecurityUserDto?

    data class UserDto(
        private val userId: Long,
        private val serviceUserId: String,
        private val nickname: String,
        private val email: String,
        private val password: String,
        private val address: String,
    )

    data class SecurityUserDto(
        val serviceUserId: String,
        val password: String,
        val userRole: String,
        val createdDatetime: LocalDateTime,
        val modifiedDatetime: LocalDateTime
    )

}
