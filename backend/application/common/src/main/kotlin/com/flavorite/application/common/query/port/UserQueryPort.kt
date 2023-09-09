package com.flavorite.application.common.query.port

import com.flavorite.application.common.query.dto.SecurityMemberDto

interface UserQueryPort {

    fun selectSecurityMemberBy(email: String): SecurityMemberDto?

}