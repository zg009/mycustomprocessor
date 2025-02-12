plugins {
    kotlin("jvm")
    id("com.google.devtools.ksp")
    application
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