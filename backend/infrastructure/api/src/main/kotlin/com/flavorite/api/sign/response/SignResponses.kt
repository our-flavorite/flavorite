package com.flavorite.api.sign.response

data class SignInResponse(
    val accessToken: String,
    val refreshToken: String
)
