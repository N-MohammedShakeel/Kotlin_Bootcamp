package AdvancedKotlin.AnnotationsReflection

import kotlin.reflect.KClass
import kotlin.reflect.KProperty
import kotlin.reflect.full.*

// Main class to orchestrate annotations and reflection demos
class MainDemo {
    /*
     * Annotations and Reflection Context:
     * - Combines annotation creation and reflection inspection in a task management scenario.
     * - Java Equivalent: A main class using Java annotations and reflection.
     * - From Your Knowledge: Leverages OOP (classes) and functional programming (lambdas).
     * - Android Relevance: Simulates inspecting ViewModel properties.
     */

    fun demonstrateAll() {
        println("=== Annotations and Reflection Demo ===")
        AnnotationDemo().demonstrate()
        ReflectionDemo().demonstrate()
    }
}

// Main function to run the demo
fun main() {
    /*
     * Annotations and Reflection Context:
     * - Entry point for the console app, running all demos.
     * - Java Equivalent: `public static void main(String[] args)`.
     * - Dependency: Ensure `kotlin-reflect` is in build.gradle.kts.
     */
    MainDemo().demonstrateAll()
}