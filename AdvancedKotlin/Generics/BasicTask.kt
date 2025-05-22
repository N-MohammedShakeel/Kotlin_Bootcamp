package AdvancedKotlin.Generics

// Data class for a basic task
data class BasicTask(override val id: Int, override val title: String) : Task {
    /*
     * Generics Context:
     * - Implements `Task` for use in generic demos.
     * - Java Equivalent: A POJO implementing `Task` with manual getters.
     * - From Your Knowledge: Data classes for immutability and encapsulation.
     */
}