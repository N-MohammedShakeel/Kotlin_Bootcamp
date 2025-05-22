package AdvancedKotlin.Delegates

// Data class for a task, leveraging your OOP knowledge
data class Task(val id: Int, var title: String, var priority: Int) {
    /*
     * Delegates Context:
     * - Models tasks for delegate demos, with mutable properties for `observable` and `vetoable`.
     * - Java Equivalent: A POJO with fields and manual getters/setters.
     * - From Your Knowledge: Data classes for immutability (with mutable fields for demo).
     * - Android Relevance: Represents to-do items in a ViewModel or Room database.
     */
}
