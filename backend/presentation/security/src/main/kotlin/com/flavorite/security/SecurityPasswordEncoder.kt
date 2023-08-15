package com.flavorite.security

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component

@Component
class SecurityPasswordEncoder(
    private val encoder: BCryptPasswordEncoder
) {
    fun encode(password: String): String = encoder.encode(password)
}