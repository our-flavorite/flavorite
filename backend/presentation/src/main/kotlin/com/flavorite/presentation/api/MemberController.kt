package com.flavorite.presentation.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MemberController {

    @GetMapping("/greeting")
    fun greeting(): String {
        return "hello"
    }

}