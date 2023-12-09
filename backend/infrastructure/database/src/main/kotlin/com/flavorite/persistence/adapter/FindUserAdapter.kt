package com.flavorite.persistence.adapter

import com.flavorite.persistence.annotation.Adapter
import com.flavorite.application.common.command.domain.Member
import com.flavorite.application.common.command.domain.value.*
import com.flavorite.application.common.command.port.FindUserPort
import com.flavorite.persistence.entity.MemberEntity
import com.flavorite.persistence.repository.MemberRepository

@Adapter
class FindUserAdapter(
    private val memberRepository: MemberRepository
) : FindUserPort {

    override fun selectMemberBy(email: String): Member? {
        val entity = memberRepository.findByEmail(email)
        return entity?.toDomain()
    }

}

private fun MemberEntity.toDomain(): Member = Member(
    memberId!!,
    userId = UserId(id),
    Username(username),
    Email(email),
    Password(password),
    Address(address),
    memberRoles.map { UserRole.of(it.memberRoleName) }
)