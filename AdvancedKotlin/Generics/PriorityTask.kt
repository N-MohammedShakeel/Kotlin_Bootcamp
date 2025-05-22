package AdvancedKotlin.Generics

// Data class for a priority task
data class PriorityTask(override val id: Int, override val title: String, val priority: Int) : Task {
    /*
     * Generics Context:
     * - Extends `Task` with additional properties, used in variance demos.
     * - Java Equivalent: A POJO with additional fields.
     */
}