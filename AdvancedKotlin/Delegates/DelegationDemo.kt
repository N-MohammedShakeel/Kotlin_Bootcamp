package AdvancedKotlin.Delegates

// Class to demonstrate Kotlin's delegation pattern with `by`
class DelegationDemo : TaskManager by TaskManagerImpl() {
    /*
     * Delegates: Delegation Pattern (`by` keyword)
     * - Definition: The `by` keyword delegates an interface's implementation to another object,
     *   reducing boilerplate code for implementing methods.
     * - Why Important? Simplifies interface implementation, common in Android for ViewModel or
     *   Fragment logic.
     * - Java Equivalent: Manual delegation (e.g., wrapper class calling delegate methods), verbose.
     * - Use Case: Delegating ViewModel logic to a repository in Android.
     * - From Your Knowledge: Aligns with design patterns (e.g., decorator, proxy).
     */

    fun demonstrate() {
        /*
         * Delegation Context:
         * - Shows `by` delegating `TaskManager` methods to `TaskManagerImpl`.
         * - `DelegationDemo` automatically implements `TaskManager` via delegation.
         */
        println("=== Delegation Pattern Demo ===")
        addTask(Task(1, "Write code", 1))
        addTask(Task(2, "Test app", 2))
        println("Tasks: ${getTasks()}")
    }
}
