package com.xonmin.rankeydomain.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import java.time.LocalDateTime

data class GoogleKeyword(
    @Id
    private val id: ObjectId,
    private val rank: Int,
    private val keyword: String,
    private val searchCount: String,
    private val newsTitle: String,
    private val newsLink: String,
    private val date: String,
    private val createDt: LocalDateTime
)
