package com.flavorite.security.model

data class JsonWebToken(
    val accessToken: String,
    val refreshToken: String
)
