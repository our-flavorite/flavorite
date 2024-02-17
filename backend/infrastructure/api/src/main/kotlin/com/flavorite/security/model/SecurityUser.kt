package com.flavorite.security.model

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.time.LocalDateTime

class SecurityUser(
    val serviceUserId: String,
    val encryptedPassword: String,
    val userRole: String,
    val createdDatetime: LocalDateTime,
    val modifiedDatetime: LocalDateTime
) : UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> =
        mutableListOf(SimpleGrantedAuthority(userRole))

    override fun getPassword(): String = encryptedPassword

    override fun getUsername(): String = serviceUserId

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true
}