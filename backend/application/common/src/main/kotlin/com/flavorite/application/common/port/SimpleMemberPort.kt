package com.flavorite.application.common.port

import com.flavorite.applicatoin.dto.value.MemberDto

interface SimpleMemberPort {

    fun selectBy(email: String): MemberDto?

}