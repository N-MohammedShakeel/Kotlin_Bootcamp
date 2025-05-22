package Kotlin.Basics
// This file demonstrates Kotlin's functions, including defining functions, parameters, return types,
// default arguments, and named arguments.
// All explanations are provided within comments for clarity and learning purposes.

// Class to demonstrate function-related concepts with practical examples
class FunctionsDemo {
    /*
     * FUNCTION DEFINITION
     * 
     * Definition:
     * - A function is a reusable block of code that performs a specific task.
     * - In Kotlin, functions are defined using the `fun` keyword, followed by the function name,
     *   parameters (if any), return type (if not Unit), and body.
     * - Functions can be top-level (outside classes), class members, or local (inside other functions).
     * 
     * Key Points:
     * - Functions without a return type implicitly return `Unit` (similar to `void` in Java).
     * - Function names should be descriptive and follow camelCase convention.
     * - Functions can be called (invoked) multiple times with different inputs.
     * 
     * Use Cases:
     * - Encapsulating logic (e.g., calculating a total, formatting a string).
     * - Reusing code across an application (e.g., validation, data processing).
     * - Structuring Android app logic (e.g., handling button clicks, API calls).
     * 
     * Nuances:
     * - Kotlin supports single-expression functions for concise syntax.
     * - Functions can be overloaded (same name, different parameter lists).
     * - Inline functions and higher-order functions are advanced features (not covered here).
     */

    // Basic function definition with parameters and return type
    // Adds two integers and returns their sum
    fun addNumbers(a: Int, b: Int): Int {
        return a + b
    }

    // Function without return type (returns Unit implicitly)
    // Prints a welcome message
    fun printWelcome(name: String) {
        println("Welcome, $name!")
    }

    /*
     * PARAMETERS
     * 
     * Definition:
     * - Parameters are variables defined in a function’s signature that accept input values when the function is called.
     * - Parameters are declared with a name and type (e.g., `name: String`).
     * - Kotlin allows multiple parameters, separated by commas.
     * 
     * Key Points:
     * - Parameters are immutable within the function (treated as `val`).
     * - Parameter types are mandatory to ensure type safety.
     * - Parameters can be of any type, including custom classes or nullable types.
     * 
     * Use Cases:
     * - Passing data to functions (e.g., user input, configuration values).
     * - Customizing function behavior based on inputs (e.g., formatting text differently).
     * - Processing multiple inputs in Android apps (e.g., user ID and password for login).
     * 
     * Nuances:
     * - Parameters can have default values (covered below).
     * - Avoid excessive parameters (consider data classes for complex inputs).
     * - Parameter names should be meaningful to improve code readability.
     */

    // Function with multiple parameters
    // Calculates the total cost of items with tax
    fun calculateTotal(price: Double, quantity: Int, taxRate: Double): Double {
        val subtotal = price * quantity
        return subtotal + (subtotal * taxRate)
    }

    /*
     * RETURN TYPES
     * 
     * Definition:
     * - The return type specifies the type of value a function produces, declared after the parameter list with `: Type`.
     * - If no value is returned, the function implicitly returns `Unit` (optional to specify).
     * - The `return` keyword is used to exit the function and provide the result.
     * 
     * Key Points:
     * - Return types are mandatory for non-Unit functions to ensure type safety.
     * - Single-expression functions can omit the `return` keyword and braces.
     * - Nullable return types (e.g., `String?`) allow returning null.
     * 
     * Use Cases:
     * - Computing values (e.g., sum, formatted string, or processed data).
     * - Returning status codes or results in Android apps (e.g., success/failure of an operation).
     * - Chaining function calls by returning processed data.
     * 
     * Nuances:
     * - Ensure all code paths return a value for non-Unit functions (compiler enforces this).
     * - Use explicit return types for clarity in complex functions.
     * - Avoid returning `Unit` explicitly unless required for consistency.
     */

    // Function with explicit return type
    // Returns the square of a number
    fun square(number: Int): Int {
        return number * number
    }

    // Single-expression function (concise syntax)
    // Returns the maximum of two numbers
    fun max(a: Int, b: Int): Int = if (a > b) a else b

    /*
     * DEFAULT ARGUMENTS
     * 
     * Definition:
     * - Default arguments allow parameters to have predefined values, used when the caller omits them.
     * - Declared using `= value` in the parameter list (e.g., `greeting: String = "Hello"`).
     * 
     * Key Points:
     * - Reduces the need for function overloading by providing flexibility in calling.
     * - Default values must be constant or resolvable at compile time.
     * - Parameters with default values are optional when calling the function.
     * 
     * Use Cases:
     * - Simplifying function calls with common values (e.g., default language, timeout).
     * - Providing fallback options in Android apps (e.g., default UI settings).
     * - Enhancing API usability by reducing required arguments.
     * 
     * Nuances:
     * - Default arguments work best for trailing parameters to avoid confusion.
     * - Use named arguments (covered below) when skipping some default values.
     * - Avoid complex default values to keep functions predictable.
     */

    // Function with default arguments
    // Greets a user with a customizable greeting
    fun greet(name: String, greeting: String = "Hello"): String {
        return "$greeting, $name!"
    }

    /*
     * NAMED ARGUMENTS
     * 
     * Definition:
     * - Named arguments allow specifying parameter names when calling a function (e.g., `name = "Alice"`).
     * - Improves readability and allows parameters to be provided in any order.
     * 
     * Key Points:
     * - Syntax: `functionName(paramName = value)`.
     * - Especially useful with default arguments or functions with many parameters.
     * - Named arguments are optional but enhance code clarity.
     * 
     * Use Cases:
     * - Clarifying intent in complex function calls (e.g., distinguishing similar parameters).
     * - Skipping default arguments in Android APIs (e.g., setting only specific options).
     * - Improving maintainability by making calls self-documenting.
     * 
     * Nuances:
     * - Named arguments cannot be used with positional arguments for the same parameter.
     * - Overusing named arguments for simple functions may reduce conciseness.
     * - Ensure parameter names are descriptive to maximize the benefit of named arguments.
     */

    // Function demonstrating named arguments
    // Formats a user profile with optional fields
    fun formatProfile(name: String, age: Int = 18, city: String = "Unknown"): String {
        return "Name: $name, Age: $age, City: $city"
    }

    // Demonstration function to showcase all concepts
    fun demonstrate() {
        println("=== Functions Demo ===")

        // Basic function call
        // Using addNumbers
        val sum = addNumbers(5, 3)
        println("addNumbers(5, 3): $sum") // Prints: 8

        // Function without return type
        printWelcome("Alice") // Prints: Welcome, Alice!

        // Function with multiple parameters
        // Calculating total cost
        val total = calculateTotal(price = 10.0, quantity = 2, taxRate = 0.1)
        println("calculateTotal(price=10.0, quantity=2, taxRate=0.1): $total") // Prints: 22.0

        // Function with explicit return type
        // Squaring a number
        val squared = square(4)
        println("square(4): $squared") // Prints: 16

        // Single-expression function
        // Finding maximum
        val maximum = max(7, 2)
        println("max(7, 2): $maximum") // Prints: 7

        // Function with default arguments
        // Using greet with and without default value
        val greeting1 = greet("Bob") // Uses default greeting
        val greeting2 = greet("Charlie", "Hi") // Overrides default
        println("greet(Bob): $greeting1") // Prints: Hello, Bob!
        println("greet(Charlie, Hi): $greeting2") // Prints: Hi, Charlie!

        // Function with named arguments
        // Formatting profile with various argument styles
        val profile1 = formatProfile("Alice") // Uses default age and city
        val profile2 = formatProfile(name = "Bob", city = "New York") // Skips age, uses default
        val profile3 = formatProfile(city = "London", age = 25, name = "Charlie") // Out-of-order
        println("formatProfile(Alice): $profile1") // Prints: Name: Alice, Age: 18, City: Unknown
        println("formatProfile(name=Bob, city=New York): $profile2") // Prints: Name: Bob, Age: 18, City: New York
        println("formatProfile(city=London, age=25, name=Charlie): $profile3") // Prints: Name: Charlie, Age: 25, City: London
    }
}

// Main function to run the demonstration
fun main() {
    // Create an instance of FunctionsDemo and run the demonstration
    println("=== Functions Demo ===")
    FunctionsDemo().demonstrate()
}