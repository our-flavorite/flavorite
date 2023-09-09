package com.flavorite.application.common.command.exception

class NotFoundUserException(
    val errorCode: ErrorCode
) : RuntimeException(errorCode.message)
