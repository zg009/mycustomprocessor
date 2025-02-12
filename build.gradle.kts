plugins {
    kotlin("jvm") version "2.0.0" apply false
}

repositories {
    mavenCentral()
}

buildscript {
    dependencies {
        classpath(kotlin("gradle-plugin", version = "2.0.0"))
    }
}

apply {
    plugin("maven-publish")
}

val group: String by project
val version: String by project


configure<PublishingExtension> {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/zg009/mycustomprocessor")
            credentials {
                username = "zg009"
                password = project.findProperty("gpr.key") as String? ?: System.getProperty("TOKEN")
            }
        }
    }
    publications {
        register<MavenPublication>("gpr") {
            groupId = group.toString()
            artifactId = "aesir-test-processor"
            artifact("MyAnnotationProcessor/build/libs/MyAnnotationProcessor-$version.jar")
        }
        register<MavenPublication>("gpr-processor") {
            groupId = group.toString()
            artifactId="aesir-test-annotation"
            artifact("mycustomannotation/build/libs/mycustomannotation-$version.jar")
        }
    }
}