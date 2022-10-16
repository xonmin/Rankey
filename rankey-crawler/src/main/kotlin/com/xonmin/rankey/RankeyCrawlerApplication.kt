package com.xonmin.rankeycrawler

import com.xonmin.rankeycrawler.util.Constant.RANKEY_BASE_PACKAGE
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.scheduling.annotation.EnableScheduling

@ComponentScan("com.xonmin.rankeydomain", "com.xonmin.rankeycrawler")
@SpringBootApplication(scanBasePackages = [RANKEY_BASE_PACKAGE])
@EnableScheduling
@ConfigurationPropertiesScan(basePackages = [RANKEY_BASE_PACKAGE])
class RankeyCrawlerApplication

fun main(args: Array<String>) {
    runApplication<RankeyCrawlerApplication>(*args)
}
