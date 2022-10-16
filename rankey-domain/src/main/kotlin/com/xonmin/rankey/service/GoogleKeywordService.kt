package com.xonmin.rankeydomain.service

import com.xonmin.rankeydomain.model.GoogleKeyword
import com.xonmin.rankeydomain.repository.GoogleKeywordRepository
import org.springframework.stereotype.Service

@Service
class GoogleKeywordService(
    private val repository: GoogleKeywordRepository
) {
    fun saveAll(keywordList: List<GoogleKeyword>) {
        repository.saveAll(keywordList)
    }
}