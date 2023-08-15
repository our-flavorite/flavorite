package com.flavorite.database.jpa.repository

import com.flavorite.database.jpa.entity.MemberEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface MemberRepository : JpaRepository<MemberEntity, Long> {

    fun findByEmail(username: String): MemberEntity?

}