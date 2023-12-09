package com.flavorite.persistence.repository

import com.flavorite.persistence.entity.MemberEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface MemberRepository : JpaRepository<MemberEntity, Long> {

    fun findByEmail(username: String): MemberEntity?

}