package com.xonmin.rankeycrawler

import com.xonmin.rankeycrawler.util.Constant
import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.springframework.stereotype.Service

@Service
class CrawlingService {

    val driver = chrome()

    private final fun chrome(): WebDriver {
        WebDriverManager.chromedriver().setup()
        return ChromeDriver()
    }

    fun crawl() {

        try {
            // url get
            driver.get(Constant.GOOGLE_URL)

            val doc: WebElement = driver.findElement(
                By.xpath("/html/body/div[3]/div[2]/div/div[2]/div/div[1]/ng-include/div/div/div/div[2]")
            )

            val date =
                doc.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[2]/div/div[1]/ng-include/div/div/div/div[1]/div/div[1]")).text
            println(date)
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            driver.close()
        }
    }
}
