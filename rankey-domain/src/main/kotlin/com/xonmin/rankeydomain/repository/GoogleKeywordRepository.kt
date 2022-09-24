package com.xonmin.rankeydomain.repository

import com.xonmin.rankeydomain.model.GoogleKeyword
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface GoogleKeywordRepository : MongoRepository<GoogleKeyword, ObjectId> {
    fun findByDateBetween(today: LocalDate, end: LocalDate)
}
