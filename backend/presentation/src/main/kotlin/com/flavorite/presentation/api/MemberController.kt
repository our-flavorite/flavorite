package com.flavorite.presentation.api

import com.flavorite.core.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MemberController(@Autowired private val memberService: MemberService) {




    @GetMapping("/greeting")
    fun greeting(): String {
        return memberService.hello()
    }

}