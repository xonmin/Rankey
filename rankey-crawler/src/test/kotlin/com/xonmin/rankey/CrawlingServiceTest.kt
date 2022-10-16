package com.xonmin.rankey

import com.xonmin.rankey.service.CrawlingService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class CrawlingServiceTest {

    @Autowired
    lateinit var crawlingService: CrawlingService

    @Test
    fun test() {
        crawlingService.crawl()
    }
}
