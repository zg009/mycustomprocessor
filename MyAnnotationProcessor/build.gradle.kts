plugins {
    kotlin("jvm")
}

group = "org.aesirlab"
version = "0.1.5"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("com.squareup:kotlinpoet:1.14.0")
    implementation("com.squareup:kotlinpoet-ksp:1.12.0")
    implementation("com.google.devtools.ksp:symbol-processing-api:2.0.0-1.0.21")
}

sourceSets.main {
    java.srcDirs("src/main/kotlin")
}