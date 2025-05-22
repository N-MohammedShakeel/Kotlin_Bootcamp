package AdvancedKotlin.Coroutines

// Class to demonstrate asynchronous programming and suspend functions
class SuspendDemo {
    /*
     * Coroutines: Asynchronous Programming
     * - Definition: Coroutines enable non-blocking asynchronous tasks (e.g., API calls, database queries)
     *   by writing sequential-looking code, avoiding callback hell or thread management.
     * - Why Important? Simplifies async operations in Android, ensuring the UI remains responsive
     *   (e.g., fetching data without freezing the app).
     * - Java Equivalent: `Thread`, `ExecutorService`, or `CompletableFuture`, but these are verbose
     *   and prone to complexity (e.g., nested callbacks or thread pooling issues).
     * - Use Case: Fetching user data from an API in a ViewModel to display in a Jetpack Compose UI.
     * - From Your Knowledge: Complements functional programming (declarative style) and collections
     *   (e.g., processing async data like lists).
     * 
     * Coroutines: Suspend Functions
     * - Definition: Functions marked `suspend` pause and resume execution, used for async operations
     *   within coroutines. They can only be called from other suspend functions or coroutine scopes.
     * - Why Important? Allows writing async code in a sequential style, improving readability and
     *   reducing errors compared to callbacks.
     * - Java Equivalent: Callbacks (e.g., `onSuccess(result)`) or `Future.get()`, but `suspend`
     *   functions are more integrated and avoid callback nesting.
     * - Use Case: Delaying a task fetch or calling an async API (e.g., Retrofit) in Android.
     * - From Your Knowledge: Builds on lambdas (from functional programming) used in coroutine blocks.
     */
    
    suspend fun fetchTask(id: Int): Task {
        /*
         * Coroutines Context:
         * - Simulates an async network call using `delay`, a suspend function that pauses without
         *   blocking the thread (non-blocking).
         * - Returns a `Task` after a 1-second delay, mimicking real-world async behavior (e.g., HTTP request).
         * - Java Equivalent: `Thread.sleep(1000)` (blocks the thread) or
         *   `CompletableFuture.supplyAsync(() -> {...}).get()`, which is more complex.
         * - Android Relevance: Fetching a to-do item from a server for display in a RecyclerView.
         */
        delay(1000) // Simulate async delay (1 second)
        return Task.create(id, "Task $id", id)
    }
    
    fun demonstrate() {
        /*
         * Coroutines Context:
         * - Placeholder for running suspend functions within a coroutine scope (see MainDemo).
         * - Java Equivalent: A method invoking `Future.get()` or a callback handler.
         */
        println("=== Suspend Function Demo ===")
        // Run in a coroutine scope (see MainDemo)
    }
}