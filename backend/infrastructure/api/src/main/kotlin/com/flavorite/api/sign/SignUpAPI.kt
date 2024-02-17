package com.flavorite.api.sign

import com.flavorite.api.sign.request.SignUpRequest
import com.flavorite.common.command.port.`in`.SignUpInPort
import com.flavorite.api.model.ApiResponse
import com.flavorite.api.model.ApiResponse.Companion.ok
import jakarta.servlet.http.HttpServletResponse
import jakarta.validation.Valid
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class SignUpAPI(
    private val signUpInPort: SignUpInPort,
    private val passwordEncoder: PasswordEncoder
) {

    @PostMapping("/sign/up")
    fun signUp(@Valid @RequestBody request: SignUpRequest, response: HttpServletResponse): ApiResponse<Unit> {
        SignUpInPort.SignUpCommand(
            serviceUserId = request.serviceUserId,
            password = passwordEncoder.encode(request.password),
            nickname = request.nickname,
            email = request.email,
            address = request.address,
            userRole = request.userRole
        ).run {
            signUpInPort.execute(this)
        }

        return ok()
    }

}
