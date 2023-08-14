package com.flavorite.presentation.common.request

import jakarta.validation.constraints.Email
import org.hibernate.validator.constraints.Length

class CommonRequest {

    data class SignUp(
        @Length(min = 4, max = 12, message = "Invalid username format.")
        val username: String,
        @Email(message = "Invalid email format.")
        val email: String,
        val password: String,
        val address: String
    )

}