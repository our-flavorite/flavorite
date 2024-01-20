package com.flavorite.application.common.query.port

import com.flavorite.domain.member.enums.UserRole
import com.flavorite.domain.member.value.*
import java.time.Instant

interface MemberQueryPort {

    fun selectMemberBy(userId: String): MemberDto?

    fun selectSecurityMemberBy(userId: String): SecurityMemberDto?

    data class MemberDto(
        private val userId: UserId,
        private val username: Username,
        private val email: Email,
        private val password: Password,
        private val address: Address,
        private val roles: List<UserRole>
    )

    data class SecurityMemberDto(
        val userId: String,
        val email: String,
        val username: String,
        val address: String,
        val password: String,
        val roles: MutableList<String>,
        val registerDate: Instant,
        val modifyDate: Instant
    )

}
