package com.xonmin.rankey.repository

import com.xonmin.rankey.model.GoogleKeyword
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import java.time.LocalDate

interface GoogleKeywordRepository : MongoRepository<GoogleKeyword, ObjectId> {
    fun findByDateBetween(today: LocalDate, past: LocalDate) : List<GoogleKeyword>
}
