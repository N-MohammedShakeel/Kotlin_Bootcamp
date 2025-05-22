package AdvancedKotlin.Delegates    // Interface for task management
    interface TaskManager {
        fun addTask(task: Task)
        fun getTasks(): List<Task>
    }