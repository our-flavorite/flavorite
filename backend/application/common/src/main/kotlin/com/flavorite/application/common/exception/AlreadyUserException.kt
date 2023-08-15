package com.flavorite.application.common.exception

class AlreadyUserException(
    val errorCode: ErrorCode
) : RuntimeException() {
}