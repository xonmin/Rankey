package com.xonmin.rankeycrawler.service

import com.xonmin.rankeydomain.model.GoogleKeyword
import com.xonmin.rankeydomain.service.GoogleKeywordService
import org.springframework.stereotype.Service

@Service
class ArchivingService(
    private val googleKeywordService: GoogleKeywordService
) {
    fun save(keywordList: List<GoogleKeyword>) {
        googleKeywordService.saveAll(keywordList)
    }
}
