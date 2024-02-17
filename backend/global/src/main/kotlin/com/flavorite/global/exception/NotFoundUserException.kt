package com.flavorite.global.exception

class NotFoundUserException(
    val errorCode: ErrorCode
) : RuntimeException(errorCode.message)

