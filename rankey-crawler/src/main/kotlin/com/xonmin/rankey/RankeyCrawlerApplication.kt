package com.xonmin.rankey

import com.xonmin.rankey.util.Constant.RANKEY_BASE_PACKAGE
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication(scanBasePackages = [RANKEY_BASE_PACKAGE])
@ConfigurationPropertiesScan(basePackages = [RANKEY_BASE_PACKAGE])
@EnableMongoRepositories
@EnableScheduling
class RankeyCrawlerApplication

fun main(args: Array<String>) {
    runApplication<RankeyCrawlerApplication>(*args)
}
