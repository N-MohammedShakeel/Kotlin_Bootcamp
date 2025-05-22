package Kotlin.Basics
// This file demonstrates Kotlin's operators: Arithmetic, Comparison, and Logical.
// All explanations are provided within comments for clarity and learning purposes.

// Class to demonstrate operators with practical examples
class OperatorsDemo {
    // Function to showcase arithmetic, comparison, and logical operators
    fun demonstrate() {
        /*
         * ARITHMETIC OPERATORS
         * 
         * Definition:
         * - Arithmetic operators perform mathematical operations on numeric values (e.g., Int, Double).
         * - Supported operators:
         *   - `+`: Addition (adds two values).
         *   - `-`: Subtraction (subtracts one value from another).
         *   - `*`: Multiplication (multiplies two values).
         *   - `/`: Division (divides one value by another).
         *   - `%`: Modulus (returns the remainder of division).
         * 
         * Key Points:
         * - Operands must be compatible types (e.g., Int with Int, Double with Double).
         * - Division (`/`) with integers performs integer division (truncates decimal part).
         * - Use `toDouble()` or explicit Double literals for floating-point division.
         * - Modulus (`%`) works with integers and returns the remainder.
         * 
         * Use Cases:
         * - Calculating totals, differences, or averages (e.g., shopping cart total).
         * - Determining remainders (e.g., checking if a number is even or odd).
         * - Scaling values (e.g., applying discounts or taxes).
         * 
         * Nuances:
         * - Be cautious with division by zero (causes a runtime exception for integers).
         * - Mixing Int and Double in operations results in a Double (e.g., 5 + 2.0 = 7.0).
         * - Kotlin supports operator overloading, allowing custom types to use these operators (advanced topic).
         */

        // Example of Arithmetic Operators
        // Declaring variables for arithmetic operations
        val a = 10
        val b = 3
        println("=== Arithmetic Operators (a=$a, b=$b) ===")
        
        // Addition
        val sum = a + b
        println("Addition: $a + $b = $sum") // Prints: 10 + 3 = 13
        
        // Subtraction
        val difference = a - b
        println("Subtraction: $a - $b = $difference") // Prints: 10 - 3 = 7
        
        // Multiplication
        val product = a * b
        println("Multiplication: $a * $b = $product") // Prints: 10 * 3 = 30
        
        // Division (integer division)
        val quotient = a / b
        println("Division: $a / $b = $quotient") // Prints: 10 / 3 = 3 (integer division)
        
        // Division (floating-point)
        val floatQuotient = a.toDouble() / b
        println("Floating-point Division: $a / $b = $floatQuotient") // Prints: 10 / 3 = 3.333...
        
        // Modulus
        val remainder = a % b
        println("Modulus: $a % $b = $remainder") // Prints: 10 % 3 = 1
        
        // Practical example: Checking if a number is even
        val number = 8
        val isEven = number % 2 == 0
        println("Is $number even? $isEven") // Prints: Is 8 even? true

        /*
         * COMPARISON OPERATORS
         * 
         * Definition:
         * - Comparison operators compare two values and return a Boolean (true or false).
         * - Supported operators:
         *   - `==`: Equal to (checks if two values are equal).
         *   - `!=`: Not equal to (checks if two values are different).
         *   - `>`: Greater than (checks if the left value is larger).
         *   - `<`: Less than (checks if the left value is smaller).
         *   - `>=`: Greater than or equal to.
         *   - `<=`: Less than or equal to.
         * 
         * Key Points:
         * - Can compare numbers (Int, Double), strings (lexicographical order), and other comparable types.
         * - `==` checks structural equality (value equality), while `===` checks referential equality (same object, not covered here).
         * - String comparisons using `==` are case-sensitive.
         * 
         * Use Cases:
         * - Validating user input (e.g., checking if age > 18).
         * - Sorting data (e.g., comparing scores).
         * - Conditional logic (e.g., determining eligibility based on thresholds).
         * 
         * Nuances:
         * - Comparing floating-point numbers (e.g., Double) can be tricky due to precision issues; use thresholds if needed.
         * - For strings, use `equals()` with `ignoreCase=true` for case-insensitive comparisons.
         */

        // Example of Comparison Operators
        // Comparing numbers
        val x = 15
        val y = 20
        println("\n=== Comparison Operators (x=$x, y=$y) ===")
        
        // Equal to
        println("$x == $y: ${x == y}") // Prints: 15 == 20: false
        
        // Not equal to
        println("$x != $y: ${x != y}") // Prints: 15 != 20: true
        
        // Greater than
        println("$x > $y: ${x > y}") // Prints: 15 > 20: false
        
        // Less than
        println("$x < $y: ${x < y}") // Prints: 15 < 20: true
        
        // Greater than or equal to
        println("$x >= $y: ${x >= y}") // Prints: 15 >= 20: false
        
        // Less than or equal to
        println("$x <= $y: ${x <= y}") // Prints: 15 <= 20: true

        // Comparing strings
        val str1 = "Kotlin"
        val str2 = "kotlin"
        println("String comparison: $str1 == $str2: ${str1 == str2}") // Prints: false (case-sensitive)
        println("Case-insensitive: ${str1.equals(str2, ignoreCase = true)}") // Prints: true

        /*
         * LOGICAL OPERATORS
         * 
         * Definition:
         * - Logical operators combine Boolean expressions to produce a Boolean result.
         * - Supported operators:
         *   - `&&`: Logical AND (true if both operands are true).
         *   - `||`: Logical OR (true if at least one operand is true).
         *   - `!`: Logical NOT (inverts the Boolean value).
         * 
         * Key Points:
         * - Used in conditional statements (e.g., if, when) to combine conditions.
         * - Short-circuit evaluation: `&&` stops evaluating if the left operand is false; `||` stops if the left is true.
         * - Operands must evaluate to Boolean (true or false).
         * 
         * Use Cases:
         * - Validating multiple conditions (e.g., user is logged in AND has permission).
         * - Providing fallback options (e.g., use default OR user-provided value).
         * - Toggling states (e.g., enabling/disabling features).
         * 
         * Nuances:
         * - Ensure operands are Boolean to avoid type errors.
         * - Use parentheses to clarify precedence in complex expressions (e.g., (a && b) || c).
         */

        // Example of Logical Operators
        // Declaring Boolean variables for logical operations
        val isSunny = true
        val isWarm = false
        println("\n=== Logical Operators (isSunny=$isSunny, isWarm=$isWarm) ===")
        
        // Logical AND
        val goOutside = isSunny && isWarm
        println("Sunny AND Warm (go outside): $goOutside") // Prints: false (both must be true)
        
        // Logical OR
        val stayComfortable = isSunny || isWarm
        println("Sunny OR Warm (stay comfortable): $stayComfortable") // Prints: true (at least one is true)
        
        // Logical NOT
        val notSunny = !isSunny
        println("NOT Sunny: $notSunny") // Prints: false (inverts true to false)

        // Practical example: Checking eligibility
        val age = 20
        val hasLicense = true
        val canDrive = age >= 18 && hasLicense
        println("Can drive (age >= 18 AND has license): $canDrive") // Prints: true
    }
}

// Main function to run the demonstration
fun main() {
    // Create an instance of OperatorsDemo and run the demonstration
    println("=== Operators Demo ===")
    OperatorsDemo().demonstrate()
}