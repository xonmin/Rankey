package com.xonmin.rankey.support

import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId

class TriggerContext(private val triggerEpochMills: Long) {

    fun getTriggerDateTime(): LocalDateTime {
        return Instant.ofEpochMilli(triggerEpochMills).atZone(ZoneId.systemDefault()).toLocalDateTime()
    }

    fun getTriggerDate(): LocalDate {
        return Instant.ofEpochMilli(triggerEpochMills).atZone(ZoneId.systemDefault()).toLocalDate()
    }

    companion object {
        fun now(): TriggerContext {
            return TriggerContext(Instant.now().toEpochMilli())
        }
    }
}
