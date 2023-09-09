package com.flavorite.application.common.command.port

import com.flavorite.application.common.command.domain.User

interface FindUserPort {

    fun selectMemberBy(email: String): User?

}
