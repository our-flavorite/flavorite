package com.flavorite.api.sign

import com.fasterxml.jackson.databind.ObjectMapper
import com.flavorite.api.sign.request.SignUpRequest
import com.flavorite.common.command.port.`in`.SignUpInPort
import com.flavorite.security.jwt.JwtAuthenticateFilter
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.FilterType
import org.springframework.http.MediaType
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post


@WebMvcTest(
    controllers = [SignUpAPI::class],
    excludeFilters = [
        ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = [JwtAuthenticateFilter::class])
    ]
)
class SignUpAPITest {

    @Autowired
    lateinit var objectMapper: ObjectMapper

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var signUpInPort: SignUpInPort

    @MockBean
    lateinit var passwordEncoder: PasswordEncoder

    @WithMockUser
    @Test
    fun validate_field_violation() {
        val request = SignUpRequest(
            serviceUserId = "세글자",
            password = "123",
            nickname = "콩",
            email = "woogietemporary.com",
            address = "대구광역시"
        )
        val jsonString = objectMapper.writeValueAsString(request)

        mockMvc
            .post("/api/v1/sign/up") {
                contentType = MediaType.APPLICATION_JSON
                content = jsonString
                with(csrf())
            }
            .andExpectAll {
                status { isBadRequest() }
                jsonPath("$.code", `is`("FLA001"))
                jsonPath("$.message") { `is`("잘못된 입력 양식입니다.") }
                jsonPath("$.violations") { isArray() }
            }

    }

}
