package com.flavorite.application.common.command

data class SignUpCommand(
    val email: String,
    val username: String,
    val address: String,
    val password: String,
    val roles: List<String>
)
