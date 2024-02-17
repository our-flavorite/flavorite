package com.flavorite.security.jwt

import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.http.HttpServletRequest
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.GenericFilterBean

@Component
class JwtAuthenticateFilter(
    private val jwtProvider: JwtProvider
) : GenericFilterBean() {

    override fun doFilter(request: ServletRequest, response: ServletResponse, filterChain: FilterChain) {
        val accessToken = resolve(request as HttpServletRequest)

        if (accessToken.isNotBlank()) {
            jwtProvider.validate(accessToken)
            val authentication = jwtProvider.extractAuthentication(accessToken)

            SecurityContextHolder
                .getContext()
                .apply { this.authentication = authentication }
        }

        filterChain.doFilter(request, response)

    }

    fun resolve(request: HttpServletRequest): String {
        val bearerToken = request.getHeader(AUTHORIZATION) ?: ""

        return if (bearerToken.isNotBlank() && bearerToken.startsWith(AUTHORIZATION_PREFIX)) {
            bearerToken.substringAfter(AUTHORIZATION_PREFIX)
        } else {
            bearerToken
        }
    }

    companion object {
        const val AUTHORIZATION = "Authorization"
        const val AUTHORIZATION_PREFIX = "Bearer "
    }

}