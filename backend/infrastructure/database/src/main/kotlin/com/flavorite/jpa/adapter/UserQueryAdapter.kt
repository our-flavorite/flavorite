package com.flavorite.jpa.adapter

import com.flavorite.common.query.port.out.UserQueryOutPort
import com.flavorite.jpa.extension.toSecurityUserDto
import com.flavorite.jpa.extension.toUserDto
import com.flavorite.jpa.repository.UserRepository
import org.springframework.stereotype.Component

@Component
class UserQueryAdapter(
    private val userRepository: UserRepository
) : UserQueryOutPort {

    override fun selectUserBy(serviceUserId: String) = userRepository
        .findByServiceUserId(serviceUserId)
        ?.toUserDto()

    override fun selectSecurityUserBy(serviceUserId: String) = userRepository
        .findByServiceUserId(serviceUserId)
        ?.toSecurityUserDto()

}
