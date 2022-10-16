package com.xonmin.rankey.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate
import java.time.LocalDateTime

@Document("google-keyword")
data class GoogleKeyword(
    @Id
    private val id: ObjectId? = null,
    private val rank: Int,
    private val keyword: String,
    private val searchCount: String,
    private val newsTitle: String,
    private val newsLink: String,
    private val date: LocalDate,
    @CreatedDate private val createDt: LocalDateTime
)
