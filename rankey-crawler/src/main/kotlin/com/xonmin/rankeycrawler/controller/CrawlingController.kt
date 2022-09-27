package com.xonmin.rankeycrawler.controller

import com.xonmin.rankeycrawler.service.ArchivingService
import com.xonmin.rankeycrawler.service.CrawlingService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Async
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import javax.annotation.PostConstruct

@Controller
class CrawlingController(
    private val crawlingService: CrawlingService,
    private val archivingService: ArchivingService
) {
   // @Scheduled(cron = "0 0 21 * * *")
    @GetMapping("/main")
    //@Async("subway-schedule-mapping-executor")
    fun resource() {
        val keywordList = crawlingService.crawl()
        archivingService.save(keywordList)
    }
}
