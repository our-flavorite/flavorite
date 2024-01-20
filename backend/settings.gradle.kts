plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "backend"

include("bootstrap")

include("infrastructure:api")
include("infrastructure:database")
include("infrastructure:clients")

include("application:common")

include("domain:member")

include("global")
