package com.flavorite.application.common.command.domain.value

import exception.ErrorCode
import exception.NotMatchedUserRoleException

enum class UserRole {
    ANONYMOUS,
    USER,
    ADMIN;

    companion object {
        fun of(name: String): UserRole =
            entries
                .find { name.equals(it.name, true) }
                ?: throw NotMatchedUserRoleException(ErrorCode.ANY_MATCH_ENUM)
    }

}
