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
    val id: ObjectId? = null,
    val rank: Int,
    val keyword: String,
    val searchCount: String,
    val newsTitle: String,
    val newsLink: String,
    val date: LocalDate,
    @CreatedDate val createDt: LocalDateTime
)
