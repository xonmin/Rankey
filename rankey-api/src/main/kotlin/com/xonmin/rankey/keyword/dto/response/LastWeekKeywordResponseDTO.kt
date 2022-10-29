package com.xonmin.rankey.keyword.dto.response

import java.time.LocalDate

data class LastWeekKeywordResponseDTO(
    val date: LocalDate,
    val keywords: List<KeywordDTO>
)
