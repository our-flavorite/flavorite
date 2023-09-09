package com.flavorite.application.common.command.domain.enums

import com.flavorite.application.common.command.exception.ErrorCode
import com.flavorite.application.common.command.exception.NotMatchedUserRoleException

enum class UserRole {
    ANONYMOUS,
    USER,
    ADMIN;

    companion object {
        fun of(name: String): UserRole = entries.find { name.equals(it.name, true) } ?: throw NotMatchedUserRoleException(ErrorCode.ANY_MATCH_ENUM)
    }

}
