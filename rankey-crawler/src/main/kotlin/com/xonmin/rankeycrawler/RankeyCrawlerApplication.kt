package com.xonmin.rankeycrawler

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import org.springframework.scheduling.annotation.EnableScheduling

@ComponentScan("com.xonmin.rankeydomain", "com.xonmin.rankeycrawler")
@SpringBootApplication
@EnableScheduling
@EnableMongoRepositories(basePackages = ["com.xonmin.rankeydomain"])
class RankeyCrawlerApplication

fun main(args: Array<String>) {
    runApplication<RankeyCrawlerApplication>(*args)
}
