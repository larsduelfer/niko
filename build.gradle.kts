import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("org.springframework.boot") version "2.4.5"
  id("io.spring.dependency-management") version "1.0.11.RELEASE"
  kotlin("jvm") version "1.4.32"
  kotlin("plugin.spring") version "1.4.32"
}

group = "de.novatec"

version = "0.0.1-SNAPSHOT"

java.sourceCompatibility = JavaVersion.VERSION_11

repositories { mavenCentral() }

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-web")

  implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
  implementation("com.squareup.okhttp3:okhttp:4.9.1")
  implementation("com.slack.api:bolt:1.7.1")
  implementation("com.slack.api:bolt-jetty:1.7.1")
  implementation("com.slack.api:slack-api-model-kotlin-extension:1.7.1")
  implementation("com.slack.api:slack-api-client-kotlin-extension:1.7.1")

  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

  testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
  kotlinOptions {
    freeCompilerArgs = listOf("-Xjsr305=strict")
    jvmTarget = "11"
  }
}

tasks.withType<Test> { useJUnitPlatform() }
