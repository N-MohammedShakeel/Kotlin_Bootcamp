package Kotlin.Collections// This file demonstrates iterating over Kotlin collections (List, Set, Map) and manipulating their data.
// All explanations are provided within comments for clarity and learning purposes.

// Class to demonstrate iteration and manipulation of collections with practical examples
class CollectionIterationDemo {
    // Function to showcase iteration techniques and data manipulation
    fun demonstrate() {
        /*
         * ITERATING AND MANIPULATING COLLECTIONS OVERVIEW
         * 
         * Definition:
         * - Iterating over collections involves accessing each element to read, process, or modify it.
         * - Manipulating collections involves adding, removing, updating, or transforming elements.
         * - Kotlin collections (List, Set, Map) support:
         *   - Immutable collections (read-only, e.g., listOf, setOf, mapOf).
         *   - Mutable collections (modifiable, e.g., mutableListOf, mutableSetOf, mutableMapOf).
         * - Iteration methods include `for` loops, `forEach`, indexed iteration, and functional operations.
         * 
         * Key Points:
         * - Use `for` loops for simple iteration, `forEach` for functional style, and indexed iteration for position-based access.
         * - Manipulation requires mutable collections; immutable collections can be copied or transformed into new collections.
         * - Common operations: add, remove, update, clear, filter, map, and sort.
         * - Null safety: Handle nullable elements or collections carefully.
         * 
         * Use Cases (Android Context):
         * - Iterating: Displaying tasks in a RecyclerView, logging tags, or processing user settings.
         * - Manipulating: Adding a new task, removing completed tasks, updating user preferences.
         * - Combining: Filtering tasks by status, transforming data for UI, or reorganizing settings.
         * 
         * Nuances:
         * - Avoid modifying mutable collections during iteration to prevent ConcurrentModificationException (use safe alternatives like `toMutableList()`).
         * - Functional operations (e.g., filter, map) create new collections, preserving immutability.
         * - Performance: For large collections, prefer loops over chained functional operations in critical sections.
         * - Order: Lists maintain order, Sets do not (unless using LinkedHashSet), Maps use key-based access.
         */

        /*
         * LIST: ITERATION AND MANIPULATION
         * 
         * Context:
         * - List is an ordered collection allowing duplicates, ideal for task lists in an Android to-do app.
         * - Iteration: Access elements by index or directly.
         * - Manipulation: Add, remove, update, or transform tasks.
         */

        // Immutable List: Iteration
        // Creating a read-only list of tasks
        val tasks: List<String> = listOf("Write code", "Test app", "Debug code", "Write docs")
        println("=== Immutable List: Iteration ===")
        // Basic for loop
        print("Tasks (for loop): ")
        for (task in tasks) {
            print("$task | ") // Prints: Write code | Test app | Debug code | Write docs |
        }

        // forEach
        println("\nTasks (forEach):")
        tasks.forEach { println("- $it") }
        // Prints:
        // - Write code
        // - Test app
        // - Debug code
        // - Write docs

        // Indexed iteration
        println("Tasks (indexed):")
        for ((index, task) in tasks.withIndex()) {
            println("[$index] $task")
        }
        // Prints:
        // [0] Write code
        // [1] Test app
        // [2] Debug code
        // [3] Write docs

        // Mutable List: Manipulation
        // Creating a modifiable list of tasks
        val mutableTasks: MutableList<String> = mutableListOf("Plan sprint", "Code feature")
        println("\n=== Mutable List: Manipulation ===")
        println("Initial tasks: $mutableTasks") // Prints: [Plan sprint, Code feature]

        // Adding elements
        mutableTasks.add("Review code") // Append
        mutableTasks.add(1, "Write tests") // Insert at index 1
        println("After adding tasks: $mutableTasks") // Prints: [Plan sprint, Write tests, Code feature, Review code]

        // Updating elements
        mutableTasks[0] = "Plan release"
        println("After updating index 0: $mutableTasks") // Prints: [Plan release, Write tests, Code feature, Review code]

        // Removing elements
        mutableTasks.remove("Write tests")
        mutableTasks.removeAt(2) // Remove "Review code"
        println("After removing tasks: $mutableTasks") // Prints: [Plan release, Code feature]

        // Transforming (e.g., filter and map during iteration)
        val shortTasks = mutableTasks.filter { it.length < 15 }.map { it.uppercase() }
        println("Short tasks (<15 chars, uppercase): $shortTasks") // Prints: [PLAN RELEASE, CODE FEATURE]

        /*
         * SET: ITERATION AND MANIPULATION
         * 
         * Context:
         * - Set is an unordered collection with no duplicates, ideal for unique tags in an Android app.
         * - Iteration: Access elements without indices (order not guaranteed).
         * - Manipulation: Add or remove tags, ensuring uniqueness.
         */

        // Immutable Set: Iteration
        // Creating a read-only set of tags
        val tags: Set<String> = setOf("Kotlin", "Android", "Java", "Kotlin") // Duplicate ignored
        println("\n=== Immutable Set: Iteration ===")
        // Basic for loop
        print("Tags (for loop): ")
        for (tag in tags) {
            print("$tag | ") // Prints: Kotlin | Android | Java | (order may vary)
        }

        // forEach
        println("\nTags (forEach):")
        tags.forEach { println("- $it") }
        // Prints:
        // - Kotlin
        // - Android
        // - Java

        // Mutable Set: Manipulation
        // Creating a modifiable set of tags
        val mutableTags: MutableSet<String> = mutableSetOf("UI", "Backend")
        println("\n=== Mutable Set: Manipulation ===")
        println("Initial tags: $mutableTags") // Prints: [UI, Backend]

        // Adding elements
        mutableTags.add("Database")
        mutableTags.add("UI") // Duplicate, ignored
        println("After adding tags: $mutableTags") // Prints: [UI, Backend, Database]

        // Removing elements
        mutableTags.remove("Backend")
        println("After removing Backend: $mutableTags") // Prints: [UI, Database]

        // Transforming (e.g., filter during iteration)
        val longTags = mutableTags.filter { it.length > 2 }.toSet()
        println("Long tags (>2 chars): $longTags") // Prints: [Database]

        // Practical example: Safe iteration with modification
        // Copy to avoid ConcurrentModificationException
        val tagsToRemove = mutableTags.filter { it.startsWith("D") }.toSet()
        tagsToRemove.forEach { mutableTags.remove(it) }
        println("After removing tags starting with D: $mutableTags") // Prints: [UI]

        /*
         * MAP: ITERATION AND MANIPULATION
         * 
         * Context:
         * - Map stores key-value pairs with unique keys, ideal for user settings in an Android app.
         * - Iteration: Access keys, values, or key-value pairs.
         * - Manipulation: Add, update, or remove settings.
         */

        // Immutable Map: Iteration
        // Creating a read-only map of user settings
        val settings: Map<String, String> = mapOf(
            "theme" to "Dark",
            "language" to "English",
            "font" to "Arial"
        )
        println("\n=== Immutable Map: Iteration ===")
        // Iterating over entries
        print("Settings (entries): ")
        for ((key, value) in settings) {
            print("$key=$value | ") // Prints: theme=Dark | language=English | font=Arial |
        }

        // Iterating over keys
        println("\nKeys:")
        for (key in settings.keys) {
            println("- $key")
        }
        // Prints:
        // - theme
        // - language
        // - font

        // forEach
        println("Settings (forEach):")
        settings.forEach { (key, value) -> println("$key: $value") }
        // Prints:
        // theme: Dark
        // language: English
        // font: Arial

        // Mutable Map: Manipulation
        // Creating a modifiable map of user preferences
        val preferences: MutableMap<String, String> = mutableMapOf(
            "notifications" to "On",
            "sync" to "Auto"
        )
        println("\n=== Mutable Map: Manipulation ===")
        println("Initial preferences: $preferences") // Prints: {notifications=On, sync=Auto}

        // Adding key-value pairs
        preferences["theme"] = "Light"
        println("After adding theme: $preferences") // Prints: {notifications=On, sync=Auto, theme=Light}

        // Updating values
        preferences["sync"] = "Manual"
        println("After updating sync: $preferences") // Prints: {notifications=On, sync=Manual, theme=Light}

        // Removing key-value pairs
        preferences.remove("notifications")
        println("After removing notifications: $preferences") // Prints: {sync=Manual, theme=Light}

        // Transforming (e.g., map during iteration)
        val formattedPrefs = preferences.map { (key, value) -> "$key set to $value" }
        println("Formatted preferences: $formattedPrefs") // Prints: [sync set to Manual, theme set to Light]

        /*
         * PRACTICAL EXAMPLE: COMBINED ITERATION AND MANIPULATION
         * 
         * Context:
         * - Simulating an Android to-do app: Process tasks, update statuses, and categorize.
         * - Combines iteration, manipulation, and functional operations.
         */

        println("\n=== Practical Example: Task Manager ===")
        val taskList = mutableListOf(
            "Write code:In Progress",
            "Test app:Completed",
            "Debug code:Pending",
            "Write docs:In Progress"
        )
        println("Initial task list: $taskList")

        // Iterate and manipulate: Mark tasks starting with "Write" as Completed
        for (i in taskList.indices) {
            if (taskList[i].startsWith("Write")) {
                taskList[i] = taskList[i].replace("In Progress", "Completed")
            }
        }
        println("After updating 'Write' tasks: $taskList")
        // Prints: [Write code:Completed, Test app:Completed, Debug code:Pending, Write docs:Completed]

        // Transform and categorize: Create a map of tasks by status
        val tasksByStatus = taskList.groupBy { it.split(":")[1] }
        println("Tasks by status: $tasksByStatus")
        // Prints: {Completed=[Write code:Completed, Test app:Completed, Write docs:Completed], Pending=[Debug code:Pending]}

        // Iterate and display: Show only Completed tasks
        println("Completed tasks:")
        tasksByStatus["Completed"]?.forEach { println("- $it") }
        // Prints:
        // - Write code:Completed
        // - Test app:Completed
        // - Write docs:Completed
    }
}

// Main function to run the demonstration
fun main() {
    // Create an instance of CollectionIterationDemo and run the demonstration
    println("=== Collection Iteration and Manipulation Demo ===")
    CollectionIterationDemo().demonstrate()
}