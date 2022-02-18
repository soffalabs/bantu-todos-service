plugins {
    id("soffa.kotlin")
    id("soffa.springboot")
    id("com.google.cloud.tools.jib").version("3.2.0")
}

dependencies {
    implementation(project(":bantu-todos-core"))

    implementation("io.soffa.foundation:soffa-foundation-service:${property("foundation.version")}")
    implementation("io.soffa.foundation:soffa-foundation-support-pubsub:${property("foundation.version")}")
    testImplementation("io.soffa.foundation:soffa-foundation-service-test:${property("foundation.version")}")
}
