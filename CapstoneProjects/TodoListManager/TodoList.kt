package Kotlin.CapstoneProjects.TodoListManager



// Class to manage the to-do list
class TodoListManager {
    /*
     * Class Overview:
     * - Encapsulates task list with private visibility.
     * - Java Equivalent: A class with a `private List<Task>` field and public methods.
     * - Uses visibility modifiers (`private`, `public`) for encapsulation.
     */
    
    private val tasks = mutableListOf<Task>()
    
    // Add a new task
    fun addTask(title: String, description: String?) {
        if (title.isBlank()) {
            println("Error: Title cannot be empty.")
            return
        }
        val task = Task.create(title, description)
        tasks.add(task)
        println("Task added: $task")
    }
    
    // View all tasks
    fun viewTasks() {
        if (tasks.isEmpty()) {
            println("No tasks available.")
            return
        }
        println("\n=== To-Do List ===")
        tasks.forEach { println(it) }
    }
    
    // Complete a task by ID
    fun completeTask(id: Int) {
        val task = tasks.find { it.id == id }
        if (task == null) {
            println("Error: Task with ID $id not found.")
            return
        }
        if (task.isCompleted) {
            println("Task with ID $id is already completed.")
            return
        }
        task.complete()
        println("Task completed: $task")
    }
    
    // Delete a task by ID
    fun deleteTask(id: Int) {
        val task = tasks.find { it.id == id }
        if (task == null) {
            println("Error: Task with ID $id not found.")
            return
        }
        tasks.remove(task)
        println("Task deleted: $task")
    }
}

// Main function to run the app
fun main() {
    /*
     * Main Function:
     * - Provides a console-based menu for user interaction.
     * - Java Equivalent: A `main` method with a `Scanner` for input.
     * - Handles user input with error checking.
     */
    
    val manager = TodoListManager()
    while (true) {
        println("\n=== To-Do List Manager ===")
        println("1. Add Task")
        println("2. View Tasks")
        println("3. Complete Task")
        println("4. Delete Task")
        println("5. Exit")
        print("Enter choice (1-5): ")
        
        when (readLine()?.toIntOrNull()) {
            1 -> {
                print("Enter task title: ")
                val title = readLine().orEmpty()
                print("Enter task description (optional, press Enter to skip): ")
                val description = readLine()?.takeIf { it.isNotBlank() }
                manager.addTask(title, description)
            }
            2 -> manager.viewTasks()
            3 -> {
                print("Enter task ID to complete: ")
                val id = readLine()?.toIntOrNull()
                if (id != null) manager.completeTask(id)
                else println("Error: Invalid ID.")
            }
            4 -> {
                print("Enter task ID to delete: ")
                val id = readLine()?.toIntOrNull()
                if (id != null) manager.deleteTask(id)
                else println("Error: Invalid ID.")
            }
            5 -> {
                println("Exiting...")
                break
            }
            else -> println("Error: Invalid choice. Please enter 1-5.")
        }
    }
}