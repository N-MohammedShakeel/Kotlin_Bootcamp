package AdvancedKotlin.Coroutines

// Class to demonstrate async, await, and launch (your provided class, fixed)
class AsyncLaunchDemo {
    /*
     * Coroutines: async and await
     * - Definition: `async` starts a coroutine that returns a `Deferred<T>`, a future-like object
     *   holding a result. `await` suspends until the result is available, retrieving it.
     * - Why Important? Enables concurrent execution of multiple tasks (e.g., parallel API calls),
     *   reducing total execution time compared to sequential calls.
     * - Java Equivalent: `CompletableFuture.supplyAsync(() -> {...}).thenApply(...)`, but `async` and
     *   `await` are simpler and more integrated with coroutines.
     * - Use Case: Fetching multiple API endpoints concurrently in Android (e.g., user profile and posts).
     * - From Your Knowledge: Builds on functional programming (lambdas in `async` blocks).
     * 
     * Coroutines: launch
     * - Definition: `launch` starts a coroutine for fire-and-forget tasks, returning a `Job` object
     *   (no result). Used when the task’s outcome isn’t needed.
     * - Why Important? Ideal for tasks like logging, analytics, or UI updates that don’t return values.
     * - Java Equivalent: `ExecutorService.submit(() -> {...})`, but `launch` integrates with coroutine
     *   scopes for better lifecycle management.
     * - Use Case: Triggering a UI update or logging an event in Android without waiting for completion.
     * - From Your Knowledge: Similar to fire-and-forget patterns in event-driven systems.
     */
    
    suspend fun fetchTasksConcurrently(): List<Task> {
        /*
         * Coroutines Context:
         * - Uses `async` to fetch two tasks concurrently, each with a 1-second delay.
         * - `await` collects results, suspending until both tasks complete, combining them into a list.
         * - Demonstrates concurrency: Total time is ~1 second (parallel) vs. 2 seconds (sequential).
         * - Java Equivalent: `CompletableFuture.allOf(future1, future2).thenApply(...)`, requiring
         *   more boilerplate.
         * - Android Relevance: Fetching user and settings data simultaneously for a dashboard screen.
         * - Fix: `async` is called within a suspend function, which is valid, but must be run in a scope.
         */
        val deferred1 = async {
            delay(1000) // Simulate async fetch
            Task.create(1, "Task 1", 1)
        }
        val deferred2 = async {
            delay(1000)
            Task.create(2, "Task 2", 2)
        }
        return listOf(deferred1.await(), deferred2.await())
    }
    
    suspend fun launchTaskUpdate(task: Task) {
        /*
         * Coroutines Context:
         * - Uses `launch` for a fire-and-forget task that updates a task (simulated with delay).
         * - Prints progress to show the task running independently.
         * - Returns a `Job` (not used here) for potential cancellation.
         * - Java Equivalent: `Executors.newSingleThreadExecutor().execute(() -> {...})`, but lacks
         *   coroutine scope integration.
         * - Android Relevance: Updating a UI element (e.g., showing a toast) without needing a result.
         * - Fix: `launch` is called within a suspend function, valid when run in a scope.
         */
        launch {
            println("Updating ${task.title}...")
            delay(500)
            println("Updated ${task.title}")
        }
    }
    
    fun demonstrate() {
        /*
         * Coroutines Context:
         * - Runs `fetchTasksConcurrently` and `launchTaskUpdate` in a coroutine scope to fix `async` error.
         * - Uses `runBlocking` for console app simplicity, ensuring scope availability.
         * - Java Equivalent: A method invoking `ExecutorService.submit` or `CompletableFuture`.
         * - Android Note: In Android, use `viewModelScope` or `lifecycleScope` instead of `runBlocking`.
         */
        println("=== Async and Launch Demo ===")
        runBlocking {
            val tasks = fetchTasksConcurrently()
            println("Fetched concurrently: $tasks")
            launchTaskUpdate(Task.create(1, "Task 1", 1))
            delay(1000) // Wait for launch to complete
        }
    }
}