package Kotlin.OOP// This file demonstrates Kotlin's Object-Oriented Programming (OOP) concept of Visibility Modifiers,
// with comparisons to Java for clarity, especially for a Java-familiar audience.
// All explanations are provided within comments for learning purposes.

// Class to demonstrate visibility modifiers with practical examples
class VisibilityModifiersDemo {
    /*
     * VISIBILITY MODIFIERS OVERVIEW
     * 
     * Definition (Kotlin):
     * - Visibility modifiers control the access level of classes, properties, methods, and constructors.
     * - Kotlin provides four main visibility modifiers:
     *   - `public`: Accessible everywhere (default in Kotlin).
     *   - `private`: Accessible only within the same class or file (for top-level declarations).
     *   - `protected`: Accessible within the same class and its subclasses.
     *   - `internal`: Accessible within the same module (a module is a set of Kotlin files compiled together, e.g., an Android app module).
     * - Additional concept: `private to this` for properties with restricted setter access.
     * 
     * Java Equivalent:
     * - `public`: Same as Java’s `public` (accessible everywhere).
     * - `private`: Same as Java’s `private` (accessible only within the class).
     * - `protected`: Same as Java’s `protected` (accessible in the class, subclasses, and same package in Java; Kotlin’s `protected` is stricter, excluding package access).
     * - `internal`: No direct Java equivalent; closest is Java’s package-private (default, no modifier), but `internal` is module-scoped, not package-scoped.
     * - Java’s package-private: No exact Kotlin equivalent, as Kotlin uses modules instead of packages for `internal`.
     * 
     * Key Points:
     * - Default visibility in Kotlin is `public`, unlike Java’s package-private.
     * - Visibility applies to classes, properties, methods, constructors, and top-level declarations.
     * - `internal` is powerful in multi-module projects (e.g., Android apps with library modules).
     * - Use `private set` or custom setters for restricted property modification (encapsulation).
     * 
     * Use Cases (Android Context):
     * - `public`: Exposing APIs for UI components (e.g., a `Button`’s `click()` method).
     * - `private`: Hiding implementation details (e.g., a class’s internal counter).
     * - `protected`: Allowing subclasses to access base class logic (e.g., a `Fragment`’s setup method).
     * - `internal`: Restricting access to module-specific utilities (e.g., a database helper in an Android module).
     * 
     * Nuances:
     * - Kotlin’s `protected` is stricter than Java’s (no package access).
     * - `internal` is less granular than Java’s package-private but suits modular projects.
     * - Use visibility to enforce encapsulation and prevent misuse of internal APIs.
     * - Kotlin’s null safety applies to all visibility levels.
     */

    /*
     * EXAMPLE 1: VISIBILITY MODIFIERS IN A CLASS
     * 
     * Context:
     * - Modeling a UI component (Button) in an Android app.
     * - Demonstrates `public`, `private`, and `protected` modifiers.
     */

    // Open class for inheritance
    open class Button(val id: Int) {
        // Public property (accessible everywhere)
        public var text: String = "Click Me"
        
        // Private property (accessible only within this class)
        private var clickCount: Int = 0
        
        // Protected property (accessible in this class and subclasses)
        protected var isEnabled: Boolean = true
        
        // Public method
        public fun click() {
            clickCount++
            println("Button ID: $id clicked. Total clicks: $clickCount")
        }
        
        // Private method
        private fun logClick() {
            println("Logging click for Button ID: $id")
        }
        
        // Protected method
        protected open fun updateState() {
            println("Updating Button state: Enabled=$isEnabled")
        }
    }

    // Subclass to demonstrate protected access
    class SmartButton(id: Int, var isInteractive: Boolean) : Button(id) {
        // Public method accessing protected members
        fun toggleInteractive() {
            isEnabled = isInteractive // Accessing protected property
            updateState() // Accessing protected method
            println("SmartButton interactivity: $isInteractive")
            // clickCount // Error: Private property not accessible
            // logClick() // Error: Private method not accessible
        }
        
        override fun updateState() {
            println("SmartButton state updated: Enabled=$isEnabled, Interactive=$isInteractive")
        }
    }

    /*
     * EXAMPLE 2: INTERNAL VISIBILITY IN A MODULE
     * 
     * Context:
     * - Modeling a database helper in an Android app module.
     * - Demonstrates `internal` for module-scoped access.
     */

    // Internal class (accessible only within the same module)
    internal class DatabaseHelper {
        // Internal property
        internal val connectionStatus: String = "Connected"
        
        // Internal method
        internal fun query(query: String) {
            println("Executing query: $query on $connectionStatus database")
        }
    }

    /*
     * EXAMPLE 3: PRIVATE CONSTRUCTOR AND PRIVATE SET
     * 
     * Context:
     * - Modeling a user manager with restricted instantiation and property modification.
     * - Demonstrates `private` constructor and `private set` for encapsulation.
     */

    class UserManager private constructor(val adminId: Int) {
        // Public property with private setter
        var activeUser: String = "Guest"
            private set
        
        // Public method to update active user
        fun setActiveUser(newUser: String) {
            if (newUser.isNotBlank()) {
                activeUser = newUser
                println("Active user set to: $activeUser")
            }
        }
        
        // Companion object for controlled instantiation
        companion object {
            // Public factory method
            fun create(adminId: Int): UserManager {
                return UserManager(adminId)
            }
        }
    }

    /*
     * EXAMPLE 4: TOP-LEVEL DECLARATIONS WITH VISIBILITY
     * 
     * Context:
     * - Demonstrates visibility modifiers for top-level functions and properties.
     * - Useful for utility functions in an Android app.
     */

    // Public top-level property
    val APP_VERSION = "1.0.0"

    // Internal top-level function
    internal fun logAppInfo() {
        println("App Version: $APP_VERSION")
    }

    // Private top-level function
    private fun internalLog(message: String) {
        println("[Internal] $message")
    }

    // Demonstration function to showcase visibility modifiers
    fun demonstrate() {
        println("=== Visibility Modifiers Demo ===")

        /*
         * Example 1: Visibility in a Class (Button)
         */
        println("\n=== Visibility in a Class (Button) ===")
        val button = Button(id = 101)
        println("Button Text: ${button.text}") // Accessing public property
        button.text = "Submit"
        button.click() // Accessing public method
        // Prints:
        // Button Text: Click Me
        // Button ID: 101 clicked. Total clicks: 1
        // button.clickCount // Error: Private property
        // button.logClick() // Error: Private method
        
        val smartButton = SmartButton(id = 102, isInteractive = true)
        smartButton.toggleInteractive()
        // Prints:
        // SmartButton state updated: Enabled=true, Interactive=true
        // SmartButton interactivity: true
        smartButton.click() // Accessing inherited public method
        // Prints: Button ID: 102 clicked. Total clicks: 1

        /*
         * Example 2: Internal Visibility (DatabaseHelper)
         */
        println("\n=== Internal Visibility (DatabaseHelper) ===")
        val dbHelper = DatabaseHelper()
        println("Connection Status: ${dbHelper.connectionStatus}")
        // Prints: Connected
        dbHelper.query("SELECT * FROM users")
        // Prints: Executing query: SELECT * FROM users on Connected database
        // Note: In another module, DatabaseHelper would be inaccessible

        /*
         * Example 3: Private Constructor and Private Set (UserManager)
         */
        println("\n=== Private Constructor and Private Set (UserManager) ===")
        // val userManager = UserManager(1) // Error: Private constructor
        val userManager = UserManager.create(adminId = 1)
        println("Active User: ${userManager.activeUser}")
        // Prints: Guest
        userManager.setActiveUser("Alice")
        // Prints: Active user set to: Alice
        // userManager.activeUser = "Bob" // Error: Private setter

        /*
         * Example 4: Top-Level Declarations
         */
        println("\n=== Top-Level Declarations ===")
        println("App Version: $APP_VERSION") // Accessing public property
        // Prints: 1.0.0
        logAppInfo() // Accessing internal function
        // Prints: App Version: 1.0.0
        internalLog("Test log") // Accessing private function (same file)
        // Prints: [Internal] Test log
    }
}

// Main function to run the demonstration
fun main() {
    // Create an instance of VisibilityModifiersDemo and run the demonstration
    println("=== Visibility Modifiers Demo ===")
    VisibilityModifiersDemo().demonstrate()
}