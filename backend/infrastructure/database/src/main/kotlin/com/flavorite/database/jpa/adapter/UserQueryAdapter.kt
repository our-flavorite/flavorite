package com.flavorite.database.jpa.adapter

import com.flavorite.application.common.query.dto.SecurityMemberDto
import com.flavorite.application.common.query.port.UserQueryPort
import com.flavorite.database.jpa.entity.MemberEntity
import com.flavorite.database.jpa.repository.MemberRepository

@Adapter
class UserQueryAdapter(
    private val memberRepository: MemberRepository
) : UserQueryPort {

    override fun selectSecurityMemberBy(email: String): SecurityMemberDto? {
        val entity = memberRepository.findByEmail(email)
        return entity?.toSecurityDto()
    }

}

private fun MemberEntity.toSecurityDto(): SecurityMemberDto = SecurityMemberDto(
    email,
    username,
    address,
    password,
    memberRoles.map { it.memberRoleName }.toMutableList(),
    registerDate,
    modifyDate
)