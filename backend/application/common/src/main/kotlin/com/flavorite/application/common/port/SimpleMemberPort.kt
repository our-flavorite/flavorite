package com.flavorite.application.common.port

import com.flavorite.application.common.dto.value.SecurityMemberDto
import com.flavorite.applicatoin.dto.value.MemberDto

interface SimpleMemberPort {

    fun selectMemberBy(email: String): MemberDto?

    fun selectSecurityMemberBy(email: String): SecurityMemberDto?

}