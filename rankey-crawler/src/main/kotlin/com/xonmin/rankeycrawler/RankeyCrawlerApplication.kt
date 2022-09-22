package com.xonmin.rankeycrawler

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class RankeyCrawlerApplication

fun main(args: Array<String>) {
    runApplication<RankeyCrawlerApplication>(*args)
}
