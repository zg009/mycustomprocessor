plugins {
    kotlin("jvm")
}
val version: String by project
val kspVersion: String by project
dependencies {
    implementation(project(":mycustomannotation"))
    implementation("com.squareup:kotlinpoet:1.14.0")
    implementation("com.squareup:kotlinpoet-ksp:1.12.0")
    implementation("com.google.devtools.ksp:symbol-processing-api:$kspVersion")
}

repositories {
    mavenCentral()
    google()
}

