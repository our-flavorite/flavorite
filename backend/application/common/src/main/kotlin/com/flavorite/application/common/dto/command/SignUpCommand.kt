package com.flavorite.application.common.dto.command

data class SignUpCommand(
    val username: String,
    val email: String,
    val password: String,
    val address: String
)
