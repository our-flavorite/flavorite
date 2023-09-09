package com.flavorite.application.common.command.domain.vo

data class Email(
    private val value: String
) {

    init {
        validate(value)
    }

    private fun validate(value: String) {
        if(!value.contains("@")) throw RuntimeException("잘못된 형식의 이메일입니다.")
    }
}