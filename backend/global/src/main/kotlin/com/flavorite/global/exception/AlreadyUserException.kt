package com.flavorite.global.exception

class AlreadyUserException(
    val errorCode: ErrorCode
) : RuntimeException(errorCode.message)
