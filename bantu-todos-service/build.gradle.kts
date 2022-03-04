plugins {
    id("foundation.kotlin")
    id("foundation.springboot")
}

dependencies {
    implementation(project(":bantu-todos-core"))

    implementation("io.soffa.foundation:foundation-service:${property("fnd.version")}")
    implementation("io.soffa.foundation:foundation-support-data:${property("fnd.version")}")
    implementation("io.soffa.foundation:foundation-support-pubsub:${property("fnd.version")}")
    implementation("io.soffa.foundation:foundation-support-tracing:${property("fnd.version")}")
    testImplementation("io.soffa.foundation:foundation-service-test:${property("fnd.version")}")
}
