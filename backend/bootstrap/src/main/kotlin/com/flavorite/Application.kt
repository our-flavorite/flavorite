package com.flavorite

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.flavorite"])
class Application

fun main(args: Array<String>) {

    runApplication<Application>(*args)

}