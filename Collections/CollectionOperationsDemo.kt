package Kotlin.Collections// This file demonstrates Kotlin's collection operations: filter, map, forEach, and groupBy.
// All explanations are provided within comments for clarity and learning purposes.

// Class to demonstrate collection operations with practical examples
class CollectionOperationsDemo {
    // Function to showcase filter, map, forEach, and groupBy on List, Set, and Map
    fun demonstrate() {
        /*
         * COLLECTION OPERATIONS OVERVIEW
         * 
         * Definition:
         * - Kotlin provides functional programming operations to process collections efficiently.
         * - These operations are higher-order functions that take lambdas to define behavior.
         * - Key operations covered:
         *   - filter: Selects elements matching a condition.
         *   - map: Transforms each element into a new value.
         *   - forEach: Performs an action for each element.
         *   - groupBy: Groups elements by a key derived from each element.
         * 
         * Key Points:
         * - Operations are non-destructive on immutable collections (return new collections).
         * - Operations can be chained for concise data processing (e.g., filter then map).
         * - Available on List, Set, Map, and other iterables.
         * - Lambdas use `it` for single parameters or explicit names for clarity.
         * 
         * Use Cases:
         * - Filtering data in Android apps (e.g., showing completed tasks).
         * - Transforming data for UI display (e.g., formatting names).
         * - Iterating over items (e.g., logging or updating UI elements).
         * - Grouping data for reports (e.g., tasks by category).
         * 
         * Nuances:
         * - Operations on mutable collections do not modify the original unless explicitly assigned.
         * - Performance: Avoid excessive chaining in large collections; consider alternatives like loops for critical sections.
         * - Type safety: Operations preserve or transform types as defined by the lambda.
         * - Null safety: Handle nullable elements or results carefully.
         */

        /*
         * LIST OPERATIONS
         * 
         * Context:
         * - Demonstrating operations on a List, which is ordered and allows duplicates.
         * - Using a list of tasks for Android app context (e.g., a to-do list).
         */

        // Creating a list of tasks
        val tasks = listOf(
            "Write code", "Test app", "Debug code", "Write docs", "Test UI"
        )
        println("=== List Operations ===")
        println("Original tasks: $tasks") // Prints: [Write code, Test app, Debug code, Write docs, Test UI]

        // FILTER on List
        // Definition: Returns a new list containing elements that satisfy the given predicate.
        // Use Case: Selecting tasks containing "Test" for a testing report.
        val testTasks = tasks.filter { it.contains("Test") }
        println("Filtered tasks (contains 'Test'): $testTasks") // Prints: [Test app, Test UI]

        // MAP on List
        // Definition: Transforms each element into a new value, returning a new list.
        // Use Case: Converting tasks to uppercase for display in a UI.
        val upperTasks = tasks.map { it.uppercase() }
        println("Mapped tasks (uppercase): $upperTasks") // Prints: [WRITE CODE, TEST APP, DEBUG CODE, WRITE DOCS, TEST UI]

        // FOREACH on List
        // Definition: Executes an action for each element, without returning a value.
        // Use Case: Logging each task for debugging in an Android app.
        println("forEach (logging tasks):")
        tasks.forEach { println("- $it") }
        // Prints:
        // - Write code
        // - Test app
        // - Debug code
        // - Write docs
        // - Test UI

        // GROUPBY on List
        // Definition: Groups elements by a key derived from each element, returning a Map.
        // Use Case: Grouping tasks by their first letter for a categorized view.
        val tasksByInitial = tasks.groupBy { it.first() }
        println("Grouped tasks by initial: $tasksByInitial")
        // Prints: {W=[Write code, Write docs], T=[Test app, Test UI], D=[Debug code]}

        /*
         * SET OPERATIONS
         * 
         * Context:
         * - Demonstrating operations on a Set, which is unordered and does not allow duplicates.
         * - Using a set of tags for Android app context (e.g., tags for blog posts).
         */

        // Creating a set of tags
        val tags = setOf("Kotlin", "Android", "Java", "Kotlin", "UI")
        println("\n=== Set Operations ===")
        println("Original tags: $tags") // Prints: [Kotlin, Android, Java, UI] (duplicates removed)

        // FILTER on Set
        // Use Case: Selecting tags with length > 4 for filtering long tags.
        val longTags = tags.filter { it.length > 4 }
        println("Filtered tags (length > 4): $longTags") // Prints: [Kotlin, Android]

        // MAP on Set
        // Use Case: Adding a prefix to tags for display in a UI.
        val prefixedTags = tags.map { "Tag: $it" }
        println("Mapped tags (prefixed): $prefixedTags") // Prints: [Tag: Kotlin, Tag: Android, Tag: Java, Tag: UI]

        // FOREACH on Set
        // Use Case: Displaying each tag in a debug log.
        println("forEach (logging tags):")
        tags.forEachIndexed { index, tag -> println("[$index] $tag") }
        // Prints (order may vary due to Set being unordered):
        // [0] Kotlin
        // [1] Android
        // [2] Java
        // [3] UI

        // GROUPBY on Set
        // Use Case: Grouping tags by their length for analysis.
        val tagsByLength = tags.groupBy { it.length }
        println("Grouped tags by length: $tagsByLength")
        // Prints: {6=[Kotlin, Android], 4=[Java], 2=[UI]}

        /*
         * MAP OPERATIONS
         * 
         * Context:
         * - Demonstrating operations on a Map, which stores key-value pairs with unique keys.
         * - Using a map of user scores for Android app context (e.g., leaderboard).
         */

        // Creating a map of user scores
        val scores = mapOf(
            "Alice" to 90,
            "Bob" to 85,
            "Charlie" to 95,
            "Dave" to 85
        )
        println("\n=== Map Operations ===")
        println("Original scores: $scores") // Prints: {Alice=90, Bob=85, Charlie=95, Dave=85}

        // FILTER on Map
        // Definition: Filters key-value pairs based on a predicate, returning a new Map.
        // Use Case: Selecting users with scores above 90 for a high-score list.
        val highScores = scores.filter { it.value > 90 }
        println("Filtered scores (>90): $highScores") // Prints: {Charlie=95}

        // MAP on Map
        // Definition: Transforms key-value pairs, returning a new collection (often a List).
        // Use Case: Creating a list of formatted score strings for display.
        val scoreStrings = scores.map { "${it.key}: ${it.value} points" }
        println("Mapped scores (formatted): $scoreStrings")
        // Prints: [Alice: 90 points, Bob: 85 points, Charlie: 95 points, Dave: 85 points]

        // FOREACH on Map
        // Use Case: Logging each user’s score for debugging.
        println("forEach (logging scores):")
        scores.forEach { (user, score) -> println("$user scored $score") }
        // Prints:
        // Alice scored 90
        // Bob scored 85
        // Charlie scored 95
        // Dave scored 85

        // GROUPBY on Map
        // Use Case: Grouping users by their scores for a leaderboard summary.
        val usersByScore = scores.entries.groupBy { it.value }.mapValues { it.value.map { entry -> entry.key } }
        println("Grouped users by score: $usersByScore")
        // Prints: {90=[Alice], 85=[Bob, Dave], 95=[Charlie]}

        /*
         * PRACTICAL EXAMPLE: CHAINING OPERATIONS
         * 
         * Context:
         * - Combining multiple operations to process a collection in an Android app scenario.
         * - Example: Filtering tasks, transforming them, and grouping by length.
         */

        println("\n=== Chained Operations Example ===")
        val processedTasks = tasks
            .filter { it.contains("code") } // Keep tasks with "code"
            .map { it.uppercase() } // Convert to uppercase
            .groupBy { it.length } // Group by length
        println("Tasks with 'code', uppercase, grouped by length: $processedTasks")
        // Prints: {10=[WRITE CODE], 11=[DEBUG CODE]}
    }
}

// Main function to run the demonstration
fun main() {
    // Create an instance of CollectionOperationsDemo and run the demonstration
    println("=== Collection Operations Demo ===")
    CollectionOperationsDemo().demonstrate()
}