package com.flavorite.security.service

import com.flavorite.security.jwt.JwtProvider
import com.flavorite.security.model.JsonWebToken
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.stereotype.Service

@Service
class SecuritySignInService(
    private val jwtProvider: JwtProvider,
    private val authenticationManagerBuilder: AuthenticationManagerBuilder
) {

    fun signIn(serviceUserId: String, password: String): JsonWebToken {
        val authenticationToken = UsernamePasswordAuthenticationToken(serviceUserId, password)
        val authenticate = authenticationManagerBuilder.`object`.authenticate(authenticationToken)
        val jwt = jwtProvider.issue(authenticate)
        return jwt
    }

}
