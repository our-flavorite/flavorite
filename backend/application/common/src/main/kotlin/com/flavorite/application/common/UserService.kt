package com.flavorite.application.common

import com.flavorite.applicatoin.dto.command.SaveUserCommand
import org.springframework.stereotype.Service

@Service
class UserService(
    private val saveUserPort: UserSimplePort
) {


    fun greeting(): String {
        return "hello"
    }

    fun execute(command: SaveUserCommand) {
        saveUserPort.execute(command)
    }
}