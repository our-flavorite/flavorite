dependencies {

    implementation(project(":infrastructure:api"))
    implementation(project(":infrastructure:database"))
    implementation(project(":infrastructure:clients"))

    implementation("org.springframework.boot:spring-boot-starter")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
}

tasks.named("jar") {
    enabled = false
}
