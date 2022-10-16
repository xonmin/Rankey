package com.xonmin.rankey.service

import com.xonmin.rankey.model.GoogleKeyword
import com.xonmin.rankey.repository.GoogleKeywordRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class GoogleKeywordService(
    private val repository: GoogleKeywordRepository
) {
    private val log: Logger = LoggerFactory.getLogger(GoogleKeywordService::class.java.name)
    fun saveAll(keywordList: List<GoogleKeyword>) {
        log.info("save domain keyword")
        repository.saveAll(keywordList)
    }
}
