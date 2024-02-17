package com.flavorite.api.model

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ApiResponse<T>(
    val body: T?,
) {

    companion object {
        fun <T> ok(body: T? = null): ApiResponse<T> {
            return ApiResponse(body)
        }
    }

}
