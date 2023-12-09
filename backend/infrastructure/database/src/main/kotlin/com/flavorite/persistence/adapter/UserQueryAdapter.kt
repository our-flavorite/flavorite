package com.flavorite.persistence.adapter

import com.flavorite.persistence.annotation.Adapter
import com.flavorite.application.common.query.dto.SecurityMemberDto
import com.flavorite.application.common.query.port.UserQueryPort
import com.flavorite.persistence.entity.MemberEntity
import com.flavorite.persistence.repository.MemberRepository

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
    createdDatetime,
    modifiedDatetime
)