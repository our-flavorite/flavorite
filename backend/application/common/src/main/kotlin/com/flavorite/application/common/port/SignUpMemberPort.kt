package com.flavorite.application.common.port

import com.flavorite.application.common.dto.command.SignUpCommand

interface SignUpMemberPort {

    fun execute(command: SignUpCommand)
}