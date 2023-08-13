package com.flavorite.application.common

import com.flavorite.application.common.dto.command.DeleteUserCommand
import com.flavorite.applicatoin.dto.command.SaveUserCommand
import com.flavorite.applicatoin.dto.command.UpdateUserCommand
import com.flavorite.applicatoin.dto.query.SelectUserQuery
import com.flavorite.applicatoin.dto.value.SelectUsersQuery
import com.flavorite.applicatoin.dto.value.UserDto

interface UserSimplePort {

    fun execute(command: SaveUserCommand)

    fun execute(query: SelectUserQuery): UserDto

    fun execute(query: SelectUsersQuery): List<UserDto>

    fun execute(command: UpdateUserCommand)

    fun execute(command: DeleteUserCommand)

}
