package com.xonmin.rankey.repository

import com.xonmin.rankey.model.GoogleKeyword
import com.xonmin.rankey.model.GoogleKeywordAggregation
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.aggregation.Aggregation
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
class GoogleKeywordAggRepository(
    private val template: MongoTemplate
) {
    fun getTotalRankForMonth(today: LocalDate): Map<String, Int> {
        val aggregation = Aggregation.newAggregation(
            Aggregation.match(
                Criteria.where(GoogleKeyword::date.name)
                    .gte(today.minusDays(8))
                    .lte(today.minusDays(1))
            ),
            Aggregation.group(GoogleKeyword::keyword.name)
                .sum(GoogleKeyword::rank.name)
                .`as`(GoogleKeywordAggregation::score.name)
        )

        val groupResults =
            template.aggregate(aggregation, GoogleKeyword::class.java, GoogleKeywordAggregation::class.java)

        return groupResults.mappedResults
            .associateBy { it.keyword }
            .mapValues { it.value.score }
    }
}
