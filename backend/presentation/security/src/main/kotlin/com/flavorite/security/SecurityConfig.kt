package com.flavorite.security

import org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.Customizer.withDefaults
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource


@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain = http
        .authorizeHttpRequests {
            it
                .requestMatchers(toH2Console()).permitAll()
                .requestMatchers("api/v1/admin/**").hasRole("ADMIN")
                .requestMatchers("api/v1/settings/**").authenticated()
                .requestMatchers(HttpMethod.POST, "api/v1/article/**").authenticated()
                .anyRequest().permitAll()
        }
        .httpBasic { it.disable() }
        .cors(withDefaults())
        .formLogin { it.disable() }
        .csrf { it.ignoringRequestMatchers(toH2Console()).disable() }
        .headers { it.frameOptions { it.sameOrigin() } }
        .build()


    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {
        val configuration = CorsConfiguration()
        configuration.addAllowedOrigin("https://localhost:3000")
        configuration.addAllowedMethod(CorsConfiguration.ALL)

        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", configuration)
        return source
    }

    @Bean
    fun encoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }
}