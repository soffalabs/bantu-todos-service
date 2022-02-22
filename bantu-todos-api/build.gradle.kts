plugins {
    id("soffa.kotlin")
    id("soffa.test.junit5")
    //id("soffa.maven-publish")
}

dependencies {
    api("io.soffa.foundation:soffa-foundation-api:${property("fnd.version")}")
}
