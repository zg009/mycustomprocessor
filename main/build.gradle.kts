plugins {
    kotlin("jvm")
    id("com.google.devtools.ksp")
}

group = "org.aesirlab"
version = "0.1.5"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(project(":MyAnnotationProcessor"))
    ksp(project(":MyAnnotationProcessor"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(19)
}