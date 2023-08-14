package com.flavorite.security

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

@EnableWebSecurity
@Configuration
class SecurityConfig {

    fun filterChainConfigure(http: HttpSecurity): SecurityFilterChain = http
        .formLogin {
            it.loginPage("/login")
                .permitAll()
        }
        .build()
}