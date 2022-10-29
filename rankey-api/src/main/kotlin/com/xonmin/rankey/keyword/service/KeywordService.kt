package com.xonmin.rankey.keyword.service


import com.xonmin.rankey.keyword.dto.response.KeywordDTO
import com.xonmin.rankey.keyword.dto.response.LastWeekKeywordResponseDTO
import com.xonmin.rankey.repository.GoogleKeywordRepository
import com.xonmin.rankey.support.TriggerContext
import org.springframework.stereotype.Service

@Service
class KeywordService(
    private val keywordRepository: GoogleKeywordRepository
) {
    fun getLatestWeeksKeyword(context: TriggerContext): LastWeekKeywordResponseDTO {
        val nowDay = context.getTriggerDate()
        val lastWeeksKeywordsDTO = keywordRepository.findByDateBetween(nowDay, nowDay.minusDays(7))
            .map { KeywordDTO.from(it) }

        return LastWeekKeywordResponseDTO(nowDay, lastWeeksKeywordsDTO)
    }

}