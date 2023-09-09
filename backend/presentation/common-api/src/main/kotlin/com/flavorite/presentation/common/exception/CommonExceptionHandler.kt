package com.flavorite.presentation.common.exception

import com.flavorite.application.common.command.exception.AlreadyUserException
import com.flavorite.application.common.command.exception.ErrorCode
import com.flavorite.application.common.command.exception.ErrorCode.INVALID_FIELD
import com.flavorite.application.common.command.exception.NotFoundUserException
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
            .body(ErrorMessage(INVALID_FIELD, INVALID_FIELD.message, INVALID_FIELD.status))

    @ExceptionHandler(AlreadyUserException::class)
    fun alreadyUserExceptionHandler(e: AlreadyUserException): ResponseEntity<ErrorMessage> =
        ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body(ErrorMessage(e.errorCode, e.errorCode.message, e.errorCode.status))

    @ExceptionHandler(NotFoundUserException::class)
    fun notFoundUserExceptionHandler(e: NotFoundUserException): ResponseEntity<ErrorMessage> =
        ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(ErrorMessage(e.errorCode, e.errorCode.message, e.errorCode.status))

}

data class ErrorMessage(
    val errorCode: ErrorCode,
    val message: String,
    val status: HttpStatus
)