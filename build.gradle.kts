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

group = "org.zg009"
version = "0.1.1"
val projectName = "mycustomprocessor"
val domain = "zg009/$projectName"

configure<PublishingExtension> {
    repositories {
        maven {
            version = version
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/$domain")
            credentials {
                username = "zg009"
                password = project.findProperty("gpr.key") as String? ?: System.getProperty("TOKEN")
            }
        }
    }
    publications {
        register<MavenPublication>("gpr") {
            groupId= group.toString()
            artifactId="test-annotation-processor"
            artifact("MyAnnotationProcessor/build/libs/MyAnnotationProcessor-$version.jar")
        }
    }
}