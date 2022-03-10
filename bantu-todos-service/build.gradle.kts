plugins {
    id("foundation.kotlin")
    id("foundation.springboot")
    id("foundation.qa.coverage.l8")
}

dependencies {
    implementation(project(":bantu-todos-core"))
    implementation("net.bytebuddy:byte-buddy:1.12.8")

    implementation("dev.soffa.foundation:foundation-starter:${property("f4j.version")}")
    implementation("dev.soffa.foundation:foundation-starter-data:${property("f4j.version")}")
    implementation("dev.soffa.foundation:foundation-starter-pubsub:${property("f4j.version")}")
    // implementation("dev.soffa.foundation:foundation-service-tracing:${property("f4j.version")}")
    testImplementation("dev.soffa.foundation:foundation-starter-test:${property("f4j.version")}")
}


