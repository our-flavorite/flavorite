package com.flavorite.applicatoin.dto.command

data class SaveUserCommand(
    val username: String,
    val email: String,
) {
}