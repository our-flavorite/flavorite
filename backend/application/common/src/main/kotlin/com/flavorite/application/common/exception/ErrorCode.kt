package com.flavorite.application.common.exception

import org.springframework.http.HttpStatus

enum class ErrorCode(
    val message: String,
    val status: HttpStatus
) {
    INVALID_FIELD("잘못된 입력 양식입니다.", HttpStatus.BAD_REQUEST),
    ALREADY_USER("이미 가입된 사용자입니다.", HttpStatus.CONFLICT),
    NOT_FOUND_USER("사용자를 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
}