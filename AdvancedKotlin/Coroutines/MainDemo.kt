package AdvancedKotlin.Coroutines

import kotlinx.coroutines.*

// Main class to orchestrate coroutine demos
class MainDemo {
    /*
     * Coroutines Context:
     * - Combines all coroutine concepts in a task management scenario, orchestrating demos.
     * - Uses `runBlocking` for console app simplicity (not used in Android, where `viewModelScope`
     *   or `lifecycleScope` is preferred for lifecycle-aware scopes).
     * - Java Equivalent: A main method with `ExecutorService` and futures, but less structured and
     *   harder to manage.
     * - From Your Knowledge: Leverages OOP (class structure) and functional programming
     *   (declarative coroutine blocks).
     * - Android Relevance: Simulates a ViewModel coordinating async tasks for a UI.
     */
    
    fun demonstrateAll() {
        println("=== Coroutine Demo ===")
        
        // Create instances of demo classes
        val suspendDemo = SuspendDemo()
        val scopeDispatcherDemo = ScopeDispatcherDemo()
        val asyncLaunchDemo = AsyncLaunchDemo()
        val structuredConcurrencyDemo = StructuredConcurrencyDemo()
        
        // Run demos sequentially
        suspendDemo.demonstrate()
        runBlocking {
            val task = suspendDemo.fetchTask(1)
            println("Fetched: $task")
            
            val processedTask = scopeDispatcherDemo.processTask(task)
            println("Processed: $processedTask")
        }
        
        asyncLaunchDemo.demonstrate()
        structuredConcurrencyDemo.demonstrate()
    }
}

// Main function to run the demo
fun main() {
    /*
     * Coroutines Context:
     * - Entry point for the console app, running all coroutine demos.
     * - Java Equivalent: `public static void main(String[] args)`.
     * - From Your Knowledge: Standard entry point for console apps.
     */
    MainDemo().demonstrateAll()
}