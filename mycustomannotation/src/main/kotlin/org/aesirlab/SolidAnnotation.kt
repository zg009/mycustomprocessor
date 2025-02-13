package org.aesirlab

@Target(AnnotationTarget.CLASS)
annotation class SolidAnnotation(val name: String, val absoluteUri: String, val uriShortName: String)
