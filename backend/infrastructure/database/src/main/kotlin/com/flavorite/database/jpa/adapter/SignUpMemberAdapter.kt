package com.flavorite.database.jpa.adapter

import com.flavorite.application.common.command.SignUpCommand
import com.flavorite.application.common.command.port.SignUpMemberPort
import com.flavorite.database.jpa.entity.MemberEntity
import com.flavorite.database.jpa.entity.MemberRoleEntity
import com.flavorite.database.jpa.repository.MemberRepository

@Adapter
class SignUpMemberAdapter(
    private val memberRepository: MemberRepository
) : SignUpMemberPort {

    override fun execute(command: SignUpCommand) {
        val entity = command.toEntity()
        val memberRoleEntities = command.roles.map { MemberRoleEntity(memberRoleName = it) }
        entity.addRoles(memberRoleEntities)
        memberRepository.save(entity)
    }

}

private fun SignUpCommand.toEntity() = MemberEntity(
    email = email,
    username = username,
    address = address,
    password = password
)