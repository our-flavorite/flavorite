package com.flavorite.persistence.adapter

import com.flavorite.persistence.annotation.Adapter
import com.flavorite.application.common.command.port.SignUpMemberPort
import com.flavorite.application.common.command.usecases.SignUpUseCase
import com.flavorite.persistence.entity.MemberEntity
import com.flavorite.persistence.entity.MemberRoleEntity
import com.flavorite.persistence.repository.MemberRepository

@Adapter
class SignUpMemberAdapter(
    private val memberRepository: MemberRepository
) : SignUpMemberPort {

    override fun execute(command: SignUpUseCase.SignUpCommand) {
        val entity = command.toEntity()
        val memberRoleEntities = command.roles.map { MemberRoleEntity(memberRoleName = it) }
        entity.addRoles(memberRoleEntities)
        memberRepository.save(entity)
    }

}

private fun SignUpUseCase.SignUpCommand.toEntity() = MemberEntity(
    id = userId,
    email = email,
    username = username,
    address = address,
    password = password
)