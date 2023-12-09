package com.flavorite.exception

import exception.AlreadyUserException
import exception.ErrorCode
import exception.NotFoundUserException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class CommonExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun methodArgumentNotValidExceptionHandler(e: MethodArgumentNotValidException): ResponseEntity<ErrorMessage> =
        ResponseEntity
            .badRequest()
            .body(ErrorMessage(ErrorCode.INVALID_FIELD.code, ErrorCode.INVALID_FIELD.message, ErrorCode.INVALID_FIELD.status))

    @ExceptionHandler(AlreadyUserException::class)
    fun alreadyUserExceptionHandler(e: AlreadyUserException): ResponseEntity<ErrorMessage> =
        ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body(ErrorMessage(e.errorCode.code, e.errorCode.message, e.errorCode.status))

    @ExceptionHandler(NotFoundUserException::class)
    fun notFoundUserExceptionHandler(e: NotFoundUserException): ResponseEntity<ErrorMessage> =
        ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(ErrorMessage(e.errorCode.code, e.errorCode.message, e.errorCode.status))

}

data class ErrorMessage(
    val code: String,
    val message: String,
    val status: HttpStatus
)