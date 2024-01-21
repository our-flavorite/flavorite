package com.flavorite.config

import com.flavorite.security.jwt.JwtProvider
import com.flavorite.security.jwt.JwtAuthenticateFilter
import org.springframework.boot.autoconfigure.security.servlet.PathRequest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@EnableWebSecurity
@Configuration
class SecurityConfig(
    private val jwtProvider: JwtProvider
) {

    @Bean
    fun securityFilter(
        http: HttpSecurity
    ): SecurityFilterChain {
        return http
            .formLogin { it.disable() }
            .httpBasic { it.disable() }
            .csrf { it.disable() }
            .cors { it.disable() }
            .headers { header ->
                header.frameOptions { it.disable() }
            }
            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
            .authorizeHttpRequests {
                it
                    .requestMatchers(PathRequest.toH2Console()).permitAll()
                    .requestMatchers("api/v1/sign/up").permitAll()
                    .requestMatchers("api/v1/sign/in").permitAll()
                    .requestMatchers(HttpMethod.GET, "api/v1/article/**").permitAll()
                    .anyRequest().permitAll()
            }
            .addFilterBefore(JwtAuthenticateFilter(jwtProvider), UsernamePasswordAuthenticationFilter::class.java)
            .build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder =
        PasswordEncoderFactories.createDelegatingPasswordEncoder()
}