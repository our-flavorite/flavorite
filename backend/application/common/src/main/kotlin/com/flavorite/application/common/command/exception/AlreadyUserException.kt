package com.flavorite.application.common.command.exception

class AlreadyUserException(
    val errorCode: ErrorCode
) : RuntimeException(errorCode.message) {
}