package com.xonmin.rankeycrawler.util

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DateUtil {
    companion object {
        val DATE_TIME_WITH_DELIMITER_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        val DATE_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        fun convertDateToString(date: LocalDateTime, formatter: DateTimeFormatter): String {
            return formatter.format(date)
        }

        fun convertDateTimeToDate(dateTime: LocalDateTime): LocalDate {
            return LocalDate.from(dateTime)
        }

        fun convertStringToDateTime(dateTime: String): LocalDateTime {
            return LocalDateTime.parse(dateTime, DATE_TIME_WITH_DELIMITER_FORMATTER)
        }
    }
}
