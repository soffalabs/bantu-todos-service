plugins {
    id("soffa.kotlin")
    id("soffa.test.junit5")
}

dependencies {
    api(project(":bantu-todos-api"))
    api("dev.bantu.api:bantu-accounts-api:0.9.9")
    api("io.soffa.foundation:soffa-foundation-application:${property("fnd.version")}")
}
