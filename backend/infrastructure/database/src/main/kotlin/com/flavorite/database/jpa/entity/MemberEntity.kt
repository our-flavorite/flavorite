package com.flavorite.database.jpa.entity

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant

@Entity
@Table(name = "MEMBER")
class MemberEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val userId: Long? = null,

    @Column(unique = true, nullable = false)
    val email: String,

    @Column(nullable = false)
    val username: String,

    val address: String,

    @Column(nullable = true)
    val password: String,

) {

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    val memberRoles: MutableList<MemberRoleEntity> = mutableListOf()

    fun addRoles(roles: List<MemberRoleEntity>) {
        memberRoles.addAll(roles)
    }

    @CreationTimestamp
    lateinit var registerDate: Instant

    @UpdateTimestamp
    lateinit var modifyDate: Instant
}