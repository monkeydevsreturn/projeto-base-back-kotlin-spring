package br.com.devs.monkey.excpetion

import java.time.LocalDateTime

data class MessageException(
    val status: Int,
    val message: String?,
    val dataHora: LocalDateTime
)
