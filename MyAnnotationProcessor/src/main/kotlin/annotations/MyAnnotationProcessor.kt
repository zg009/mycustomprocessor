package org.aesirlab.annotations

import com.google.devtools.ksp.processing.*
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import java.io.OutputStreamWriter
import java.nio.charset.StandardCharsets

class MyAnnotationProcessor(private val codeGenerator: CodeGenerator, private  val logger: KSPLogger): SymbolProcessor {
    override fun process(resolver: Resolver): List<KSAnnotated> {
        resolver
            .getSymbolsWithAnnotation(MyAnnotation::class.qualifiedName.toString())
            .filterIsInstance<KSClassDeclaration>()
            // Keeping this logging to make it possible to observe incremental build
            .also { logger.warn("Generating for ${it.joinToString { it.simpleName.getShortName() }}") }
            .forEach(::generateHello)

        return emptyList()
    }

    private fun generateHello(annotatedClass: KSClassDeclaration) {
        val packageName = annotatedClass.packageName.getQualifier()

        val helloFun = FunSpec.builder("hello")
            .addStatement("println(\"Hello!\")")
            .build()
        val fileSpec = FileSpec.builder(ClassName(packageName, "HelloFile"))
            .addFunction(helloFun)
            .build()
        val dependencies = Dependencies(aggregating = false, annotatedClass.containingFile!!)
        val storeFile = codeGenerator.createNewFile(dependencies, packageName,
            "AnnotatedHello"
        )
        OutputStreamWriter(storeFile, StandardCharsets.UTF_8)
            .use(fileSpec::writeTo)
    }
}