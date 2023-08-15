package com.flavorite.database.jpa.adapter

import com.flavorite.application.common.dto.value.SecurityMemberDto
import com.flavorite.application.common.port.SimpleMemberPort
import com.flavorite.applicatoin.dto.value.MemberDto
import com.flavorite.database.jpa.entity.MemberEntity
import com.flavorite.database.jpa.repository.MemberRepository

@Adapter
class MemberSimpleAdapter(
    private val memberRepository: MemberRepository
) : SimpleMemberPort {

    override fun selectMemberBy(email: String): MemberDto? {
        val entity = memberRepository.findByEmail(email)
        return entity?.toDto()
    }

    override fun selectSecurityMemberBy(email: String): SecurityMemberDto? {
        val entity = memberRepository.findByEmail(email)
        return entity?.toSecurityDto()
    }

}

fun MemberEntity.toDto(): MemberDto = MemberDto(
    userId!!,
    email,
    username,
    address,
    password
)

fun MemberEntity.toSecurityDto(): SecurityMemberDto = SecurityMemberDto(
    email,
    username,
    address,
    password,
    memberRoles.map { it.memberRoleName }.toMutableList(),
    registerDate,
    modifyDate
)