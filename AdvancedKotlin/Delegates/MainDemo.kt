package AdvancedKotlin.Delegates

import AdvancedKotlin.Delegates.CustomDelegateDemo
import kotlin.properties.Delegates

// Main class to orchestrate delegates demos
class MainDemo {
    /*
     * Delegates Context:
     * - Combines all delegate concepts in a task management scenario.
     * - Java Equivalent: A main class using manual delegation and property patterns.
     * - From Your Knowledge: Leverages OOP (classes) and functional programming (lambdas).
     * - Android Relevance: Simulates ViewModel property management.
     */
    
    fun demonstrateAll() {
        println("=== Delegates Demo ===")
        DelegationDemo().demonstrate()
        StandardDelegatesDemo().demonstrate()
        CustomDelegateDemo().demonstrate()
    }
}

// Main function to run the demo
fun main() {
    /*
     * Delegates Context:
     * - Entry point for the console app, running all delegates demos.
     * - Java Equivalent: `public static void main(String[] args)`.
     */
    MainDemo().demonstrateAll()
}