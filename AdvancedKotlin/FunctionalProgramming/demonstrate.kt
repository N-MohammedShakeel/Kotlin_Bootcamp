package Kotlin.AdvancedKotlin.FunctionalProgramming
// This file demonstrates Kotlin's Functional Programming concepts (higher-order functions, lambdas,
// scope functions, inline functions) in IntelliJ IDEA, with Java comparisons and detailed explanations.

// Demonstration function to showcase all concepts
fun demonstrate() {
    /*
     * Functional Programming Context:
     * - Demonstrates functional concepts in a task management scenario.
     * - Why Functional? Emphasizes immutability, declarative operations, and concise null handling.
     * - Java Equivalent: A console app using Stream API and verbose null checks.
     */
    println("=== Functional Programming Demo ===")
    
    val manager = TaskManager()
    
    // Add tasks using apply
    manager.addTask("Write code", 3)
    manager.addTask("Test app", 2)
    manager.addTask("Deploy", 1)
    
    // Higher-order function: Transform tasks
    println("\n=== Higher-Order Function ===")
    val taskDescriptions = manager.processTasks { task ->
        /*
         * Lambda:
         * - A concise function passed to `processTasks`.
         * - Why Functional? Avoids explicit loops, focuses on transformation logic.
         * - Java Equivalent: `task -> "Task " + task.getId() + "..."`.
         */
        "Task ${task.id}: ${task.title} (Priority: ${task.priority})"
    }
    taskDescriptions.forEach { println(it) }
    
    // Inline function: Log high-priority tasks
    println("\n=== Inline Function ===")
    manager.logTasks { it.priority > 1 }
    
    // Scope functions: Process nullable task
    println("\n=== Scope Functions (let, run) ===")
    manager.processNullableTask(1) // Found
    manager.processNullableTask(999) // Not found
    
    // Scope functions: Update task with also and with
    println("\n=== Scope Functions (also, with) ===")
    manager.updateTask(2, "Test app updated")
    manager.processTasks { it.title }.forEach { println("Updated task: $it") }
}

// Main function to run the demo
fun main() {
    /*
     * Main Function:
     * - Entry point for the console app.
     * - Java Equivalent: `public static void main(String[] args)`.
     */
    demonstrate()
}