package com.flavorite.jpa.adapter

import com.flavorite.application.common.command.port.SignUpMemberPort
import com.flavorite.application.common.command.usecases.SignUpUseCase
import com.flavorite.jpa.repository.MemberRepository
import org.springframework.stereotype.Component

@Component
class SignUpMemberAdapter(
    private val memberRepository: MemberRepository
) : SignUpMemberPort {

    override fun execute(command: SignUpUseCase.SignUpCommand) {

    }

}

