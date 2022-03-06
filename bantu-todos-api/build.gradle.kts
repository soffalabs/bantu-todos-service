plugins {
    id("foundation.kotlin")
    id("foundation.test.junit5")
    //id("soffa.maven-publish")
}

dependencies {
    api("io.soffa.foundation:foundation-api:${property("foundation.version")}")
}
