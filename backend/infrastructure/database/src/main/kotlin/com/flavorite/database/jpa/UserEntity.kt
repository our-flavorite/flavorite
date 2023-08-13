package com.flavorite.database.jpa

import jakarta.persistence.*

@Entity
@Table(name = "USERS")
class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val userId: Long? = null,
    val username: String,
    val email: String
) {
}