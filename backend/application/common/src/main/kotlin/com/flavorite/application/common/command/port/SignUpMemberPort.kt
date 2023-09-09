package com.flavorite.application.common.command.port

import com.flavorite.application.common.command.SignUpCommand

interface SignUpMemberPort {

    fun execute(command: SignUpCommand)
}