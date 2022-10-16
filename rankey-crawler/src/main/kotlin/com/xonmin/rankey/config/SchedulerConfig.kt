package com.xonmin.rankey.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import java.util.concurrent.Executor

@Configuration
@EnableScheduling
@EnableAsync
class SchedulerConfig {

    @Bean(name = ["crawler-executor"])
    fun asyncExecutor(): Executor {
        val executor = ThreadPoolTaskExecutor()
        executor.corePoolSize = 3
        executor.maxPoolSize = 3
        executor.queueCapacity = 3
        executor.setThreadNamePrefix("crawler-scheduler")
        executor.initialize()
        executor.setWaitForTasksToCompleteOnShutdown(true)

        return executor
    }
}
