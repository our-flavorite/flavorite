package com.flavorite.domain.member.enums


enum class UserRole {
    ANONYMOUS,
    USER,
    ADMIN;

    companion object {
        fun of(name: String): UserRole = entries.find { name.equals(it.name, true) } ?: throw RuntimeException("Cannot Found Matched User Role.")
    }

}
