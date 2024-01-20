package com.flavorite.jpa.entity

import com.flavorite.jpa.entity.MemberRoleEntity
import jakarta.persistence.*

@Entity
@Table(name = "MEMBER")
class MemberEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val memberId: Long? = null,

    @Column(unique = true, nullable = false)
    val userId: String,

    @Column(unique = true, nullable = false)
    val email: String,

    @Column(nullable = false)
    val username: String,

    val address: String,

    @Column(nullable = true)
    val password: String
) {

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    val memberRoles: MutableList<MemberRoleEntity> = mutableListOf()

    fun addRoles(roles: List<MemberRoleEntity>) {
        memberRoles.addAll(roles)
    }
}