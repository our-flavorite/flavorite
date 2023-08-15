package com.flavorite.application.common.dto.command

data class SignUpCommand(
    val email: String,
    val username: String,
    val address: String,
    val password: String,
    val roles: List<String>
)
