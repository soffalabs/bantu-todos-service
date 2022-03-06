buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
        maven {
            setUrl("https://plugins.gradle.org/m2/")
        }
    }
    dependencies {
        classpath("dev.soffa.foundation:foundation-gradle-plugin:1.0.1")
    }
}


subprojects {
    repositories {
        apply(plugin = "foundation.default-repositories")
    }
}
