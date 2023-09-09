package com.flavorite.application.common.query.dto

import java.time.Instant

data class SecurityMemberDto(
    val email: String,
    val username: String,
    val address: String,
    val password: String,
    val roles: MutableList<String>,
    val registerDate: Instant,
    val modifyDate: Instant
) {
}