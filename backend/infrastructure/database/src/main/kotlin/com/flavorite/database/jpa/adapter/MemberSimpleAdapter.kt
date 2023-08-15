package com.flavorite.database.jpa.adapter

import com.flavorite.application.common.port.SimpleMemberPort
import com.flavorite.applicatoin.dto.value.MemberDto
import com.flavorite.database.jpa.entity.MemberEntity
import com.flavorite.database.jpa.repository.MemberRepository

@Adapter
class MemberSimpleAdapter(
    private val memberRepository: MemberRepository
) : SimpleMemberPort {

    override fun selectBy(email: String): MemberDto? {
        val entity = memberRepository.findByEmail(email)
        return entity?.toDto()
    }

}

fun MemberEntity.toDto(): MemberDto = MemberDto(
    userId!!,
    email,
    username,
    address,
    password
)