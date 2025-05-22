package AdvancedKotlin.Delegates

// Class to demonstrate standard delegates (lazy, observable, vetoable)
class StandardDelegatesDemo {
    /*
     * Delegates: Standard Delegates
     * - Definition: Kotlin provides built-in delegates for common property patterns:
     *   - `lazy`: Initializes a property on first access, thread-safe.
     *   - `observable`: Notifies listeners when a property changes.
     *   - `vetoable`: Allows vetoing property changes based on a condition.
     * - Why Important? Reduces boilerplate for property management, common in Android.
     * - Java Equivalent: Manual lazy initialization (e.g., double-checked locking), observer
     *   patterns, or custom setters, but Kotlin’s delegates are more concise.
     * - Use Case: Lazy database initialization, UI updates on property changes, or validating inputs.
     * - From Your Knowledge: Builds on property concepts and functional programming (lambdas).
     */
    
    // Lazy delegate for a task list
    val taskList: List<Task> by lazy {
        /*
         * Lazy Delegate Context:
         * - Initializes `taskList` only on first access, thread-safe by default.
         * - Java Equivalent: Double-checked locking or `volatile` field with initialization.
         * - Android Relevance: Lazy initialization of a Room database or Retrofit client.
         */
        println("Initializing task list")
        listOf(Task(1, "Lazy Task", 1))
    }
    
    // Observable delegate for task title
    var taskTitle: String by Delegates.observable("Initial Task") { property, oldValue, newValue ->
        /*
         * Observable Delegate Context:
         * - Calls the lambda whenever `taskTitle` changes, passing property, old, and new values.
         * - Java Equivalent: Observer pattern with custom setters and listeners.
         * - Android Relevance: Updating UI when a ViewModel property changes.
         */
        println("${property.name} changed from '$oldValue' to '$newValue'")
    }
    
    // Vetoable delegate for task priority
    var taskPriority: Int by Delegates.vetoable(1) { property, oldValue, newValue ->
        /*
         * Vetoable Delegate Context:
         * - Allows vetoing `taskPriority` changes; returns `true` to accept, `false` to reject.
         * - Rejects priorities outside 1..5.
         * - Java Equivalent: Custom setter with validation logic.
         * - Android Relevance: Validating user input (e.g., task priority in a form).
         */
        newValue in 1..5.also {
            if (!it) println("${property.name} vetoed: $newValue is invalid")
        }
    }
    
    fun demonstrate() {
        /*
         * Standard Delegates Context:
         * - Demonstrates `lazy`, `observable`, and `vetoable` in a task management scenario.
         */
        println("\n=== Standard Delegates Demo ===")
        println("Accessing taskList: $taskList") // Triggers lazy initialization
        taskTitle = "Updated Task" // Triggers observable
        taskPriority = 3 // Accepted by vetoable
        taskPriority = 6 // Rejected by vetoable
        println("Final title: $taskTitle, priority: $taskPriority")
    }
}