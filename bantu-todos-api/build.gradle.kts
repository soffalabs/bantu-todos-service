plugins {
    id("foundation.kotlin")
    id("foundation.test.junit5")
    //id("soffa.maven-publish")
}

dependencies {
    api("dev.bantu:bantu-accounts-api:${property("accounts.version")}")
    api("dev.soffa.foundation:foundation-api:${property("f4j.version")}")
}
