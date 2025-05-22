package AdvancedKotlin.Generics

// Main class to orchestrate generics demos
class MainDemo {
    /*
     * Generics Context:
     * - Combines all generics concepts in a task management scenario.
     * - Java Equivalent: A main class using generic classes/interfaces.
     * - From Your Knowledge: Leverages OOP (classes) and functional programming (type-safe operations).
     * - Android Relevance: Simulates a generic data layer for a UI.
     */

    fun demonstrateAll() {
        println("=== Generics Demo ===")
        GenericDemo<BasicTask>().demonstrate()
        VarianceDemo().demonstrate()
        ReifiedTypeDemo().demonstrate()
    }
}

// Main function to run the demo
fun main() {
    /*
     * Generics Context:
     * - Entry point for the console app, running all generics demos.
     * - Java Equivalent: `public static void main(String[] args)`.
     */
    MainDemo().demonstrateAll()
}