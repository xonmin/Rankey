package com.xonmin.rankeycrawler.model

import java.time.LocalDateTime

data class GoogleKeyword (
    private val id: String,
    private val rank: Int,
    private val keyword: String,
    private val searchCount: String,
    private val newsTitle: String,
    private val newsLink: String,
    private val date: String,
    private val createDt: LocalDateTime
)
