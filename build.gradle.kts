import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        maven(url = "https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath("gradle.plugin.org.datlowe.maven-publish-auth:buildSrc:2.0.2")
        classpath("org.jlleitschuh.gradle:ktlint-gradle:9.1.0")
        classpath("org.springframework.boot:spring-boot-gradle-plugin:2.7.1")
        classpath("com.github.mowedgrass:jasypt-gradle-boot-plugin:0.1.33")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${project.properties["kotlinVersion"]}")
    }
}

plugins {
    id("org.springframework.boot") version "2.7.3"
    id("io.spring.dependency-management") version "1.0.13.RELEASE"
    id("application")
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    id("org.jlleitschuh.gradle.ktlint") version "10.3.0"
}

allprojects {
    repositories {
        mavenCentral()
    }
}
java.sourceCompatibility = JavaVersion.VERSION_1_8

/** Version */
val kotlinLoggingVersion = "2.1.20"

application {
    mainClass.set("com.xonmin.api.RankeyApiApplication.kt")
}

subprojects {
    group = "com.xonmin"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }

    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "java-library")
    apply(plugin = "kotlin")
    apply(plugin = "kotlin-spring")
    apply(plugin = "application")

    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

        // Kotlin Logging
        implementation("io.github.microutils:kotlin-logging-jvm:$kotlinLoggingVersion")

        // mongoDB
        implementation("org.springframework.boot:spring-boot-starter-data-mongodb")

        // Test
        testImplementation("org.springframework.boot:spring-boot-starter-test")
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "1.8"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
