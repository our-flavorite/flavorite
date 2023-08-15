package com.flavorite.applicatoin.dto.value

data class MemberDto(
    val userId: Long,
    val email: String,
    val username: String,
    val address: String,
    val password: String,
) {
}