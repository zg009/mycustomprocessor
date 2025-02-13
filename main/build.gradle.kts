plugins {
    kotlin("jvm")
    id("com.google.devtools.ksp")
    application
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(19)) // Replace with desired Java version
    }
}

kotlin {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_19) // Should match Java version
    }
}

group = "org.aesirlab"
val version: String by project

dependencies {
    implementation(project(":mycustomannotation"))
    ksp(project(":MyAnnotationProcessor"))
}

repositories {
    mavenCentral()
}