package AdvancedKotlin.Coroutines

// Class to demonstrate CoroutineScope and Dispatchers
class ScopeDispatcherDemo {
    /*
     * Coroutines: CoroutineScope
     * - Definition: A `CoroutineScope` defines the lifecycle of coroutines, managing their execution,
     *   cancellation, and completion. All coroutines must run within a scope to ensure proper cleanup.
     * - Why Important? Prevents coroutine leaks (e.g., running tasks after a screen is closed) in Android,
     *   ensuring resources are released when the scope ends.
     * - Java Equivalent: No direct equivalent; `ExecutorService` manages threads but lacks lifecycle
     *   control, requiring manual shutdown.
     * - Use Case: Creating a scope in a ViewModel (e.g., `viewModelScope`) to manage coroutines for
     *   data fetching or UI updates.
     * - From Your Knowledge: Aligns with OOP (managing object lifecycles) and design patterns (e.g., RAII).
     * 
     * Coroutines: Dispatchers
     * - Definition: `Dispatchers` specify the thread pool where coroutines execute:
     *   - `Dispatchers.Main`: For UI updates (Android main thread, not used in console apps).
     *   - `Dispatchers.IO`: For I/O operations (e.g., network, database).
     *   - `Dispatchers.Default`: For CPU-intensive tasks (e.g., sorting, parsing).
     * - Why Important? Ensures tasks run on appropriate threads, critical for Android performance
     *   (e.g., avoiding UI thread blocking).
     * - Java Equivalent: `ExecutorService` with custom thread pools (e.g., `Executors.newFixedThreadPool()`),
     *   but Dispatchers are tightly integrated with coroutines.
     * - Use Case: Running database queries on `Dispatchers.IO` and updating a Compose UI on `Dispatchers.Main`.
     * - From Your Knowledge: Relates to threading concepts from Java.
     */
    
    suspend fun processTask(task: Task): Task {
        /*
         * Coroutines Context:
         * - Uses `Dispatchers.IO` to simulate an I/O-bound task (e.g., writing to a database).
         * - Updates the task’s priority after a 500ms delay, demonstrating thread switching.
         * - Prints the thread name to show execution on a worker thread.
         * - Java Equivalent: `Executors.newCachedThreadPool().submit(() -> {...})`, but requires
         *   manual thread management.
         * - Android Relevance: Saving a task to Room database on `Dispatchers.IO`.
         */
        withContext(Dispatchers.IO) {
            delay(500) // Simulate I/O delay
            println("Processed ${task.title} on ${Thread.currentThread().name}")
        }
        return task.copy(priority = task.priority + 1) // Immutable update using data class `copy`
    }
    
    fun demonstrate() {
        /*
         * Coroutines Context:
         * - Placeholder for running suspend functions within a coroutine scope (see MainDemo).
         * - Java Equivalent: A method submitting tasks to an `ExecutorService`.
         */
        println("=== Scope and Dispatcher Demo ===")
        // Run in a coroutine scope (see MainDemo)
    }
}