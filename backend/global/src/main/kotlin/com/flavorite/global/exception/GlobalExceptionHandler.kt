package com.flavorite.global.exception

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(AlreadyUserException::class)
    fun handleAlreadyUserException(e: AlreadyUserException): ResponseEntity<ErrorResponse> {
        return ResponseEntity
            .status(e.errorCode.status)
            .body(ErrorResponse(e.errorCode.code, e.errorCode.message))
    }

    @ExceptionHandler(NotFoundUserException::class)
    fun handleAlreadyUserException(e: NotFoundUserException): ResponseEntity<ErrorResponse> {
        return ResponseEntity
            .status(e.errorCode.status)
            .body(ErrorResponse(e.errorCode.code, e.errorCode.message))
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun global(e: MethodArgumentNotValidException): ResponseEntity<ErrorResponse> {
        val violations = e.bindingResult.fieldErrors.map {
            ErrorResponse.Violation(
                it.field,
                it.defaultMessage ?: ""
            )
        }.ifEmpty { null }

        return ResponseEntity
            .status(e.statusCode)
            .body(
                ErrorResponse(
                    code = ErrorCode.INVALID_FIELD.code,
                    message = ErrorCode.INVALID_FIELD.message,
                    violations = violations
                )
            )
    }
}
