package com.flavorite.application.common.command.port

import com.flavorite.application.common.command.domain.Member

interface FindUserPort {

    fun selectMemberBy(email: String): Member?

}
