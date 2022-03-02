buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
        maven {
            setUrl("https://plugins.gradle.org/m2/")
        }
    }
    dependencies {
        classpath("io.soffa.foundation:foundation-gradle-plugin:1.0.1")
    }
}

apply(plugin = "foundation.sonatype-legacy-publish")


subprojects {
    repositories {
        mavenLocal()
        mavenCentral()
    }
}
