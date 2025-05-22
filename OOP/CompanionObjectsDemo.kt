package Kotlin.OOP// This file demonstrates Kotlin's Companion Objects, with comparisons to Java for clarity.
// All explanations are provided within comments for learning purposes.

// Class to demonstrate companion objects with practical examples
class CompanionObjectsDemo {
    /*
     * COMPANION OBJECTS OVERVIEW
     * 
     * Definition (Kotlin):
     * - A companion object is a singleton object declared within a class using `companion object`.
     * - It holds class-level (static-like) members (properties, methods) accessed via the class name (e.g., `ClassName.method()`).
     * - Defined in the class body, optionally named (e.g., `companion object Factory`).
     * 
     * Java Equivalent:
     * - Equivalent to Java’s `static` fields and methods (e.g., `public static int counter;` or `public static void doSomething()`).
     * - Unlike Java’s `static`, a companion object is a real object (singleton), allowing it to implement interfaces or be passed around.
     * - Use `@JvmStatic` to expose companion members as true `static` in Java code for interoperability.
     * 
     * Key Points:
     * - Accessed without instantiating the class, like Java’s static members.
     * - Can contain properties, methods, constants, and implement interfaces.
     * - Only one companion object per class.
     * - Useful for factory methods, constants, or utility functions tied to the class.
     * 
     * Use Cases (Android Context):
     * - Generating unique IDs (e.g., for database entries).
     * - Providing factory methods (e.g., creating instances with defaults).
     * - Storing app-wide constants (e.g., API keys, default settings).
     * 
     * Nuances:
     * - Companion objects are not truly `static` (they’re singleton objects), but behave similarly for most purposes.
     * - Avoid using for instance-specific logic; reserve for class-level concerns.
     * - In multi-module Android projects, use `internal` visibility for module-scoped companion members.
     */

    /*
     * EXAMPLE 1: COMPANION OBJECT FOR ID GENERATION
     * 
     * Context:
     * - Modeling a Task in an Android to-do app, with a companion object to generate unique IDs.
     */

    data class Task(val id: Int, val title: String) {
        // Companion object for class-level functionality
        companion object {
            // Private counter, like Java’s `private static int lastId`
            private var lastId = 0
            
            // Factory method, like Java’s `public static Task create(String title)`
            fun create(title: String): Task {
                return Task(++lastId, title)
            }
        }
    }

    /*
     * EXAMPLE 2: COMPANION OBJECT WITH CONSTANTS AND UTILITY
     * 
     * Context:
     * - Modeling an API client for an Android app, with constants and utility methods.
     */

    class ApiClient private constructor(val baseUrl: String) {
        // Public method
        fun fetchData(endpoint: String) {
            println("Fetching data from $baseUrl/$endpoint")
        }
        
        // Companion object
        companion object {
            // Constant, like Java’s `public static final String DEFAULT_URL`
            const val DEFAULT_URL = "https://api.example.com"
            
            // Factory method, like Java’s `public static ApiClient getInstance()`
            fun getInstance(): ApiClient {
                return ApiClient(DEFAULT_URL)
            }
            
            // Utility method, like Java’s `public static String buildEndpoint(String path)`
            fun buildEndpoint(path: String): String {
                return "$DEFAULT_URL/$path"
            }
        }
    }

    /*
     * EXAMPLE 3: COMPANION OBJECT IMPLEMENTING AN INTERFACE
     * 
     * Context:
     * - Modeling a logger for an Android app, with a companion object implementing an interface.
     */

    interface Logger {
        fun log(message: String)
    }

    class Analytics {
        fun trackEvent(event: String) {
            println("Tracking event: $event")
        }
        
        // Companion object implementing an interface
        companion object : Logger {
            override fun log(message: String) {
                println("[Analytics] $message")
            }
        }
    }

    // Demonstration function to showcase companion objects
    fun demonstrate() {
        println("=== Companion Objects Demo ===")

        /*
         * Example 1: ID Generation (Task)
         */
        println("\n=== Companion Object for ID Generation (Task) ===")
        val task1 = Task.create("Write code")
        val task2 = Task.create("Test app")
        println("Task1: $task1") // Prints: Task(id=1, title=Write code)
        println("Task2: $task2") // Prints: Task(id=2, title=Test app)

        /*
         * Example 2: Constants and Utility (ApiClient)
         */
        println("\n=== Companion Object with Constants and Utility (ApiClient) ===")
        val apiClient = ApiClient.getInstance()
        apiClient.fetchData("users")
        // Prints: Fetching data from https://api.example.com/users
        val endpoint = ApiClient.buildEndpoint("products")
        println("Endpoint: $endpoint")
        // Prints: Endpoint: https://api.example.com/products
        println("Default URL: ${ApiClient.DEFAULT_URL}")
        // Prints: Default URL: https://api.example.com

        /*
         * Example 3: Interface Implementation (Analytics)
         */
        println("\n=== Companion Object Implementing Interface (Analytics) ===")
        Analytics.log("App started")
        // Prints: [Analytics] App started
        val analytics = Analytics()
        analytics.trackEvent("User login")
        // Prints: Tracking event: User login
    }
}

// Main function to run the demonstration
fun main() {
    // Create an instance of CompanionObjectsDemo and run the demonstration
    println("=== Companion Objects Demo ===")
    CompanionObjectsDemo().demonstrate()
}