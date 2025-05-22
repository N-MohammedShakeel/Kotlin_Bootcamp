package AdvancedKotlin.AnnotationsReflection

// Class to demonstrate creating and using annotations
class AnnotationDemo {
    /*
     * Annotations: Creating and Using Annotations
     * - Definition: Annotations add metadata to code elements, processed at compile-time or runtime.
     * - Why Important? Enables configuration, validation, or marking for frameworks (e.g., Android’s Room).
     * - Java Equivalent: Java annotations (e.g., @Override), but Kotlin supports flexible targets.
     * - Use Case: Marking ViewModel properties for serialization or validation.
     * - From Your Knowledge: Relates to metadata in design patterns and Java annotations.
     */

    fun demonstrate() {
        println("=== Annotation Demo ===")
        val task = Task(1, "Write code", 1)
        println("Created task: $task")
        // Note: Annotation processing is shown in ReflectionDemo
    }
}