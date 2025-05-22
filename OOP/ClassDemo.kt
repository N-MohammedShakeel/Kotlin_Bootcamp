package Kotlin.OOP
// This file demonstrates Kotlin's Object-Oriented Programming (OOP) concepts for Classes,
// including Properties, Methods, Primary/Secondary Constructors, and Companion Objects,
// with explanations comparing to Java for clarity.
// All explanations are provided within comments for learning purposes.

// Class to demonstrate OOP concepts with practical examples
class ClassDemo {
    /*
     * PROPERTIES
     * 
     * Definition (Kotlin):
     * - Properties are class-level variables/values that store data, declared with `var` (mutable) or `val` (immutable).
     * - Automatically generate getters and setters (customizable).
     * - Can be defined in the class header (via constructor) or body.
     * 
     * Java Equivalent:
     * - In Java, you declare fields (e.g., `private String name;`) and explicitly write getters (`getName()`) and setters (`setName()`).
     * - Kotlin’s `var name: String` is equivalent to a Java field with public getter/setter; `val` is like a `final` field with only a getter.
     * 
     * Use Cases:
     * - Storing object state (e.g., a User’s name or email in an Android app).
     * - Encapsulating data with validation (e.g., ensuring non-negative values).
     * 
     * Nuances:
     * - Kotlin properties simplify code by reducing boilerplate compared to Java.
     * - Use `private` for encapsulation, like Java’s private fields.
     */

    // Example class with properties
    class User(val id: Int, var name: String) {
        // Property in class body, nullable
        var email: String? = null
            set(value) {
                // Custom setter, like Java’s setEmail with validation
                field = if (value?.contains("@") == true) value else null
            }

        // Property with custom getter, like Java’s getIsActive method
        val isActive: Boolean
            get() = email != null
    }

    /*
     * METHODS
     * 
     * Definition (Kotlin):
     * - Methods are functions within a class that define behavior, declared with `fun`.
     * - Can access properties, take parameters, and return values (or `Unit` for no return).
     * 
     * Java Equivalent:
     * - Identical to Java methods (e.g., `public void doSomething()` or `public int calculate()`).
     * - Kotlin’s `fun` is like Java’s method declaration, but with less boilerplate (e.g., no need for `public` by default).
     * 
     * Use Cases:
     * - Performing actions (e.g., completing a task in an Android app).
     * - Computing derived data (e.g., task status).
     * 
     * Nuances:
     * - Kotlin methods are public by default, unlike Java’s package-private default.
     * - Use `this` to refer to the instance, same as Java.
     */

    // Example class with methods
    class Task(var title: String, var isCompleted: Boolean = false) {
        // Method to mark task as completed, like Java’s `public void complete()`
        fun complete() {
            isCompleted = true
            println("Task '$title' is now completed.")
        }

        // Method with return type, like Java’s `public String getStatus()`
        fun getStatus(): String = if (isCompleted) "Completed" else "Pending"
    }

    /*
     * PRIMARY AND SECONDARY CONSTRUCTORS
     * 
     * Definition (Kotlin):
     * - Constructors initialize class instances.
     * - Primary Constructor: Defined in the class header (e.g., `class User(val id: Int)`), concise.
     * - Secondary Constructor: Defined in the body with `constructor`, calls primary constructor if present.
     * 
     * Java Equivalent:
     * - Java constructors are defined with the class name (e.g., `public User(int id) {}`).
     * - Kotlin’s primary constructor combines Java’s constructor and field declarations.
     * - Secondary constructors are like Java’s overloaded constructors (e.g., `public User(String name)`).
     * 
     * Use Cases:
     * - Initializing objects with required data (e.g., a Product’s ID and name).
     * - Providing multiple initialization options (e.g., from JSON in Android).
     * 
     * Nuances:
     * - Primary constructors reduce boilerplate compared to Java.
     * - Secondary constructors are less common due to default arguments in primary constructors.
     */

    /*
     * COMPANION OBJECT
     * 
     * Definition (Kotlin):
     * - A companion object is a special object declared within a class using `companion object`.
     * - It holds static-like members (properties, methods) associated with the class, not instances.
     * - Accessed using the class name (e.g., `Product.generateId()`).
     * 
     * Java Equivalent:
     * - In Java, you use `static` fields and methods (e.g., `public static int generateId()`).
     * - A Kotlin companion object is like a Java class’s `static` members grouped together.
     * - Example: In Java, `public class Product { public static int lastId = 0; }` is equivalent to Kotlin’s `companion object { var lastId = 0 }`.
     * 
     * Key Points:
     * - Only one companion object per class, optionally named (e.g., `companion object Factory`).
     * - Can contain properties, methods, and even implement interfaces.
     * - Accessed without creating an instance, like Java’s static members.
     * - Unlike Java, companion objects are real objects, enabling advanced use cases (e.g., factory patterns).
     * 
     * Use Cases (Android Context):
     * - Generating unique IDs for objects (e.g., database keys).
     * - Providing factory methods (e.g., creating a Product from JSON).
     * - Storing constants or utility functions (e.g., default settings for an Android app).
     * 
     * Nuances:
     * - Companion objects are not truly `static` (they’re singleton objects tied to the class), but behave similarly.
     * - Use `@JvmStatic` to make companion members accessible as true statics in Java code.
     * - Avoid overusing for instance-specific logic; reserve for class-level concerns.
     */

    // Example class with properties, methods, constructors, and companion object
    class Product(
        val id: Int, // Primary constructor property
        var name: String,
        var price: Double = 0.0
    ) {
        // Property in class body
        var category: String? = null

        // Secondary constructor: Initialize with name only
        constructor(name: String) : this(id = generateId(), name = name) {
            this.price = 10.0
            this.category = "General"
        }

        // Secondary constructor: Initialize from a map (e.g., JSON)
        constructor(data: Map<String, Any>) : this(
            id = data["id"] as Int,
            name = data["name"] as String,
            price = data["price"] as Double
        ) {
            this.category = data["category"] as? String
        }

        // Method to apply discount, like Java’s `public void applyDiscount(double percent)`
        fun applyDiscount(discountPercent: Double) {
            if (discountPercent in 0.0..100.0) {
                price -= price * (discountPercent / 100)
                println("Discounted price for '$name': $$price")
            } else {
                println("Error: Invalid discount percentage.")
            }
        }

        // Companion object, equivalent to Java’s static members
        companion object {
            // Property, like Java’s `private static int lastId`
            private var lastId = 0

            // Method to generate IDs, like Java’s `public static int generateId()`
            fun generateId(): Int {
                return ++lastId
            }

            // Factory method, like Java’s `public static Product createDefault()`
            fun createDefault(): Product {
                return Product(name = "Default Product")
            }

            // Constant, like Java’s `public static final String DEFAULT_CATEGORY`
            const val DEFAULT_CATEGORY = "Uncategorized"
        }
    }

    // Demonstration function to showcase all concepts
    fun demonstrate() {
        println("=== Classes with Companion Object Demo ===")

        /*
         * Properties Demo
         */
        println("\n=== Properties ===")
        val user = User(id = 1, name = "Alice")
        println("User: ID=${user.id}, Name=${user.name}, Active=${user.isActive}")
        // Prints: User: ID=1, Name=Alice, Active=false
        user.email = "alice@example.com"
        println("After setting email: Active=${user.isActive}, Email=${user.email}")
        // Prints: Active=true, Email=alice@example.com

        /*
         * Methods Demo
         */
        println("\n=== Methods ===")
        val task = Task(title = "Write code")
        println("Task: Title=${task.title}, Status=${task.getStatus()}")
        // Prints: Title=Write code, Status=Pending
        task.complete() // Prints: Task 'Write code' is now completed.

        /*
         * Constructors Demo
         */
        println("\n=== Constructors ===")
        // Primary constructor
        val product1 = Product(id = 1, name = "Laptop", price = 999.99)
        println("Product1: ID=${product1.id}, Name=${product1.name}, Price=$${product1.price}")
        // Prints: ID=1, Name=Laptop, Price=$999.99

        // Secondary constructor (name only)
        val product2 = Product(name = "Mouse")
        println("Product2: ID=${product2.id}, Name=${product2.name}, Price=$${product2.price}, Category=${product2.category}")
        // Prints: ID=1, Name=Mouse, Price=$10.0, Category=General

        // Secondary constructor (from map)
        val productData = mapOf(
            "id" to 2,
            "name" to "Keyboard",
            "price" to 49.99,
            "category" to "Electronics"
        )
        val product3 = Product(productData)
        println("Product3: ID=${product3.id}, Name=${product3.name}, Price=$${product3.price}, Category=${product3.category}")
        // Prints: ID=2, Name=Keyboard, Price=$49.99, Category=Electronics

        /*
         * Companion Object Demo
         */
        println("\n=== Companion Object ===")
        // Accessing companion object members, like Java static calls
        val newId = Product.generateId()
        println("Generated ID: $newId") // Prints: 2 (or next ID)

        val defaultProduct = Product.createDefault()
        println("Default Product: Name=${defaultProduct.name}, Category=${defaultProduct.category}")
        // Prints: Name=Default Product, Category=General

        println("Default Category: ${Product.DEFAULT_CATEGORY}")
        // Prints: Default Category: Uncategorized

        // Using companion object in method call
        product1.applyDiscount(10.0) // Prints: Discounted price for 'Laptop': $899.991
    }
}

// Main function to run the demonstration
fun main() {
    // Create an instance of ClassesDemo and run the demonstration
    println("=== Classes with Companion Object Demo ===")
    ClassDemo().demonstrate()
}