package com.xonmin.rankey.keyword.controller

import com.xonmin.rankey.keyword.dto.response.LastWeekKeywordResponseDTO
import com.xonmin.rankey.keyword.service.KeywordService
import com.xonmin.rankey.support.TriggerContext
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class KeywordController(
    private val keywordService: KeywordService
) {
    @GetMapping("/")
    fun showLastWeekKeyword(): LastWeekKeywordResponseDTO {
        val context = TriggerContext.now()

        return keywordService.getLatestWeeksKeyword(context)
    }
}
