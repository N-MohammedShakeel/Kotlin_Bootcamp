package AdvancedKotlin.Coroutines

// Class to demonstrate structured concurrency and cancellation
class StructuredConcurrencyDemo {
    /*
     * Coroutines: Structured Concurrency
     * - Definition: Ensures child coroutines (started within a scope) complete or cancel when their
     *   parent scope completes or is cancelled, preventing runaway tasks.
     * - Why Important? Guarantees resource cleanup in Android, avoiding memory leaks (e.g., coroutines
     *   running after a screen is closed).
     * - Java Equivalent: No direct equivalent; `ExecutorService.shutdown()` or `Future.cancel()` are
     *   less structured and require manual management.
     * - Use Case: Ensuring all data fetches complete or cancel when a Fragment is destroyed.
     * - From Your Knowledge: Aligns with resource management patterns (e.g., try-with-resources in Java).
     * 
     * Coroutines: Cancellation
     * - Definition: Coroutines can be cancelled via `Job.cancel()`, stopping execution gracefully.
     *   Cancellation is cooperative, meaning coroutines must check for it (e.g., `delay` and other
     *   coroutine functions are cancellation-aware).
     * - Why Important? Allows stopping unnecessary tasks, improving app responsiveness and resource use.
     * - Java Equivalent: `Thread.interrupt()` or `Future.cancel()`, but these are less reliable and
     *   harder to coordinate.
     * - Use Case: Cancelling a network request when a user navigates away from a screen in Android.
     * - From Your Knowledge: Relates to exception handling and lifecycle management.
     */
    
    suspend fun fetchWithTimeout(): Task? {
        /*
         * Coroutines Context:
         * - Uses `withTimeout` to enforce a 500ms time limit, demonstrating automatic cancellation.
         * - If the task exceeds 500ms (1-second delay), a `TimeoutCancellationException` is thrown.
         * - Catches the exception to return `null`, showing error handling.
         * - Java Equivalent: `Future.get(500, TimeUnit.MILLISECONDS)` with try-catch, but less integrated.
         * - Android Relevance: Timing out a slow API call to show an error message.
         */
        return try {
            withTimeout(500) {
                delay(1000) // Simulate long operation
                Task.create(1, "Timed Task", 1)
            }
        } catch (e: TimeoutCancellationException) {
            println("Operation timed out")
            null
        }
    }
    
    suspend fun demonstrateCancellation(scope: CoroutineScope) {
        /*
         * Coroutines Context:
         * - Launches a coroutine with a 2-second task and cancels it after 1 second.
         * - The `Job` is cancelled using `cancel()`, stopping the task cooperatively.
         * - Demonstrates structured concurrency: Cancellation propagates to child coroutines.
         * - Java Equivalent: `Future.cancel(true)` or `Thread.interrupt()`, but less predictable.
         * - Android Relevance: Cancelling a data fetch when a user exits a Fragment.
         */
        val job = scope.launch {
            println("Starting long task...")
            delay(2000) // Long-running task
            println("Completed long task")
        }
        delay(1000)
        job.cancel()
        println("Cancelled task")
    }
    
    fun demonstrate() {
        /*
         * Coroutines Context:
         * - Runs cancellation demo within a coroutine scope.
         * - Uses `runBlocking` for console app simplicity.
         */
        println("=== Structured Concurrency and Cancellation Demo ===")
        runBlocking {
            val timedTask = fetchWithTimeout()
            println("Timed task: $timedTask")
            demonstrateCancellation(this)
            delay(1000) // Wait for cancellation
        }
    }
}