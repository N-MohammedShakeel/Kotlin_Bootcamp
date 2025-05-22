package Kotlin.Basics
// This file demonstrates Kotlin's control flow constructs: if, when, for, and while loops.
// All explanations are provided within comments for clarity and learning purposes.

// Class to demonstrate control flow with practical examples
class ControlFlowDemo {
    // Function to showcase if, when, for, and while loops
    fun demonstrate() {
        /*
         * IF STATEMENT
         * 
         * Definition:
         * - The `if` statement executes a block of code if a specified condition evaluates to true.
         * - It can include optional `else` and `else if` clauses for alternative conditions.
         * - In Kotlin, `if` is also an expression, meaning it can return a value (e.g., assign the result to a variable).
         * 
         * Key Points:
         * - Conditions must evaluate to a Boolean (true or false).
         * - As an expression, the last line of each branch is returned when used in assignments.
         * - Braces `{}` are optional for single-line blocks but recommended for clarity.
         * 
         * Use Cases:
         * - Validating user input (e.g., checking if age is above a threshold).
         * - Conditional UI updates (e.g., showing/hiding elements based on state).
         * - Handling edge cases (e.g., checking if a value is null or valid).
         * 
         * Nuances:
         * - Avoid nested `if` statements when possible; consider `when` or refactoring for readability.
         * - When used as an expression, all branches must return a value of the same type.
         * - Kotlin does not have a ternary operator (`?:` in other languages), but `if` expressions serve the same purpose.
         */

        // Example of `if` statement
        // Checking a student's score to determine their grade
        val score = 85
        println("=== If Statement ===")
        if (score >= 90) {
            println("Grade: A") // Not executed (85 < 90)
        } else if (score >= 80) {
            println("Grade: B") // Executed (85 >= 80)
        } else {
            println("Grade: C")
        }

        // `if` as an expression
        // Assigning the result of an `if` to a variable
        val grade = if (score >= 90) "A" else if (score >= 80) "B" else "C"
        println("Grade (using if expression): $grade") // Prints: B

        // Practical example: Checking login status
        val isLoggedIn = true
        val message = if (isLoggedIn) "Welcome back!" else "Please log in."
        println("Login message: $message") // Prints: Welcome back!

        /*
         * WHEN STATEMENT
         * 
         * Definition:
         * - The `when` statement is Kotlin’s replacement for the `switch` statement found in other languages.
         * - It evaluates a value or condition and executes the corresponding branch.
         * - Like `if`, `when` can be used as an expression to return a value.
         * 
         * Key Points:
         * - Supports multiple types of conditions: exact values, ranges, types, or expressions.
         * - The `else` branch is optional but required when `when` is an expression (to ensure a return value).
         * - Branches can include multiple values (e.g., `1, 2 -> ...`) or complex conditions (e.g., `in 1..10`).
         * 
         * Use Cases:
         * - Mapping values to actions (e.g., day of week to a string).
         * - Handling enum or sealed class cases.
         * - Replacing complex `if-else` chains for better readability.
         * 
         * Nuances:
         * - `when` is more powerful than `switch` because it supports arbitrary expressions, not just constants.
         * - Use `is` for type checking and `in` for range or collection checks.
         * - Avoid overusing `when` for simple conditions where `if` is clearer.
         */

        // Example of `when` statement
        // Mapping a day number to its name
        val day = 3
        println("\n=== When Statement ===")
        when (day) {
            1 -> println("Monday")
            2 -> println("Tuesday")
            3 -> println("Wednesday") // Executed
            4 -> println("Thursday")
            5 -> println("Friday")
            else -> println("Weekend or invalid day")
        }

        // `when` as an expression
        // Assigning the result of `when` to a variable
        val dayName = when (day) {
            1 -> "Monday"
            2 -> "Tuesday"
            3 -> "Wednesday"
            4 -> "Thursday"
            5 -> "Friday"
            else -> "Weekend or invalid day"
        }
        println("Day name: $dayName") // Prints: Wednesday

        // Advanced `when` with ranges and conditions
        val temperature = 25
        val weather = when (temperature) {
            in -20..0 -> "Freezing"
            in 1..15 -> "Cold"
            in 16..25 -> "Pleasant" // Executed
            else -> "Hot"
        }
        println("Weather at $temperature°C: $weather") // Prints: Pleasant

        /*
         * FOR LOOP
         * 
         * Definition:
         * - The `for` loop iterates over a sequence, such as a range, list, or other iterable.
         * - In Kotlin, `for` uses the `in` keyword to specify the sequence to iterate over.
         * 
         * Key Points:
         * - Common sequences include ranges (e.g., `1..5`), lists, or arrays.
         * - Ranges can be inclusive (`..`), exclusive (`until`), or stepped (e.g., `step 2`).
         * - `for` is typically used when the number of iterations is known.
         * 
         * Use Cases:
         * - Iterating over a list of items (e.g., displaying user names).
         * - Performing repetitive tasks a fixed number of times (e.g., generating a sequence).
         * - Processing collections in Android apps (e.g., populating a RecyclerView).
         * 
         * Nuances:
         * - Kotlin does not have traditional C-style `for` loops (e.g., `for (i=0; i<n; i++)`).
         * - Use `downTo` for descending ranges and `step` for custom increments.
         * - For index-based iteration, use `withIndex()` or `indices`.
         */

        // Example of `for` loop
        // Iterating over a range
        println("\n=== For Loop ===")
        print("Numbers 1 to 5: ")
        for (i in 1..5) {
            print("$i ") // Prints: 1 2 3 4 5
        }

        // Iterating with step
        print("\nEven numbers 2 to 10: ")
        for (i in 2..10 step 2) {
            print("$i ") // Prints: 2 4 6 8 10
        }

        // Iterating over a list
        val fruits = listOf("Apple", "Banana", "Orange")
        println("\nFruits:")
        for (fruit in fruits) {
            println("- $fruit")
        }
        // Prints:
        // - Apple
        // - Banana
        // - Orange

        // Iterating with index
        print("Indexed fruits: ")
        for ((index, fruit) in fruits.withIndex()) {
            print("[$index]=$fruit ")
        }
        // Prints: [0]=Apple [1]=Banana [2]=Orange

        /*
         * WHILE LOOP
         * 
         * Definition:
         * - The `while` loop executes a block of code as long as a condition remains true.
         * - A variant, `do-while`, executes the block at least once before checking the condition.
         * 
         * Key Points:
         * - The condition must evaluate to a Boolean.
         * - Use `while` when the number of iterations is unknown (e.g., reading input until a condition is met).
         * - `do-while` is useful when the loop body must run at least once.
         * 
         * Use Cases:
         * - Processing user input until a specific value is entered.
         * - Polling for updates (e.g., checking network status).
         * - Implementing retry logic in Android apps (e.g., retrying API calls).
         * 
         * Nuances:
         * - Ensure the condition eventually becomes false to avoid infinite loops.
         * - Use `break` to exit a loop early and `continue` to skip to the next iteration.
         * - `while` loops are less common in Kotlin due to functional alternatives (e.g., `for` or collection operations).
         */

        // Example of `while` loop
        // Counting up to 3
        println("\n\n=== While Loop ===")
        var count = 0
        while (count < 3) {
            print("$count ") // Prints: 0 1 2
            count++
        }

        // Example of `do-while` loop
        // Running at least once
        var attempts = 0
        println("\nDo-While Loop:")
        do {
            attempts++
            println("Attempt #$attempts")
        } while (attempts < 2)
        // Prints:
        // Attempt #1
        // Attempt #2

        // Practical example with break and continue
        println("Numbers 1 to 5, skip 3:")
        var i = 0
        while (i < 5) {
            i++
            if (i == 3) continue // Skip 3
            if (i > 4) break // Redundant here, just for illustration
            print("$i ") // Prints: 1 2 4 
        }
    }
}

// Main function to run the demonstration
fun main() {
    // Create an instance of ControlFlowDemo and run the demonstration
    println("=== Control Flow Demo ===")
    ControlFlowDemo().demonstrate()
}