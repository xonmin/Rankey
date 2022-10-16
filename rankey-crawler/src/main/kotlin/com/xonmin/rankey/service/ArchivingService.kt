package com.xonmin.rankey.service

import com.xonmin.rankey.model.GoogleKeyword
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ArchivingService(
    private val googleKeywordService: GoogleKeywordService
) {
    private val log: Logger = LoggerFactory.getLogger(ArchivingService::class.java.name)
    fun save(keywordList: List<GoogleKeyword>) {
        googleKeywordService.saveAll(keywordList)
    }
}
