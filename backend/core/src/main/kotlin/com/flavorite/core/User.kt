package com.flavorite.core

import com.flavorite.core.vo.Email
import com.flavorite.core.vo.UserName

class User(
    val userId: Long,
    val username: UserName,
    val email: Email
) {

}