plugins {
    id("soffa.kotlin")
    id("soffa.springboot")
    id("com.google.cloud.tools.jib").version("3.2.0")
}

dependencies {
    implementation(project(":bantu-todos-core"))

    implementation("io.soffa.foundation:soffa-foundation-service:${property("fnd.version")}")
    implementation("io.soffa.foundation:soffa-foundation-support-data:${property("fnd.version")}")
    implementation("io.soffa.foundation:soffa-foundation-support-pubsub:${property("fnd.version")}")
    testImplementation("io.soffa.foundation:soffa-foundation-service-test:${property("fnd.version")}")
}
