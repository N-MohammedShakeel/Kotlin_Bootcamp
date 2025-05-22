package AdvancedKotlin.Delegates    // Implementation of TaskManager
    class TaskManagerImpl : TaskManager {
        private val tasks = mutableListOf<Task>()
        
        override fun addTask(task: Task) {
            tasks.add(task)
            println("Added: $task")
        }
        
        override fun getTasks(): List<Task> = tasks
    }