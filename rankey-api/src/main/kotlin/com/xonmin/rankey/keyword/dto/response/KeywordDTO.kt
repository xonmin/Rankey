package com.xonmin.rankey.keyword.dto.response

import com.xonmin.rankey.model.GoogleKeyword
import java.time.LocalDate

data class KeywordDTO(
    val id: String,
    val date: LocalDate,
    val rank: Int,
    val keyword: String,
    val searchCount: String,
    val newsTitle: String,
    val newsLink: String
) {
    companion object {
        fun from(googleKeyword: GoogleKeyword) =
            KeywordDTO(
                id = googleKeyword.id!!.toHexString(),
                date = googleKeyword.date,
                rank = googleKeyword.rank,
                keyword = googleKeyword.keyword,
                searchCount = googleKeyword.searchCount,
                newsTitle = googleKeyword.newsTitle,
                newsLink = googleKeyword.newsLink
            )
    }
}


