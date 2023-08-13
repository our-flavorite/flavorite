rootProject.name = "backend"
include("bootstrap")
include("presentation")
include("core")
include("infrastructure:database")
project(":infrastructure:database").projectDir = file("infrastructure/database")
include("infrastructure:clients")
include("application:common")
project(":application:common").projectDir = file("application/common")
