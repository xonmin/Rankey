dependencies {
    api(project(":rankey-domain"))
    //spring
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // cache
    implementation("org.ehcache:ehcache:3.10.2")

    // Spring Actuator
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    // Micrometer Registry prometheus
    implementation("io.micrometer:micrometer-registry-prometheus:1.9.5")

    // etc
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
}

tasks.bootJar {
    enabled = false
}

tasks.jar {
    enabled = true
}
