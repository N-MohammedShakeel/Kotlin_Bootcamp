package AdvancedKotlin.AnnotationsReflection

// Data class for a task, using annotations
@TaskInfo(description = "Represents a task in the system", priority = 1)
data class Task(
    @TaskInfo(description = "Unique task ID", priority = 2)
    val id: Int,
    @TaskInfo(description = "Task title", priority = 1)
    var title: String,
    @TaskInfo(description = "Task priority", priority = 3)
    var priority: Int
) {
    /*
     * Annotations Context:
     * - Task class and properties are annotated with @TaskInfo for metadata.
     * - From Your Knowledge: Data classes for immutability (with mutable fields for demo).
     * - Android Relevance: Represents to-do items in a ViewModel or Room database.
     */
}
