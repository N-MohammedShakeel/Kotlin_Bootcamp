package AdvancedKotlin.Generics

// Class to demonstrate variance (covariance and contravariance)
class VarianceDemo {
    /*
     * Generics: Covariance (out)
     * - Definition: Allows a generic type to be treated as a supertype using `out`. A type `T` marked
     *   `out` can only be produced (returned), not consumed (as input).
     * - Why Important? Enables flexibility in type hierarchies (e.g., `List<out Animal>` can hold `List<Dog>`).
     * - Java Equivalent: `List<? extends Animal>`, but `out` is more concise.
     * - Use Case: A read-only list of tasks in Android UI (e.g., displaying `List<out Task>`).
     * 
     * Generics: Contravariance (in)
     * - Definition: Allows a generic type to be treated as a subtype using `in`. A type `T` marked
     *   `in` can only be consumed (as input), not produced (returned).
     * - Why Important? Useful for operations that accept supertypes (e.g., comparing `Animal` for `Dog`).
     * - Java Equivalent: `Comparator<? super Animal>`, but `in` is more intuitive.
     * - Use Case: A processor that handles any `Task` subtype in Android.
     */

    // Covariant interface (out)
    interface TaskSource<out T : Task> {
        fun getTask(): T
        /*
         * Covariance Context:
         * - `out T` means `TaskSource` can only produce `T` (return it), not consume it.
         * - Allows `TaskSource<BasicTask>` to be treated as `TaskSource<Task>`.
         */
    }

    // Contravariant interface (in)
    interface TaskProcessor<in T : Task> {
        fun process(task: T)
        /*
         * Contravariance Context:
         * - `in T` means `TaskProcessor` can only consume `T` (accept it), not produce it.
         * - Allows `TaskProcessor<Task>` to process `BasicTask` or `PriorityTask`.
         */
    }

    fun demonstrate() {
        /*
         * Variance Context:
         * - Shows covariance and contravariance in action.
         * - Uses `TaskSource` (covariant) and `TaskProcessor` (contravariant).
         */
        println("\n=== Variance Demo ===")

        // Covariance example
        val basicSource = object : TaskSource<BasicTask> {
            override fun getTask() = BasicTask(1, "Covariant Task")
        }
        val taskSource: TaskSource<Task> = basicSource // Covariance: BasicTask -> Task
        println("Covariant task: ${taskSource.getTask()}")

        // Contravariance example
        val taskProcessor = object : TaskProcessor<Task> {
            override fun process(task: Task) {
                println("Processing: ${task.title}")
            }
        }
        val priorityProcessor: TaskProcessor<PriorityTask> = taskProcessor // Contravariance: Task -> PriorityTask
        priorityProcessor.process(PriorityTask(2, "Contravariant Task", 1))
    }
}
