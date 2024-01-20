package com.flavorite.exception

class AlreadyUserException(
    errorCode: ErrorCode
) : RuntimeException(errorCode.message) {
}