package com.flavorite.jpa.adapter

import com.flavorite.application.common.query.port.MemberQueryPort
import com.flavorite.jpa.repository.MemberRepository
import org.springframework.stereotype.Component

@Component
class MemberQueryAdapter(
    private val memberRepository: MemberRepository
) : MemberQueryPort {

    override fun selectMemberBy(userId: String): MemberQueryPort.MemberDto? {
        return null
    }

    override fun selectSecurityMemberBy(userId: String): MemberQueryPort.SecurityMemberDto? {
        val entity = memberRepository.findByUserId(userId)
        return null
    }

}
