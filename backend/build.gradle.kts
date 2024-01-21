import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("org.springframework.boot") version "3.2.1"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "1.9.21"
    kotlin("plugin.spring") version "1.9.21"
    kotlin("plugin.jpa") version "1.8.22"
}

allprojects {
    group = "com.flavorite"
    version = "1.0"

    apply(plugin = "java")

    java {
        sourceCompatibility = JavaVersion.VERSION_17
    }

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    dependencies {
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")

        testImplementation("org.springframework.boot:spring-boot-starter-test")
        annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs += "-Xjsr305=strict"
            jvmTarget = "17"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

// adapter 모듈을 Bean으로 등록하기 위해 Top-level에서 따로 제어
project(":bootstrap") {
    dependencies {
        implementation(project(":infrastructure:api"))
        implementation(project(":infrastructure:database"))
        implementation(project(":infrastructure:clients"))
    }

    tasks.bootJar { enabled = true }
    tasks.jar { enabled = false }
}

project(":application:common") {

    dependencies {
        implementation(project(":domain:user"))
        implementation(project(":global"))
    }

    tasks.bootJar { enabled = false }
}

project(":infrastructure:api") {

    dependencies {
        implementation(project(":application:common"))
        implementation(project(":global"))
    }

    tasks.bootJar { enabled = false }
}

project(":infrastructure:clients") {
    dependencies {
        implementation(project(":application:common"))
        implementation(project(":global"))
    }

    tasks.bootJar { enabled = false }
}

project(":infrastructure:database") {
    dependencies {
        implementation(project(":application:common"))
        implementation(project(":global"))
    }

    tasks.bootJar { enabled = false }
}

project(":domain:user") {
    tasks.bootJar { enabled = false }
}

project(":global") {
    tasks.bootJar { enabled = false }
}


project(":application") {
    tasks.bootJar { enabled = false }
    tasks.jar { enabled = false }
    tasks.resolveMainClassName { enabled = false }
}

project(":domain") {
    tasks.bootJar { enabled = false }
    tasks.jar { enabled = false }
    tasks.resolveMainClassName { enabled = false }
}

project(":infrastructure") {
    tasks.bootJar { enabled = false }
    tasks.jar { enabled = false }
    tasks.resolveMainClassName { enabled = false }
}

tasks.jar { enabled = false }
tasks.bootJar { enabled = false }
tasks.resolveMainClassName { enabled = false }

