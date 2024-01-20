package com.flavorite.jpa.repository

import com.flavorite.jpa.entity.MemberEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface MemberRepository : JpaRepository<MemberEntity, Long> {

    fun findByUserId(userId: String): MemberEntity?

    fun existsByUserId(userId: String): Boolean

}