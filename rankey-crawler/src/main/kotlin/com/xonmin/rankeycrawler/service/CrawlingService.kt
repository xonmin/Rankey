package com.xonmin.rankeycrawler.service

import com.xonmin.rankeycrawler.util.Constant
import com.xonmin.rankeycrawler.util.DateUtil
import com.xonmin.rankeydomain.model.GoogleKeyword
import io.github.bonigarcia.wdm.WebDriverManager
import org.bson.types.ObjectId
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.LocalDateTime

@Service
class CrawlingService {
    private val log: Logger = LoggerFactory.getLogger(CrawlingService::class.java.name)

    private final fun chrome(): WebDriver {
        WebDriverManager.chromedriver().setup()
        return ChromeDriver()
    }

    fun crawl(): List<GoogleKeyword> {
        val driver = chrome()
        val dateTimeStamp =
            DateUtil.convertDateToString(LocalDateTime.now(), DateUtil.DATE_TIME_WITH_DELIMITER_FORMATTER)
        val date = DateUtil.convertDateTimeToDate(LocalDateTime.now().minusDays(1))
        log.info("Start Crawling For [$date] At : [$dateTimeStamp]")

        try {
            // url get
            driver.get(Constant.GOOGLE_URL)

            val targetKeywordsBox: WebElement = driver.findElement(By.xpath(Constant.CRAWL_TARGET_BOX_XPATH))
            val crawlDate = targetKeywordsBox.findElement(By.xpath(Constant.CRWAL_TARGET_DATE_XPATH)).text
            log.info("Access Page Keyword Target : [$crawlDate]")

            val keywordBlockList =
                targetKeywordsBox.findElements(By.className(Constant.CRWAL_TARGET_BLOCKLIST_CLASSNAME))

            return keywordBlockList.map { block ->
                toGoogleKeyword(block, dateTimeStamp, date)
            }.toList()
        } catch (e: Exception) {
            log.error("Crawling ERROR : [${e.printStackTrace()}]")
        } finally {
            driver.close()
        }
        return emptyList()
    }

    private fun toGoogleKeyword(
        block: WebElement,
        dateTimeStamp: String,
        crawlDate: LocalDate
    ): GoogleKeyword {
        val element = block.findElement(By.tagName(Constant.TAG_FEED_ITEM))
            .findElement(By.tagName(Constant.TAG_NG_INCLUDE))
            .findElement(By.tagName(Constant.TAG_DIV))
            .findElement(By.className(Constant.CLASS_FEED_ITEM_HEADER))
            .findElement(By.className(Constant.CLASS_DETAILS_WRAPPER))

        // keyword details
        val rank = element.findElement(By.className(Constant.CLASS_INDEX)).text.toInt()
        val detailContext = element.findElement(By.className(Constant.CLASS_DETAILS))
        val keyword = detailContext.findElement(By.className(Constant.CLASS_DETAILS_TOP))
            .findElement(By.className(Constant.CLASS_TITLE))
            .findElement(By.tagName(Constant.TAG_SPAN))
            .findElement(By.tagName(Constant.TAG_A)).text
        val news = detailContext.findElement(By.className(Constant.CLASS_DETAILS_BOTTOM))
            .findElement(By.tagName(Constant.TAG_DIV))
            .findElement(By.className(Constant.CLASS_SUMMARY_TEXT))
        val newsUrl = news.getAttribute(Constant.ATTRIBUTE_HREF)
        val newsTitle = news.text
        val searchCount = element.findElement(By.tagName(Constant.TAG_NG_INCLUDE))
            .findElement(By.className(Constant.CLASS_SEARCH_COUNT))
            .findElement(By.className(Constant.CLASS_SEARCH_COUNT_TITLE)).text
        val timestamp = DateUtil.convertStringToDateTime(dateTimeStamp)

        // @TODO fix invalid hexadecimal representation of an ObjectId: [개천절]
        return GoogleKeyword(
            id = ObjectId(keyword),
            rank = rank,
            keyword = keyword,
            searchCount = searchCount,
            newsTitle = newsTitle,
            newsLink = newsUrl,
            date = crawlDate,
            createDt = timestamp
        )
    }
}
