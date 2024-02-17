plugins {
    kotlin("jvm") version "1.9.21"
    kotlin("plugin.spring") version "1.9.21"
}

dependencies {
    implementation(project(":application:common"))
    implementation(project(":global"))

}

tasks.bootJar { enabled = false }
