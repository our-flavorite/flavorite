package com.flavorite.common.query.port.`in`

import java.time.LocalDateTime

interface UserQueryInPort {

    fun existServiceUserId(serviceUserId: String): Boolean

    fun getMemberForSecurity(serviceUserId: String): SecurityUserDto

    data class SecurityUserDto(
        val serviceUserId: String,
        val password: String,
        val userRole: String,
        val createdDatetime: LocalDateTime,
        val modifiedDatetime: LocalDateTime
    )

}
