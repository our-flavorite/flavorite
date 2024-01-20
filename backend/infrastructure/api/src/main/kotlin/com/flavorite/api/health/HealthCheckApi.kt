package com.flavorite.api.health

import com.flavorite.response.ApiResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthCheckApi {

    @GetMapping("/health")
    fun heath(): ApiResponse<Unit> {
        return ApiResponse.ok()
    }

}
