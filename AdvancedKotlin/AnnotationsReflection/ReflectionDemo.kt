package AdvancedKotlin.AnnotationsReflection

import kotlin.reflect.KClass
import kotlin.reflect.KProperty
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.functions
import kotlin.reflect.full.memberProperties

// Class to demonstrate reflection with KClass, KProperty
class ReflectionDemo {
    /*
     * Reflection: Inspecting Classes, Properties, and Methods
     * - Definition: Reflection inspects code structure (classes, properties, methods) at runtime using KClass, KProperty, etc.
     * - Why Important? Enables dynamic behavior, such as reading annotations or accessing properties.
     * - Java Equivalent: Java reflection (Class, Field), but Kotlin’s API is type-safe.
     * - Use Case: Dynamically validating annotated properties in a ViewModel.
     * - From Your Knowledge: Builds on generics (KClass<T>) and functional programming (lambdas).
     * - Dependency: Requires `kotlin-reflect` (org.jetbrains.kotlin:kotlin-reflect:1.9.23) in build.gradle.kts.
     */

    fun demonstrate() {
        println("\n=== Reflection Demo ===")

        // Get KClass for Task
        val taskClass: KClass<Task> = Task::class
        println("Class: ${taskClass.simpleName}")

        // Inspect class annotations
        val classAnnotation = taskClass.findAnnotation<TaskInfo>()
        println("Class Annotation: description=${classAnnotation?.description}, priority=${classAnnotation?.priority}")

        // Create a Task instance
        val task = Task(1, "Write code", 1)

        // Inspect properties using reflection with error handling
        taskClass.memberProperties.forEach { property: KProperty<*> ->
            val annotation = property.findAnnotation<TaskInfo>()
            try {
                val value = property.getter.call(task)
                println("Property: ${property.name}, Value: $value, Annotation: description=${annotation?.description}, priority=${annotation?.priority}")
            } catch (e: Exception) {
                println("Error accessing property ${property.name}: ${e.message}")
            }
        }

        // Inspect functions
        taskClass.functions.forEach { function ->
            println("Function: ${function.name}, Parameters: ${function.parameters.map { it.name ?: "unnamed" }}")
        }
    }
}