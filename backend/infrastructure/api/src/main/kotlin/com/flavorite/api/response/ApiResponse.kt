package com.flavorite.api.response

import org.springframework.http.HttpStatus

data class ApiResponse<T>(
    val body: T?,
    val status: HttpStatus
) {

    companion object {
        fun <T> ok(body: T? = null): ApiResponse<T> {
            return ApiResponse(body, HttpStatus.OK)
        }
    }
}