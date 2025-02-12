pluginManagement {
    val kotlinVersion: String by settings
    val kspVersion: String by settings
    plugins {
        kotlin("jvm") version "2.0.0"
        id("com.google.devtools.ksp") version "2.0.0-1.0.21"
    }
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "MyCustomProcessor"
include(":MyAnnotationProcessor")
include(":main")
include(":mycustomannotation")
