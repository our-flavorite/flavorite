plugins {
    kotlin("plugin.spring") version "1.9.21"
    kotlin("jvm") version "1.9.21"
}

dependencies {
    implementation(project(":domain:user"))
    implementation(project(":global"))

    implementation("org.springframework.boot:spring-boot-starter")
}

tasks.bootJar { enabled = false }
