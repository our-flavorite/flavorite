package com.flavorite.application.common.exception

class NotFoundUserException(
    val errorCode: ErrorCode
) : RuntimeException(errorCode.message)
