package com.xonmin.rankeycrawler.util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DateUtil {
    companion object {
        val DATE_TIME_WITH_DELIMITER_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        val DATE_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        fun convertDateToString(date: LocalDateTime, formatter: DateTimeFormatter): String {
            return formatter.format(date)
        }

        fun convertDateTimeToDate(dateTime: LocalDateTime, formatter: DateTimeFormatter): String {
            return formatter.format(dateTime)
        }

        fun convertStringToDateTime(dateTime: String): LocalDateTime {
            return LocalDateTime.parse(dateTime)
        }
    }
}
