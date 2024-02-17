package com.flavorite.global.exception

import org.springframework.http.HttpStatus

enum class ErrorCode(
    val code: String,
    val message: String,
    val status: HttpStatus
) {
    INVALID_FIELD("FLA001", "잘못된 입력 양식입니다.", HttpStatus.BAD_REQUEST),
    ALREADY_USER("FLA002", "이미 가입된 사용자입니다.", HttpStatus.CONFLICT),
    NOT_FOUND_USER("FLA003", "사용자를 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
    ANY_MATCH_ENUM("FLA004", "일치하는 열거형이 없습니다.", HttpStatus.NOT_FOUND),
    INVALID_AUTHORIZATION_HEADER("FLA005", "유효하지 않은 authorization header 입니다.", HttpStatus.UNAUTHORIZED),
}