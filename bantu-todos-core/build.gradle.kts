plugins {
    id("foundation.kotlin")
    id("foundation.test.junit5")
}

dependencies {
    api(project(":bantu-todos-api"))
    api("dev.soffa.foundation:foundation-core:${property("f4j.version")}")
}
