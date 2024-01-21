package com.flavorite.global.exception

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ErrorResponse(
    val code: String,
    val message: String,
    val violations: List<Violation>? = null
) {

    data class Violation(
        val field: String,
        val message: String
    )

}
