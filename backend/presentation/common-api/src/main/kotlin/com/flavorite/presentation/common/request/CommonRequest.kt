package com.flavorite.presentation.common.request

import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

class CommonRequest {

    data class SignUp(
        @field:Size(min = 4, max = 12, message = "Invalid username format.")
        val username: String,
        @field:Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\$", message = "Invalid email format.")
        val email: String,
        val password: String,
        val address: String
    )

}