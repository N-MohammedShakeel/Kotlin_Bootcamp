package Kotlin.AdvancedKotlin.FunctionalProgramming

// Data class for a task, leveraging your OOP knowledge
data class Task(val id: Int, val title: String, val priority: Int, val isCompleted: Boolean = false) {
    /*
     * Data Class Context:
     * - Used for modeling tasks, providing `toString`, `equals`, `hashCode` (from your data classes knowledge).
     * - Java Equivalent: A POJO with fields, getters, setters, and manual method implementations.
     * - Functional Programming Note: Data classes support immutability (e.g., using `val`), a key functional concept.
     */
    
    companion object {
        // Factory method, like Java’s `public static Task create(...)`
        fun create(id: Int, title: String, priority: Int): Task {
            return Task(id, title, priority)
        }
    }
}