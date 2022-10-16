package com.xonmin.rankeycrawler.controller

import com.xonmin.rankeycrawler.service.ArchivingService
import com.xonmin.rankeycrawler.service.CrawlingService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class CrawlingController(
    private val crawlingService: CrawlingService,
    private val archivingService: ArchivingService
) {
    private val log: Logger = LoggerFactory.getLogger(CrawlingController::class.java.name)
    // @Scheduled(cron = "0 0 21 * * *")
    @GetMapping("/main")
    //@Async("subway-schedule-mapping-executor")
    fun resource() {
        log.info("start crawling")
        val keywordList = crawlingService.crawl()
        archivingService.save(keywordList)
    }
}