package com.flavorite.jpa.extension

import com.flavorite.common.command.port.out.SignUpOutPort
import com.flavorite.common.query.port.out.UserQueryOutPort
import com.flavorite.jpa.entity.UserEntity

fun SignUpOutPort.SignUpCommand.toUserEntity() = UserEntity(
    serviceUserId = serviceUserId,
    password = password,
    email = email,
    nickname = nickname,
    address = address,
    userRole = userRole
)

fun UserEntity.toUserDto() = UserQueryOutPort.UserDto(
    userId = userId!!,
    serviceUserId = serviceUserId,
    nickname = nickname,
    email = email,
    password = password,
    address = address
)

fun UserEntity.toSecurityUserDto() = UserQueryOutPort.SecurityUserDto(
    serviceUserId = serviceUserId,
    password = password,
    userRole = userRole,
    createdDatetime = createdDatetime,
    modifiedDatetime = modifiedDatetime
)
