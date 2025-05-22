package Kotlin.Basics
// This file demonstrates Kotlin's null safety features: Nullable types, Safe calls, Elvis operator, and Non-null assertions.
// All explanations are provided within comments for clarity and learning purposes.

// Class to demonstrate null safety with practical examples
class NullSafetyDemo {
    // Function to showcase nullable types, safe calls, Elvis operator, and non-null assertions
    fun demonstrate() {
        /*
         * NULLABLE TYPES
         * 
         * Definition:
         * - In Kotlin, variables are non-null by default, meaning they cannot hold `null` unless explicitly declared as nullable.
         * - Nullable types are declared by adding a `?` to the type (e.g., `String?` can hold a String or null).
         * - Null safety prevents NullPointerExceptions (NPEs), a common issue in languages like Java.
         * 
         * Key Points:
         * - Use nullable types when a value might legitimately be absent (e.g., optional user input).
         * - Non-null types (e.g., `String`) guarantee a value is never null, enforced by the compiler.
         * - Nullable types require special handling to access properties or methods safely.
         * 
         * Use Cases:
         * - Representing optional data in Android apps (e.g., a user’s middle name or profile picture).
         * - Handling API responses that may return null (e.g., missing fields in JSON).
         * - Modeling uninitialized or undefined states (e.g., a variable before user input).
         * 
         * Nuances:
         * - Nullable types increase code safety but require careful handling to avoid excessive null checks.
         * - Use `val` with nullable types to ensure immutability while allowing null.
         * - Compiler enforces null safety, preventing direct access to nullable properties without checks.
         */

        // Example of nullable types
        // Declaring a nullable String that can hold null
        var nullableName: String? = "Alice"
        println("Nullable Name: $nullableName") // Prints: Alice

        // Reassigning to null
        nullableName = null
        println("Nullable Name after reassignment: $nullableName") // Prints: null

        // Non-null type example
        val nonNullName: String = "Bob"
        // nonNullName = null // Error: Null cannot be a value of a non-null type
        println("Non-null Name: $nonNullName") // Prints: Bob

        /*
         * SAFE CALLS
         * 
         * Definition:
         * - Safe calls use the `?.` operator to access properties or methods of a nullable variable only if it is not null.
         * - If the variable is null, the expression returns null instead of throwing an NPE.
         * 
         * Key Points:
         * - Safe calls are concise and prevent runtime crashes when accessing nullable values.
         * - The result of a safe call is nullable (e.g., `name?.length` returns `Int?`).
         * - Chain multiple safe calls for nested nullable properties (e.g., `obj?.field?.subfield`).
         * 
         * Use Cases:
         * - Accessing properties of optional data (e.g., user’s email length in an Android app).
         * - Safely navigating object hierarchies (e.g., API response with optional nested fields).
         * - Simplifying null checks in UI logic (e.g., displaying a user’s name if available).
         * 
         * Nuances:
         * - Safe calls return null if any part of the chain is null, which may require further handling.
         * - Combine with scope functions like `let` for executing blocks of code when not null.
         * - Avoid overusing safe calls in performance-critical code due to null checks.
         */

        // Example of safe calls
        // Accessing the length of a nullable String
        val nameLength: Int? = nullableName?.length
        println("Length of nullableName (safe call): $nameLength") // Prints: null (since nullableName is null)

        // Reassigning a value to demonstrate safe call with non-null
        nullableName = "Charlie"
        val newNameLength: Int? = nullableName?.length
        println("Length of nullableName (safe call, non-null): $newNameLength") // Prints: 7

        // Safe call with let
        // Execute a block only if the value is not null
        nullableName?.let {
            println("Name is not null: $it, Length: ${it.length}") // Prints: Name is not null: Charlie, Length: 7
        }

        /*
         * ELVIS OPERATOR
         * 
         * Definition:
         * - The Elvis operator (`?:`) provides a default value when a nullable expression evaluates to null.
         * - Syntax: `expression ?: defaultValue` (if expression is null, use defaultValue).
         * 
         * Key Points:
         * - Simplifies null handling by providing fallbacks without explicit if-else checks.
         * - The default value must be compatible with the expected type.
         * - Often used with safe calls to handle null cases concisely.
         * 
         * Use Cases:
         * - Providing default values in Android apps (e.g., default username if none provided).
         * - Handling missing API data (e.g., default configuration if response is null).
         * - Simplifying UI logic (e.g., showing “Unknown” for missing fields).
         * 
         * Nuances:
         * - The Elvis operator does not execute the default value if the expression is non-null.
         * - Can be chained with safe calls (e.g., `name?.length ?: 0`).
         * - Use sparingly in complex expressions to maintain readability.
         */

        // Example of Elvis operator
        // Providing a default name when nullableName is null
        val nameOrDefault = nullableName ?: "Unknown"
        println("Name or default (Elvis): $nameOrDefault") // Prints: Charlie (since nullableName is "Charlie")

        // Elvis with safe call
        val lengthOrZero = nullableName?.length ?: 0
        println("Length or zero (Elvis with safe call): $lengthOrZero") // Prints: 7

        // Reassigning null to demonstrate default
        nullableName = null
        val newNameOrDefault = nullableName ?: "Unknown"
        println("Name or default (Elvis, null case): $newNameOrDefault") // Prints: Unknown

        /*
         * NON-NULL ASSERTIONS
         * 
         * Definition:
         * - The non-null assertion operator (`!!`) asserts that a nullable variable is not null, allowing direct access to its value.
         * - If the variable is null, it throws a NullPointerException at runtime.
         * 
         * Key Points:
         * - Use `!!` only when you are certain the value is not null (e.g., after explicit checks).
         * - Converts a nullable type to a non-null type (e.g., `String?` to `String`).
         * - Considered a last resort due to the risk of runtime crashes.
         * 
         * Use Cases:
         * - Accessing values after manual null checks (e.g., in legacy code or after validation).
         * - Interoperating with Java code that lacks null safety.
         * - Debugging or quick prototyping (not recommended for production).
         * 
         * Nuances:
         * - Overusing `!!` defeats Kotlin’s null safety, leading to NPEs similar to Java.
         * - Prefer safe calls, Elvis operator, or explicit checks to avoid `!!`.
         * - Document the reason for using `!!` to ensure future maintainers understand the assumption.
         */

        // Example of non-null assertion
        // Assuming a value is not null (safe case)
        val assumedNonNull: String? = "Dave"
        val lengthAssumed = assumedNonNull!!.length
        println("Length with non-null assertion (safe): $lengthAssumed") // Prints: 4

        // Practical example with validation
        val input: String? = "Eve"
        if (input != null) {
            val length = input!!.length // Safe due to prior check
            println("Length after validation: $length") // Prints: 3
        }

        // Dangerous use of non-null assertion (for demonstration, avoid in production)
        try {
            val risky: String? = null
            val crash = risky!!.length // Throws NullPointerException
            println("This will not print: $crash")
        } catch (e: NullPointerException) {
            println("Caught NullPointerException: ${e.message}")
        }
    }
}

// Main function to run the demonstration
fun main() {
    // Create an instance of NullSafetyDemo and run the demonstration
    println("=== Null Safety Demo ===")
    NullSafetyDemo().demonstrate()
}