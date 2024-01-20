package com.flavorite.api.health

import com.flavorite.api.response.ApiResponse
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HealthCheckApi {

    @GetMapping("/health")
    fun heath(): ApiResponse<Unit> {
        return ApiResponse.ok()
    }

}
