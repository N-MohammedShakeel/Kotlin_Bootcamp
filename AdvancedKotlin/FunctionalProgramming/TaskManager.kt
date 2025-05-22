package Kotlin.AdvancedKotlin.FunctionalProgramming

// Class to demonstrate functional programming
open class TaskManager {
    /*
     * Class Context:
     * - Manages tasks using functional programming principles (immutability, declarative operations).
     * - Java Equivalent: A class with `List<Task>` using Stream API for functional operations.
     * - Functional Programming Note: Prefers immutable operations (e.g., `map`, `filter`) over mutable loops.
     */
    
    val tasks = mutableListOf<Task>()
    
    // Higher-order function: Applies a transformation to tasks
    fun processTasks(transform: (Task) -> String): List<String> {
        /*
         * Functional Programming: Higher-Order Function
         * - Definition: A function that takes another function (lambda) as a parameter or returns one.
         * - Here: `transform` is a lambda that converts a `Task` to a `String`.
         * - Why Functional? Declarative (describes what to do, not how), avoids side effects.
         * - Java Equivalent: `list.stream().map(task -> "Task " + task.getId() + "...").collect(Collectors.toList())`.
         * - Use Case: Transforming data for Android UI (e.g., preparing task titles for a RecyclerView).
         * - From Your Knowledge: Builds on collections (`map`) and lambdas from basics.
         */
        return tasks.map(transform)
    }
    
    // Inline function: Optimizes performance for filtering and logging
    inline fun logTasks(filter: (Task) -> Boolean) {
        /*
         * Functional Programming: Inline Function
         * - Definition: A function marked `inline` has its body (and lambda) copied to the call site, reducing lambda object creation.
         * - Why Functional? Enhances performance of higher-order functions, maintaining declarative style.
         * - Java Equivalent: No direct equivalent; Java relies on JVM optimizations, which are less predictable.
         * - Use Case: Performance-sensitive operations in Android (e.g., logging events in a ViewModel).
         * - Note: `filter` is a lambda, showing functional composition (combining functions).
         */
        tasks.filter(filter).forEach { println("Log: $it") }
    }
    
    // Add a task with scope function for configuration
    fun addTask(title: String, priority: Int) {
        /*
         * Functional Programming: Scope Function (apply)
         * - Definition: `apply` executes a block on an object, configures it, and returns the object.
         * - Why Functional? Promotes immutability by configuring objects declaratively, avoiding mutable state changes.
         * - Java Equivalent: Manual setter calls (e.g., `Task task = new Task(); task.setId(id);`).
         * - Use Case: Initializing objects in Android (e.g., setting up a ViewModel or UI component).
         * - Note: Here, `apply` is minimal but shows the pattern; often used with more properties.
         */
        val task = Task.create(tasks.size + 1, title, priority).apply {
            // No additional configuration needed, but `apply` demonstrates setup
        }
        tasks.add(task)
        println("Added: $task")
    }
    
    // Process nullable task with scope functions
    fun processNullableTask(taskId: Int) {
        /*
         * Functional Programming: Scope Functions (let, run)
         * - Definition:
         *   - `let`: Executes a block on a non-null object, returns the block’s result, ideal for null-safe operations.
         *   - `run`: Executes a block, returns the result, used here for the else case.
         * - Why Functional? Avoids imperative null checks, promotes declarative null handling.
         * - Java Equivalent: `if (task != null) { ... } else { ... }`.
         * - Use Case: Handling nullable API responses or database queries in Android.
         * - Note: Combines with Elvis operator (`?:`) for concise control flow.
         */
        tasks.find { it.id == taskId }?.let { task ->
            println("Found task: ${task.title} (Priority: ${task.priority})")
        } ?: run {
            println("Task ID $taskId not found")
        }
    }
    
    // Update task with scope functions
    fun updateTask(taskId: Int, newTitle: String) {
        /*
         * Functional Programming: Scope Functions (also, with)
         * - Definition:
         *   - `also`: Executes a block for side effects (e.g., logging), returns the object.
         *   - `with`: Non-extension function that executes a block on an object, used for grouping operations.
         * - Why Functional? Separates side effects (`also`) and groups operations (`with`) declaratively.
         * - Java Equivalent: Manual side effect and update (e.g., `System.out.println(task); task.setTitle(newTitle);`).
         * - Use Case: Logging and updating data in Android (e.g., updating UI state and logging).
         * - Note: Uses `copy` (from data classes) for immutability, a functional principle.
         */
        tasks.find { it.id == taskId }?.also { task ->
            println("Updating task: $task")
            with(task) {
                tasks[tasks.indexOf(this)] = copy(title = newTitle)
            }
        } ?: println("Task ID $taskId not found")
    }
}