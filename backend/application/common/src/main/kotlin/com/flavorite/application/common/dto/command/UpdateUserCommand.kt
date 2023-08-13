package com.flavorite.applicatoin.dto.command

class UpdateUserCommand(
    val userId: Long,
    val username: String,
    val email: String
) {

}
