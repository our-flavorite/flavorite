package com.flavorite.database.jpa.entity

import jakarta.persistence.*


@Entity
@Table(name = "MEMBER_ROLE")
class MemberRoleEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val memberRoleId: Long? = null,
    val memberRoleName: String,
) {
}