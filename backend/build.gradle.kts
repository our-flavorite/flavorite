import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

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

// bootstrap 모듈을 Bean으로 등록하기 위해 Top-level에서 따로 제어
project(":bootstrap") {
    dependencies {
        implementation(project(":infrastructure:api"))
        implementation(project(":infrastructure:database"))
        implementation(project(":infrastructure:clients"))
    }

    tasks.bootJar { enabled = true }
    tasks.jar { enabled = false }
}

// 하위 모듈을 그룹핑하는 모듈의 빌드 파일 생성을 제거하기 위해 Top-levet 에서 따로 제어
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

