package com.xonmin.rankeycrawler.controller

import com.xonmin.rankeycrawler.service.ArchivingService
import com.xonmin.rankeycrawler.service.CrawlingService
import org.springframework.scheduling.annotation.Async
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Controller

@Controller
class CrawlingController(
    private val crawlingService: CrawlingService,
    private val archivingService: ArchivingService
) {

    @Scheduled(cron = "0 0 21 * * *")
    @Async("subway-schedule-mapping-executor")
    fun resource() {
        val keywordList = crawlingService.crawl()
        archivingService.save(keywordList)
    }
}
