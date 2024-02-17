package com.flavorite.jpa.repository

import com.flavorite.jpa.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface UserRepository : JpaRepository<UserEntity, Long> {

    fun findByServiceUserId(serviceUserId: String): UserEntity?

}
