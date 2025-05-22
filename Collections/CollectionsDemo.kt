package Kotlin.Collections// This file demonstrates Kotlin's collections: List, Set, and Map (both mutable and immutable).
// All explanations are provided within comments for clarity and learning purposes.

// Class to demonstrate collections with practical examples
class CollectionsDemo {
    // Function to showcase List, Set, and Map (mutable and immutable)
    fun demonstrate() {
        /*
         * COLLECTIONS OVERVIEW
         * 
         * Definition:
         * - Kotlin.Collections are data structures used to store and manage multiple items (elements).
         * - Kotlin provides three main collection types:
         *   - List: An ordered collection that allows duplicate elements.
         *   - Set: An unordered collection that does not allow duplicates.
         *   - Map: A collection of key-value pairs, where keys are unique.
         * - Kotlin distinguishes between:
         *   - Immutable collections: Read-only, cannot be modified (e.g., listOf, setOf, mapOf).
         *   - Mutable collections: Can be modified (e.g., mutableListOf, mutableSetOf, mutableMapOf).
         * 
         * Key Points:
         * - Immutable collections are preferred for safety and predictability.
         * - Mutable collections are used when elements need to be added, removed, or updated.
         * - Kotlin’s collections are interoperable with Java but include null safety and functional programming features.
         * - Common operations include iteration, filtering, mapping, and checking membership.
         * 
         * Use Cases:
         * - List: Storing ordered data (e.g., a list of tasks in an Android to-do app).
         * - Set: Managing unique items (e.g., unique tags for a blog post).
         * - Map: Associating keys with values (e.g., user settings with key-value pairs).
         * 
         * Nuances:
         * - Immutable collections cannot be modified but can be copied to create new collections.
         * - Mutable collections are not thread-safe by default; use synchronization for concurrent access.
         * - Kotlin provides functional operations (e.g., filter, map) for concise collection processing.
         */

        /*
         * LIST
         * 
         * Definition:
         * - A List is an ordered collection where elements are stored by index (0-based).
         * - Allows duplicate elements and maintains insertion order.
         * - Immutable: Created with `listOf()`. Mutable: Created with `mutableListOf()`.
         * 
         * Key Points:
         * - Access elements using indices (e.g., list[0]).
         * - Common operations: add, remove, get, set, size, contains, subList.
         * - Immutable lists are fixed; mutable lists support dynamic modifications.
         * 
         * Use Cases:
         * - Displaying items in a RecyclerView (e.g., a list of contacts).
         * - Storing user inputs in order (e.g., a history of search queries).
         * - Managing ordered data in Android apps (e.g., a playlist of songs).
         * 
         * Nuances:
         * - IndexOutOfBoundsException occurs if accessing invalid indices.
         * - Use `getOrNull()` or `getOrElse()` for safe index access.
         * - Prefer immutable lists unless modifications are required.
         */

        // Example of Immutable List
        // Creating a read-only list of fruits
        val fruits: List<String> = listOf("Apple", "Banana", "Apple", "Orange")
        println("=== Immutable List ===")
        println("Fruits: $fruits") // Prints: [Apple, Banana, Apple, Orange]
        println("First fruit: ${fruits[0]}") // Prints: Apple
        println("Size: ${fruits.size}") // Prints: 4
        println("Contains Banana: ${fruits.contains("Banana")}") // Prints: true
        // fruits.add("Mango") // Error: Immutable list cannot be modified

        // Example of Mutable List
        // Creating a modifiable list of tasks
        val tasks: MutableList<String> = mutableListOf("Write code", "Test app")
        println("\n=== Mutable List ===")
        println("Initial tasks: $tasks") // Prints: [Write code, Test app]
        tasks.add("Debug") // Adding an element
        tasks[1] = "Run tests" // Updating an element
        tasks.removeAt(0) // Removing an element
        println("Modified tasks: $tasks") // Prints: [Run tests, Debug]

        // Functional operations on List
        val upperFruits = fruits.map { it.uppercase() }
        println("Uppercase fruits: $upperFruits") // Prints: [APPLE, BANANA, APPLE, ORANGE]
        val longFruits = fruits.filter { it.length > 5 }
        println("Fruits with length > 5: $longFruits") // Prints: [Banana, Orange]

        /*
         * SET
         * 
         * Definition:
         * - A Set is an unordered collection that does not allow duplicate elements.
         * - Elements are unique based on their equality (uses `equals()` and `hashCode()`).
         * - Immutable: Created with `setOf()`. Mutable: Created with `mutableSetOf()`.
         * 
         * Key Points:
         * - No index-based access (unordered).
         * - Common operations: add, remove, contains, size, union, intersect.
         * - Immutable sets are fixed; mutable sets support dynamic modifications.
         * 
         * Use Cases:
         * - Storing unique items (e.g., unique user IDs in an Android app).
         * - Removing duplicates from a collection (e.g., tags for a blog post).
         * - Checking membership efficiently (e.g., validating allowed categories).
         * 
         * Nuances:
         * - Duplicate elements are automatically ignored in sets.
         * - Order of elements is not guaranteed (use LinkedHashSet for insertion order).
         * - Sets are efficient for membership tests but slower for indexed access.
         */

        // Example of Immutable Set
        // Creating a read-only set of colors
        val colors: Set<String> = setOf("Red", "Blue", "Red", "Green")
        println("\n=== Immutable Set ===")
        println("Colors: $colors") // Prints: [Red, Blue, Green] (duplicates removed)
        println("Contains Blue: ${colors.contains("Blue")}") // Prints: true
        println("Size: ${colors.size}") // Prints: 3
        // colors.add("Yellow") // Error: Immutable set cannot be modified

        // Example of Mutable Set
        // Creating a modifiable set of tags
        val tags: MutableSet<String> = mutableSetOf("Kotlin", "Android")
        println("\n=== Mutable Set ===")
        println("Initial tags: $tags") // Prints: [Kotlin, Android]
        tags.add("Java") // Adding an element
        tags.add("Kotlin") // Duplicate, ignored
        tags.remove("Android") // Removing an element
        println("Modified tags: $tags") // Prints: [Kotlin, Java]

        // Set operations
        val otherTags = setOf("Java", "Python")
        val commonTags = tags.intersect(otherTags)
        println("Common tags: $commonTags") // Prints: [Java]
        val allTags = tags.union(otherTags)
        println("All tags: $allTags") // Prints: [Kotlin, Java, Python]

        /*
         * MAP
         * 
         * Definition:
         * - A Map is a collection of key-value pairs, where each key is unique.
         * - Keys map to values, and values can be duplicates.
         * - Immutable: Created with `mapOf()`. Mutable: Created with `mutableMapOf()`.
         * 
         * Key Points:
         * - Access values using keys (e.g., map[key]).
         * - Common operations: put, get, remove, containsKey, size, keys, values.
         * - Immutable maps are fixed; mutable maps support dynamic modifications.
         * 
         * Use Cases:
         * - Storing user preferences (e.g., key: "theme", value: "dark").
         * - Caching data in Android apps (e.g., mapping IDs to objects).
         * - Representing structured data (e.g., API response with key-value pairs).
         * 
         * Nuances:
         * - Keys must be unique; adding a duplicate key overwrites the previous value.
         * - Use `getOrDefault()` or `getOrElse()` for safe access to missing keys.
         * - Maps are not ordered by default (use LinkedHashMap for insertion order).
         */

        // Example of Immutable Map
        // Creating a read-only map of user settings
        val settings: Map<String, String> = mapOf(
            "theme" to "Dark",
            "language" to "English",
            "theme" to "Light" // Duplicate key, only last value kept
        )
        println("\n=== Immutable Map ===")
        println("Settings: $settings") // Prints: {theme=Light, language=English}
        println("Theme: ${settings["theme"]}") // Prints: Light
        println("Contains key 'language': ${settings.containsKey("language")}") // Prints: true
        // settings["font"] = "Arial" // Error: Immutable map cannot be modified

        // Example of Mutable Map
        // Creating a modifiable map of scores
        val scores: MutableMap<String, Int> = mutableMapOf(
            "Alice" to 90,
            "Bob" to 85
        )
        println("\n=== Mutable Map ===")
        println("Initial scores: $scores") // Prints: {Alice=90, Bob=85}
        scores["Charlie"] = 95 // Adding a key-value pair
        scores["Bob"] = 88 // Updating a value
        scores.remove("Alice") // Removing a key-value pair
        println("Modified scores: $scores") // Prints: {Bob=88, Charlie=95}

        // Safe access to map
        val score = scores.getOrDefault("Dave", 0)
        println("Score for Dave (default 0): $score") // Prints: 0

        // Functional operations on Map
        val highScores = scores.filter { it.value > 90 }
        println("High scores (>90): $highScores") // Prints: {Charlie=95}
    }
}

// Main function to run the demonstration
fun main() {
    // Create an instance of CollectionsDemo and run the demonstration
    println("=== Kotlin.Collections Demo ===")
    CollectionsDemo().demonstrate()
}