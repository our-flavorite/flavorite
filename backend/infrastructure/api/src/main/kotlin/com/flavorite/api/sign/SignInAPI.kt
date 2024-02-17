package com.flavorite.api.sign

import com.flavorite.api.sign.request.SignInRequest
import com.flavorite.security.service.SecuritySignInService
import com.flavorite.api.model.ApiResponse
import com.flavorite.security.model.JsonWebToken
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class SignInAPI(
    private val securitySignInService: SecuritySignInService,
) {

    @PostMapping("/sign/in")
    fun signIn(@RequestBody request: SignInRequest): ApiResponse<JsonWebToken> {
        val jwt = securitySignInService.signIn(
            request.serviceUserId,
            request.password
        )

        return ApiResponse.ok(jwt)
    }

}
