package com.flavorite.global.exception

class InvalidAuthorizationHeaderException(
    val errorCode: ErrorCode
) : RuntimeException(errorCode.message) {
}