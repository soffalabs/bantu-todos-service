plugins {
    id("foundation.kotlin")
    id("foundation.test.junit5")
}

dependencies {
    api(project(":bantu-todos-api"))
    api("dev.bantu.api:bantu-accounts-api:${property("accounts.version")}")
    api("io.soffa.foundation:foundation-application:${property("fnd.version")}")
}
