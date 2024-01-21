package com.flavorite.jpa.entity

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@EntityListeners(AuditingEntityListener::class)
@MappedSuperclass
open class BaseTimeEntity {

    @Column(updatable = false)
    @CreatedDate
    lateinit var createdDatetime: LocalDateTime

    @LastModifiedDate
    lateinit var modifiedDatetime: LocalDateTime

}
