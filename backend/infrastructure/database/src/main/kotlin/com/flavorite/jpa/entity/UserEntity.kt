package com.flavorite.jpa.entity

import jakarta.persistence.*

@Entity
@Table(name = "USERS")
class UserEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val userId: Long? = null,

    @Column(unique = true, nullable = false)
    val serviceUserId: String,

    @Column(nullable = true)
    val password: String,

    @Column(nullable = false)
    val nickname: String,

    @Column(nullable = false)
    val email: String,

    val address: String,

    @Column(nullable = false)
    val userRole: String

) : BaseTimeEntity()
