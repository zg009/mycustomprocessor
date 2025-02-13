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
    // dependency on Flow
    // this is needed as the scopes for the annotation processor
    // are independent of the dependencies used by the annotation
    // processor itself
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation(project(":mycustomannotation"))
    ksp(project(":MyAnnotationProcessor"))
    // imported rdf libs
    // these need to be imported as the .jar files, added to a library folder
    // and each need to be individually imported as a jar-based library
    // to be discovered by the project
    implementation(fileTree(mapOf("dir" to "lib", "include" to listOf("*.jar"))))
}

repositories {
    mavenCentral()
}