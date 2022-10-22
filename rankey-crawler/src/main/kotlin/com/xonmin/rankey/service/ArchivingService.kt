package com.xonmin.rankey.service

import com.xonmin.rankey.model.GoogleKeyword
import com.xonmin.rankey.repository.GoogleKeywordRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ArchivingService(
    private val googleKeywordRepository: GoogleKeywordRepository
) {
    private val log: Logger = LoggerFactory.getLogger(ArchivingService::class.java.name)
    fun save(keywordList: List<GoogleKeyword>) {
        googleKeywordRepository.saveAll(keywordList)
    }
}
