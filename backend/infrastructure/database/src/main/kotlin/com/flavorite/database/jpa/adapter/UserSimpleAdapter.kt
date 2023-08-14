package com.flavorite.database.jpa.adapter

import com.flavorite.application.common.dto.command.DeleteUserCommand
import com.flavorite.application.common.port.UserSimplePort
import com.flavorite.applicatoin.dto.command.SaveUserCommand
import com.flavorite.applicatoin.dto.command.UpdateUserCommand
import com.flavorite.applicatoin.dto.query.SelectUserQuery
import com.flavorite.applicatoin.dto.value.SelectUsersQuery
import com.flavorite.applicatoin.dto.value.UserDto
import com.flavorite.database.jpa.UserEntity
import com.flavorite.database.jpa.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class UserSimpleAdapter(
    private val userRepository: UserRepository
) : UserSimplePort {

    override fun execute(command: SaveUserCommand) {
        val entity = UserEntity(
            username = command.username,
            email = command.email
        )

        userRepository.save(entity)
    }

    override fun execute(query: SelectUserQuery): UserDto {
        val dto = userRepository.findByIdOrNull(query.userId)?.let {
            UserDto(
                it.userId!!,
                it.username,
                it.email
            )
        }
        return dto ?: throw RuntimeException("Not found user")
    }

    override fun execute(query: SelectUsersQuery): List<UserDto> {
        TODO("Not yet implemented")
    }

    override fun execute(command: UpdateUserCommand) {
        val entity = UserEntity(
            command.userId,
            command.username,
            command.email
        )

        userRepository.save(entity)
    }

    override fun execute(command: DeleteUserCommand) {
        userRepository.deleteById(command.userId)
    }
}