package com.flavorite.global.advice.transaction

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class Tx private constructor(
    advice: TxAdvice
) {

    init {
        txAdvice = advice
    }

    companion object {

        private lateinit var txAdvice: TxAdvice

        fun <T> read(block: () -> T): T {
            return txAdvice.read(block)
        }

        fun <T> write(block: () -> T): T {
            return txAdvice.write(block)
        }

    }
}

@Component
private class TxAdvice {

    @Transactional(readOnly = true)
    fun <T> read(block: () -> T): T {
        return block()
    }

    @Transactional
    fun <T> write(block: () -> T): T {
        return block()
    }

}