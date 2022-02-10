import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.6.3"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("io.kotest") version "0.3.9"
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.spring") version "1.6.10"
    kotlin("plugin.jpa") version "1.6.10"
    kotlin("kapt") version "1.6.10"
}

java.sourceCompatibility = JavaVersion.VERSION_11

allprojects {
    group = "com.uju"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

subprojects {

    apply(plugin = "kotlin")
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.kapt")
    apply(plugin = "io.kotest")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "kotlin-spring")


    dependencies {
        implementation(kotlin("stdlib"))
        implementation("org.springframework.boot:spring-boot-starter-data-jpa")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        implementation("com.querydsl:querydsl-jpa:5.0.0")
        implementation("org.springframework.boot:spring-boot-starter-validation")

        kapt("com.querydsl:querydsl-apt:5.0.0:jpa")

        runtimeOnly("com.h2database:h2")

        testImplementation("org.springframework.boot:spring-boot-starter-test") {
            exclude(module = "assertj-core")
            exclude(module = "hamcrest")
            exclude(module = "junit-jupiter")
            exclude(module = "mockito-core")
            exclude(module = "mockito-junit-jupiter")
            exclude(module = "jsonassert")
        }
        testImplementation("io.kotest.extensions:kotest-extensions-spring:1.1.0")
        testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.0")
        testImplementation("io.kotest:kotest-runner-junit5:5.1.0")
        testImplementation("io.kotest:kotest-assertions-core:5.1.0")
    }
}