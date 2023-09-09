package com.flavorite.database.jpa.adapter

import com.flavorite.application.common.command.domain.User
import com.flavorite.application.common.command.domain.enums.UserRole
import com.flavorite.application.common.command.domain.vo.Address
import com.flavorite.application.common.command.domain.vo.Email
import com.flavorite.application.common.command.domain.vo.Password
import com.flavorite.application.common.command.domain.vo.Username
import com.flavorite.application.common.command.port.FindUserPort
import com.flavorite.database.jpa.entity.MemberEntity
import com.flavorite.database.jpa.repository.MemberRepository

@Adapter
class FindUserAdapter(
    private val memberRepository: MemberRepository
) : FindUserPort {

    override fun selectMemberBy(email: String): User? {
        val entity = memberRepository.findByEmail(email)
        return entity?.toDomain()
    }

}

private fun MemberEntity.toDomain(): User = User(
    userId!!,
    Username(username) ,
    Email(email),
    Password(password),
    Address(address),
    memberRoles.map { UserRole.of(it.memberRoleName) }
)