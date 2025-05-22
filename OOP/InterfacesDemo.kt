package Kotlin.OOP// This file demonstrates Kotlin's Object-Oriented Programming (OOP) concept of Interfaces,
// with comparisons to Java for clarity, especially for a Java-familiar audience.
// All explanations are provided within comments for learning purposes.

// Class to demonstrate interfaces with practical examples
class InterfacesDemo {
    /*
     * INTERFACES OVERVIEW
     * 
     * Definition (Kotlin):
     * - An interface is a contract that defines properties and methods that implementing classes must provide.
     * - Declared using the `interface` keyword (e.g., `interface Clickable`).
     * - Can contain:
     *   - Abstract properties and methods (no implementation, implicitly abstract).
     *   - Default implementations for methods (since Kotlin 1.0, similar to Java 8+).
     *   - Constants (like Java’s `static final` fields).
     * - Classes implement interfaces using a colon (`:`), e.g., `class Button : Clickable`.
     * - Kotlin interfaces are implicitly `open` for implementation (no `open` keyword needed).
     * 
     * Java Equivalent:
     * - Identical to Java’s interfaces (e.g., `interface Clickable { void onClick(); }`).
     * - Java interfaces before Java 8 could only have abstract methods; since Java 8, they support `default` methods (like Kotlin’s default implementations).
     * - Kotlin’s interface properties (e.g., `val name: String`) are like Java’s abstract getter methods (e.g., `String getName();`).
     * 
     * Key Points:
     * - A class can implement multiple interfaces (e.g., `class Button : Clickable, Focusable`).
     * - Implementing classes must provide implementations for abstract members or use default implementations.
     * - Use `override` to implement or override interface members.
     * - Interfaces cannot have state (backing fields), but properties can have getters.
     * - Use `super<Interface>.method()` to call a specific interface’s default method, like Java’s `Interface.super.method()`.
     * 
     * Use Cases (Android Context):
     * - Defining UI behaviors (e.g., `Clickable` for buttons, `Focusable` for input fields).
     * - Modeling app behaviors (e.g., `Loggable` for logging entities).
     * - Standardizing contracts in Android apps (e.g., `Serializable` for data transfer).
     * 
     * Nuances:
     * - Interfaces are best for “can-do” relationships (e.g., “can be clicked”), unlike abstract classes for “is-a” relationships.
     * - Kotlin’s null safety applies to interface properties/methods (e.g., `String?` for nullable).
     * - Multiple interface inheritance avoids the diamond problem (unlike class-based multiple inheritance, not supported in Kotlin/Java).
     * - Compared to Java, Kotlin interfaces are more concise (e.g., no explicit `public` or getter/setter boilerplate).
     */

    /*
     * EXAMPLE 1: BASIC INTERFACE FOR UI INTERACTIONS
     * 
     * Context:
     * - Modeling an Android-like UI interaction.
     * - A `Clickable` interface defines a contract for clickable components (e.g., Button).
     */

    // Interface with abstract method
    interface Clickable {
        // Abstract method (no implementation)
        fun onClick()
        
        // Abstract property (must be implemented)
        val clickDescription: String
    }

    // Class implementing the interface
    class Button(val id: Int, var text: String) : Clickable {
        override val clickDescription: String
            get() = "Button '$text' with ID: $id"
        
        override fun onClick() {
            println("Button '$text' clicked!")
        }
        
        // Additional method
        fun updateText(newText: String) {
            text = newText
            println("Button text updated to: $text")
        }
    }

    /*
     * EXAMPLE 2: INTERFACE WITH DEFAULT IMPLEMENTATION
     * 
     * Context:
     * - Modeling a focusable UI component for an Android app.
     * - A `Focusable` interface with a default implementation to reduce boilerplate.
     */

    interface Focusable {
        // Abstract property
        val focusState: Boolean
        
        // Abstract method
        fun gainFocus()
        
        // Default implementation
        fun loseFocus() {
            println("Lost focus (default implementation)")
        }
    }

    // Class implementing Focusable
    class TextField(val id: Int, var content: String) : Focusable {
        override val focusState: Boolean = false // Simplified, could be dynamic
        
        override fun gainFocus() {
            println("TextField ID: $id gained focus, Content: $content")
        }
        
        // Optionally override default implementation
        override fun loseFocus() {
            println("TextField ID: $id lost focus, clearing content")
            content = ""
        }
    }

    /*
     * EXAMPLE 3: MULTIPLE INTERFACE IMPLEMENTATION
     * 
     * Context:
     * - Modeling a smart UI component that is both clickable and focusable.
     * - Demonstrates multiple interface inheritance and resolving conflicts.
     */

    // Class implementing multiple interfaces
    class SmartButton(val id: Int, var label: String) : Clickable, Focusable {
        override val clickDescription: String = "SmartButton '$label' with ID: $id"
        
        override val focusState: Boolean = true // Simplified
        
        override fun onClick() {
            println("SmartButton '$label' clicked!")
        }
        
        override fun gainFocus() {
            println("SmartButton ID: $id gained focus")
        }
        
        // Use default loseFocus from Focusable
    }

    /*
     * EXAMPLE 4: INTERFACE WITH CONSTANT AND PRACTICAL ANDROID USE CASE
     * 
     * Context:
     * - Modeling a loggable entity for an Android app (e.g., logging user actions).
     * - Includes a constant, like Java’s `static final`.
     */

    interface Loggable {
        // Constant, like Java’s `static final String DEFAULT_TAG`
        val DEFAULT_TAG: String
            get() = "APP_LOG"
        
        // Abstract method
        fun log(message: String)
        
        // Default implementation
        fun logError(error: String) {
            println("[${DEFAULT_TAG}] Error: $error")
        }
    }

    // Class implementing Loggable
    class UserAction(val actionId: Int, val actionName: String) : Loggable {
        override fun log(message: String) {
            println("[${DEFAULT_TAG}] Action: $actionName, Message: $message")
        }
    }

    // Demonstration function to showcase interfaces
    fun demonstrate() {
        println("=== Interfaces Demo ===")

        /*
         * Example 1: Basic Interface (Clickable)
         */
        println("\n=== Clickable Interface ===")
        val button = Button(id = 101, text = "Click Me")
        println("Button Description: ${button.clickDescription}")
        // Prints: Button 'Click Me' with ID: 101
        button.onClick()
        // Prints: Button 'Click Me' clicked!
        button.updateText("Submit")
        // Prints: Button text updated to: Submit

        /*
         * Example 2: Interface with Default Implementation (Focusable)
         */
        println("\n=== Focusable Interface ===")
        val textField = TextField(id = 102, content = "Enter text")
        println("TextField Focus State: ${textField.focusState}")
        // Prints: TextField Focus State: false
        textField.gainFocus()
        // Prints: TextField ID: 102 gained focus, Content: Enter text
        textField.loseFocus()
        // Prints: TextField ID: 102 lost focus, clearing content

        /*
         * Example 3: Multiple Interface Implementation (SmartButton)
         */
        println("\n=== Multiple Interfaces (SmartButton) ===")
        val smartButton = SmartButton(id = 103, label = "Smart Click")
        println("SmartButton Click Description: ${smartButton.clickDescription}")
        // Prints: SmartButton 'Smart Click' with ID: 103
        smartButton.onClick()
        // Prints: SmartButton 'Smart Click' clicked!
        smartButton.gainFocus()
        // Prints: SmartButton ID: 103 gained focus
        smartButton.loseFocus()
        // Prints: Lost focus (default implementation)

        /*
         * Example 4: Interface with Constant (Loggable)
         */
        println("\n=== Loggable Interface ===")
        val userAction = UserAction(actionId = 1, actionName = "Login")
        userAction.log("User logged in successfully")
        // Prints: [APP_LOG] Action: Login, Message: User logged in successfully
        userAction.logError("Invalid credentials")
        // Prints: [APP_LOG] Error: Invalid credentials
    }
}

// Main function to run the demonstration
fun main() {
    // Create an instance of InterfacesDemo and run the demonstration
    println("=== Interfaces Demo ===")
    InterfacesDemo().demonstrate()
}