package com.flavorite.api.health

import com.flavorite.api.model.ApiResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthCheckAPI {

    @GetMapping("/health")
    fun healthCheck(): ApiResponse<String> {
        return ApiResponse.ok("이승은 바보천치")
    }

}
