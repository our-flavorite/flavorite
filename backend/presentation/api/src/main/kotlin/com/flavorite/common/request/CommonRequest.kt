package com.flavorite.common.request

import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

class CommonRequest {

    data class SignIn(
        @field:Size(min = 4, max = 12, message = "Invalid id format.")
        val userId: String,
        val password: String,
    )

    data class SignUp(
        @field:Size(min = 4, max = 12, message = "Invalid id format.")
        val userId: String,
        @field:Size(min = 4, max = 12, message = "Invalid username format.")
        val username: String,
        @field:Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\$", message = "Invalid email format.")
        val email: String,
        val password: String,
        val address: String
    )

}