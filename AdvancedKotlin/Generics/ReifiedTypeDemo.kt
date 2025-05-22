package AdvancedKotlin.Generics

// Class to demonstrate type constraints and reified types
class ReifiedTypeDemo {
    /*
     * Generics: Type Constraints
     * - Definition: Restrict generic types to specific supertypes using `T : SomeType` (e.g., `T : Comparable<T>`).
     * - Why Important? Ensures type safety by limiting valid types for generics.
     * - Java Equivalent: `<T extends Comparable<T>>`, but Kotlin’s syntax is cleaner.
     * - Use Case: Sorting tasks by a comparable property in Android.
     * 
     * Generics: Reified Types
     * - Definition: Using `inline` functions with `reified` type parameters allows accessing type
     *   information at runtime (e.g., `T::class`).
     * - Why Important? Enables type-safe operations like creating instances or type checks without reflection.
     * - Java Equivalent: No direct equivalent; Java uses reflection (e.g., `Class<T>`), which is less safe.
     * - Use Case: Filtering a list by specific task type in Android.
     */

    // Generic function with type constraint
    fun <T : Task> sortTasks(tasks: List<T>, comparator: Comparator<T>): List<T> {
        /*
         * Type Constraint Context:
         * - `T : Task` ensures `T` is a `Task` subtype, allowing access to `Task` properties.
         * - Uses a `Comparator<T>` to sort tasks, demonstrating type safety.
         * - Java Equivalent: `<T extends Task> List<T> sortTasks(List<T> tasks, Comparator<T> comparator)`.
         */
        return tasks.sortedWith(comparator)
    }

    // Inline function with reified type
    inline fun <reified T : Task> filterByType(tasks: List<Task>): List<T> {
        /*
         * Reified Type Context:
         * - `reified T` allows checking `T::class` at runtime because the function is `inline`.
         * - Filters a list of `Task` to only those of type `T` (e.g., `BasicTask`).
         * - Java Equivalent: Requires reflection (e.g., `task.getClass() == BasicTask.class`), which is error-prone.
         * - Android Relevance: Filtering a mixed list of tasks for specific UI display.
         */
        return tasks.filterIsInstance<T>()
    }

    fun demonstrate() {
        /*
         * Type Constraints and Reified Types Context:
         * - Shows sorting with type constraints and filtering with reified types.
         * - Uses `BasicTask` and `PriorityTask` to demonstrate flexibility.
         */
        println("\n=== Type Constraints and Reified Types Demo ===")
        val tasks = listOf(
            BasicTask(1, "Write code"),
            PriorityTask(2, "Test app", 1),
            BasicTask(3, "Deploy")
        )

        // Type constraint: Sort by title
        val sortedTasks = sortTasks(tasks, compareBy { it.title })
        println("Sorted tasks: $sortedTasks")

        // Reified type: Filter BasicTask
        val basicTasks = filterByType<BasicTask>(tasks)
        println("Filtered BasicTasks: $basicTasks")
    }
}