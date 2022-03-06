plugins {
    id("foundation.kotlin")
    id("foundation.springboot")
    id("foundation.qa.coverage.l8")
}

dependencies {
    implementation(project(":bantu-todos-core"))

    implementation("io.soffa.foundation:foundation-service:${property("foundation.version")}")
    implementation("io.soffa.foundation:foundation-support-data:${property("foundation.version")}")
    implementation("io.soffa.foundation:foundation-support-pubsub:${property("foundation.version")}")
    implementation("io.soffa.foundation:foundation-support-tracing:${property("foundation.version")}")
    testImplementation("io.soffa.foundation:foundation-service-test:${property("foundation.version")}")
}
