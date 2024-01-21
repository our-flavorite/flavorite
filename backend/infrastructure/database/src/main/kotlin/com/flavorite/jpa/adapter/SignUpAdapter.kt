package com.flavorite.jpa.adapter

import com.flavorite.jpa.repository.UserRepository
import com.flavorite.common.command.port.out.SignUpOutPort
import com.flavorite.jpa.extension.toUserEntity
import org.springframework.stereotype.Component

@Component
class SignUpAdapter(
    private val userRepository: UserRepository
) : SignUpOutPort {

    override fun execute(command: SignUpOutPort.SignUpCommand) {
        userRepository.save(command.toUserEntity())
    }

}
