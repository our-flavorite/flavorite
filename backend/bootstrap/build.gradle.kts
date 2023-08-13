dependencies {

    implementation(project(":presentation"))
    implementation(project(":application:common"))
    implementation(project(":infrastructure:database"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
}

tasks.named("jar") {
    enabled = false
}
