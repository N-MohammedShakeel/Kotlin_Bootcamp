package Kotlin.CapstoneProjects.TodoListManager

// Data class for a task
data class Task private constructor(
    val id: Int,
    val title: String,
    val description: String?,
    var isCompleted: Boolean = false
) {
    /*
     * Data Class Overview:
     * - Uses `data class` for automatic `toString`, `equals`, `hashCode`, `copy`.
     * - Java Equivalent: A POJO with fields, getters, setters, and manual method implementations.
     * - Private constructor with companion object for controlled instantiation.
     */
    
    companion object {
        private var lastId = 0
        
        // Factory method, like Java’s `public static Task create(...)`
        fun create(title: String, description: String?): Task {
            return Task(++lastId, title, description)
        }
    }
    
    // Public method to mark task as completed
    fun complete() {
        isCompleted = true
    }
}