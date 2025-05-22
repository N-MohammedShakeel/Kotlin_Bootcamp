package Kotlin.OOP// This file demonstrates Kotlin's Object-Oriented Programming (OOP) concept of Data Classes,
// with comparisons to Java for clarity, especially for a Java-familiar audience.
// All explanations are provided within comments for learning purposes.

// Class to demonstrate data classes with practical examples
class DataClassesDemo {
    /*
     * DATA CLASSES OVERVIEW
     * 
     * Definition (Kotlin):
     * - A data class is a special class designed to hold data, declared with the `data` keyword (e.g., `data class User`).
     * - Automatically generates:
     *   - `toString()`: Readable string representation.
     *   - `equals()`: Compares properties for equality.
     *   - `hashCode()`: Consistent hash code based on properties.
     *   - `copy()`: Creates a copy with optional property changes.
     *   - Destructuring declarations (e.g., `val (id, name) = user`).
     * - Properties declared in the primary constructor are used for these generated methods.
     * 
     * Java Equivalent:
     * - In Java, you’d create a POJO (Plain Old Java Object) with fields, getters, setters, and manually implement `toString()`, `equals()`, `hashCode()`.
     * - Since Java 14, `record` classes (e.g., `record User(int id, String name) {}`) are closer to Kotlin’s data classes, providing similar auto-generated methods.
     * - Kotlin’s data classes are more concise than Java POJOs and slightly more flexible than Java records (e.g., allowing body with custom methods).
     * 
     * Key Points:
     * - Data classes must have at least one property in the primary constructor.
     * - Generated methods only consider properties in the primary constructor (not body properties).
     * - Can have additional methods, properties, or secondary constructors in the body.
     * - Use `data` for classes primarily holding data, not for complex logic.
     * 
     * Use Cases (Android Context):
     * - Modeling data for API responses (e.g., `User` for user profile data).
     * - Representing entities in a database (e.g., `Task` for a to-do app).
     * - Passing data between Android components (e.g., `Product` for an e-commerce app).
     * 
     * Nuances:
     * - Data classes are not sealed or abstract by default; use modifiers if needed.
     * - Properties in the body don’t affect generated methods (e.g., `toString()` ignores them).
     * - Kotlin’s null safety applies (e.g., `String?` for nullable properties).
     * - Compared to Java, Kotlin eliminates boilerplate (no manual getters/setters or method implementations).
     */

    /*
     * EXAMPLE 1: BASIC DATA CLASS
     * 
     * Context:
     * - Modeling a user in an Android app (e.g., for a profile screen).
     * - Demonstrates auto-generated methods and destructuring.
     */

    // Basic data class
    data class User(val id: Int, val name: String, val email: String? = null) {
        // Body property (not included in toString, equals, etc.)
        var lastLogin: String? = null
    }

    /*
     * EXAMPLE 2: DATA CLASS WITH CUSTOM METHOD
     * 
     * Context:
     * - Modeling a task in a to-do app.
     * - Shows how to add custom behavior while retaining data class features.
     */

    data class Task(val id: Int, val title: String, val isCompleted: Boolean = false) {
        // Custom method
        fun toggleCompletion(): Task {
            return copy(isCompleted = !isCompleted)
        }
    }

    /*
     * EXAMPLE 3: DATA CLASS WITH SECONDARY CONSTRUCTOR
     * 
     * Context:
     * - Modeling a product in an e-commerce Android app.
     * - Demonstrates secondary constructor and customization.
     */

    data class Product(val id: Int, val name: String, val price: Double) {
        // Body property
        var category: String? = null
        
        // Secondary constructor
        constructor(name: String, price: Double) : this(generateId(), name, price) {
            category = "General"
        }
        
        // Custom toString for specific formatting
        override fun toString(): String {
            return "Product(ID=$id, Name='$name', Price=$$price, Category=$category)"
        }
        
        // Companion object for ID generation, like Java’s static method
        companion object {
            private var lastId = 0
            fun generateId(): Int = ++lastId
        }
    }

    /*
     * EXAMPLE 4: DATA CLASS IN INHERITANCE
     * 
     * Context:
     * - Demonstrates a data class implementing an interface.
     * - Useful for standardizing behavior in Android (e.g., logging data).
     */

    // Interface for logging
    interface Loggable {
        fun log(): String
    }

    // Data class implementing an interface
    data class LogEntry(val timestamp: Long, val message: String) : Loggable {
        override fun log(): String {
            return "[$timestamp] $message"
        }
    }

    // Demonstration function to showcase data classes
    fun demonstrate() {
        println("=== Data Classes Demo ===")

        /*
         * Example 1: Basic Data Class (User)
         */
        println("\n=== Basic Data Class (User) ===")
        val user1 = User(id = 1, name = "Alice", email = "alice@example.com")
        val user2 = User(id = 1, name = "Alice", email = "alice@example.com")
        val user3 = User(id = 2, name = "Bob")
        
        // Auto-generated toString
        println("User1: $user1")
        // Prints: User(id=1, name=Alice, email=alice@example.com)
        
        // Auto-generated equals
        println("User1 equals User2: ${user1 == user2}") // Prints: true
        println("User1 equals User3: ${user1 == user3}") // Prints: false
        
        // Auto-generated hashCode
        println("User1 hashCode: ${user1.hashCode()}")
        
        // Destructuring
        val (id, name, email) = user1
        println("Destructured: ID=$id, Name=$name, Email=$email")
        // Prints: ID=1, Name=Alice, Email=alice@example.com
        
        // Body property (not in toString/equals)
        user1.lastLogin = "2025-05-18"
        println("User1 with lastLogin: $user1") // lastLogin not shown
        // Prints: User(id=1, name=Alice, email=alice@example.com)

        /*
         * Example 2: Data Class with Custom Method (Task)
         */
        println("\n=== Data Class with Custom Method (Task) ===")
        val task = Task(id = 101, title = "Write code")
        println("Task: $task")
        // Prints: Task(id=101, title=Write code, isCompleted=false)
        
        // Using copy
        val completedTask = task.copy(isCompleted = true)
        println("Copied Task (completed): $completedTask")
        // Prints: Task(id=101, title=Write code, isCompleted=true)
        
        // Custom method
        val toggledTask = task.toggleCompletion()
        println("Toggled Task: $toggledTask")
        // Prints: Task(id=101, title=Write code, isCompleted=true)

        /*
         * Example 3: Data Class with Secondary Constructor (Product)
         */
        println("\n=== Data Class with Secondary Constructor (Product) ===")
        val product1 = Product(id = 1, name = "Laptop", price = 999.99)
        val product2 = Product(name = "Mouse", price = 29.99)
        
        println("Product1: $product1")
        // Prints: Product(ID=1, Name='Laptop', Price=$999.99, Category=null)
        println("Product2: $product2")
        // Prints: Product(ID=1, Name='Mouse', Price=$29.99, Category=General)
        
        // Copy with modified property
        val discountedProduct = product1.copy(price = 899.99)
        println("Discounted Product: $discountedProduct")
        // Prints: Product(ID=1, Name='Laptop', Price=$899.99, Category=null)

        /*
         * Example 4: Data Class in Inheritance (LogEntry)
         */
        println("\n=== Data Class in Inheritance (LogEntry) ===")
        val logEntry = LogEntry(timestamp = 1621357200000, message = "User logged in")
        println("LogEntry: $logEntry")
        // Prints: LogEntry(timestamp=1621357200000, message=User logged in)
        println("Logged: ${logEntry.log()}")
        // Prints: [1621357200000] User logged in
    }
}

// Main function to run the demonstration
fun main() {
    // Create an instance of DataClassesDemo and run the demonstration
    println("=== Data Classes Demo ===")
    DataClassesDemo().demonstrate()
}