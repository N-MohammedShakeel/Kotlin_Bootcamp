package Kotlin.Basics
// This file demonstrates Kotlin's variables (var vs val), data types (Int, String, Boolean), and type inference.
// All explanations are provided within comments for clarity and learning purposes.

// Class to demonstrate variables, data types, and type inference
class VariablesDemo {
    // Function to showcase all concepts with practical examples
    fun demonstrate() {
        /*
         * VARIABLES: var vs val
         * 
         * Definition:
         * - Variables are used to store data in a program.
         * - Kotlin provides two keywords for declaring variables:
         *   - `var`: Declares a mutable variable, meaning its value can be changed (reassigned) after initialization.
         *   - `val`: Declares an immutable variable, meaning its value cannot be changed once assigned (similar to `final` in Java).
         * 
         * Key Points:
         * - Prefer `val` for immutability to reduce bugs and make code predictable.
         * - Use `var` only when the value needs to change, e.g., for counters or dynamic state.
         * - Both `var` and `val` can hold any data type.
         * - Variables can be declared at the class level (properties) or within functions (local variables).
         * 
         * Use Cases:
         * - `var`: Updating a score in a game, modifying user input, tracking temporary state.
         * - `val`: Storing constants, configuration values, or fixed data like a user ID.
         * 
         * Nuances:
         * - A `val` variable cannot be reassigned, but if it holds a mutable object (e.g., a List), the object's internal state can change.
         * - Variables must be initialized before use unless declared as `lateinit var` (for class properties, not covered here).
         */

        // Example of `var` (mutable variable)
        // Declaring a mutable variable to store a user's name
        var userName = "Alice"
        println("Initial userName: $userName") // Prints: Alice
        
        // Reassigning the variable (allowed because it's `var`)
        userName = "Bob"
        println("Updated userName: $userName") // Prints: Bob

        // Example of `val` (immutable variable)
        // Declaring an immutable variable to store a user's age
        val userAge = 25
        println("userAge: $userAge") // Prints: 25
        
        // Attempting to reassign `val` causes a compilation error
        // userAge = 26 // Error: Val cannot be reassigned

        // Nuances of `val` with mutable objects
        // A `val` List cannot be reassigned to a new List, but its contents can be modified
        val numbers = mutableListOf(1, 2, 3)
        println("Initial numbers: $numbers") // Prints: [1, 2, 3]
        numbers.add(4) // Modifying the list's internal state
        println("Modified numbers: $numbers") // Prints: [1, 2, 3, 4]
        // numbers = mutableListOf(5, 6) // Error: Val cannot be reassigned

        /*
         * DATA TYPES: Int, String, Boolean
         * 
         * Definition:
         * - Data types define the kind of data a variable can hold.
         * - Kotlin is a statically typed language, meaning types are checked at compile time.
         * - Common basic (primitive-like) data types include:
         *   - Int: Represents a 32-bit integer (e.g., -1, 0, 42).
         *   - String: Represents a sequence of characters (e.g., "Hello").
         *   - Boolean: Represents true or false values.
         * - Other types (not covered here) include Double, Float, Long, Char, Byte, Short, etc.
         * 
         * Key Points:
         * - Kotlin does not distinguish between primitive and wrapper types (like Java's int vs Integer); it handles this internally.
         * - Strings support operations like concatenation, interpolation, and methods like length or uppercase().
         * - Booleans are used in conditional logic (e.g., if statements).
         * 
         * Use Cases:
         * - Int: Counting items, storing ages, performing arithmetic.
         * - String: Storing names, messages, or user input.
         * - Boolean: Representing on/off states, flags, or conditions.
         * 
         * Nuances:
         * - Kotlin’s type system ensures type safety, preventing invalid operations (e.g., adding a String to an Int).
         * - Strings can be multi-line (raw strings) or escaped, and they support template expressions (e.g., "$variable").
         */

        // Example of Int
        // Declaring an integer to store the number of items in a cart
        val itemCount: Int = 10 // Explicit type declaration
        println("Item count: $itemCount") // Prints: 10
        
        // Performing arithmetic with Int
        val totalItems = itemCount + 5
        println("Total items after adding 5: $totalItems") // Prints: 15

        // Example of String
        // Declaring a string to store a greeting message
        val greeting = "Hello, Kotlin!"
        println("Greeting: $greeting") // Prints: Hello, Kotlin!
        
        // String interpolation
        val user = "Charlie"
        println("Welcome, $user! Message length: ${greeting.length}") // Prints: Welcome, Charlie! Message length: 13
        
        // Multi-line (raw) string
        val multiLine = """
            Line 1
            Line 2
            Line 3
        """.trimIndent()
        println("Multi-line string:\n$multiLine")
        // Prints:
        // Line 1
        // Line 2
        // Line 3

        // Example of Boolean
        // Declaring a boolean to track login status
        val isLoggedIn: Boolean = true
        println("Is logged in: $isLoggedIn") // Prints: true
        
        // Using Boolean in conditional logic
        if (isLoggedIn) {
            println("User is logged in") // This will print
        } else {
            println("User is logged out")
        }

        /*
         * TYPE INFERENCE
         * 
         * Definition:
         * - Type inference is Kotlin’s ability to automatically determine a variable’s data type based on its initial value.
         * - Developers can omit explicit type declarations when the type is obvious, making code concise.
         * 
         * Key Points:
         * - Type inference works with both `var` and `val`.
         * - The compiler infers the type at compile time, ensuring type safety.
         * - Explicit type declarations are still allowed (and sometimes required, e.g., for nullability or function return types).
         * 
         * Use Cases:
         * - Simplifying code when types are clear (e.g., `val count = 42` instead of `val count: Int = 42`).
         * - Improving readability by reducing boilerplate.
         * 
         * Nuances:
         * - Type inference cannot be used if the initial value is ambiguous (e.g., `var x = null` requires an explicit type).
         * - When working with complex expressions, explicit types can improve code clarity.
         */

        // Type inference examples
        // Compiler infers types based on initial values
        val inferredInt = 100 // Inferred as Int
        val inferredString = "Kotlin is fun" // Inferred as String
        val inferredBoolean = false // Inferred as Boolean
        println("Inferred types: Int=$inferredInt, String=$inferredString, Boolean=$inferredBoolean")
        // Prints: Inferred types: Int=100, String=Kotlin is fun, Boolean=false

        // Explicit type vs inferred type
        val explicitDouble: Double = 99.99 // Explicit type declaration
        val inferredDouble = 99.99 // Inferred as Double
        println("Explicit Double: $explicitDouble, Inferred Double: $inferredDouble")
        // Prints: Explicit Double: 99.99, Inferred Double: 99.99

        // Case where explicit type is needed
        // val ambiguous = null // Error: Type must be specified for null
        val nullableString: String? = null // Explicit type with nullable String
        println("Nullable String: $nullableString") // Prints: null
    }
}

// Main function to run the demonstration
fun main() {
    // Create an instance of VariablesDemo and run the demonstration
    println("=== Variables, Data Types, and Type Inference Demo ===")
    VariablesDemo().demonstrate()
}