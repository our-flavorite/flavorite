plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "backend"
include("bootstrap")

include("infrastructure:database")
include("infrastructure:clients")

include("application:common")

include("presentation:api")
include("presentation:security")

include("global")
