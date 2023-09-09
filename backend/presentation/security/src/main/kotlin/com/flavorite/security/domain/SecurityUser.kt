package com.flavorite.security.domain

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.time.Instant
import java.time.temporal.ChronoUnit

data class SecurityUser(
    private val email: String,
    private val username: String,
    private val address: String,
    private val password: String,
    private val roles: MutableList<String>,
    private val registerDate: Instant,
    private val modifyDate: Instant
) : UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return mutableListOf(SimpleGrantedAuthority(roles.find { it == "USER" }))
    }

    override fun getPassword(): String = password

    override fun getUsername(): String = email

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean =
        ChronoUnit.MONTHS.between(modifyDate, Instant.now()) >= 6

    override fun isEnabled(): Boolean = true

}