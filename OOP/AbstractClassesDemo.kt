package Kotlin.OOP// This file demonstrates Kotlin's Object-Oriented Programming (OOP) concept of Abstract Classes,
// with comparisons to Java for clarity, especially for a Java-familiar audience.
// All explanations are provided within comments for learning purposes.

// Class to demonstrate abstract classes with practical examples
class AbstractClassesDemo {
    /*
     * ABSTRACT CLASSES OVERVIEW
     * 
     * Definition (Kotlin):
     * - An abstract class is a class that cannot be instantiated directly and is meant to be inherited by subclasses.
     * - Declared using the `abstract` keyword (e.g., `abstract class Base`).
     * - Can contain:
     *   - Abstract members (properties/methods without implementation, marked `abstract`).
     *   - Concrete members (properties/methods with implementation).
     * - Subclasses must provide implementations for all abstract members unless they are also abstract.
     * - In Kotlin, abstract classes are implicitly `open` for inheritance (no need for `open` keyword).
     * 
     * Java Equivalent:
     * - Identical to Java’s abstract classes (e.g., `abstract class Base {}`).
     * - In Java, you also use `abstract` for classes and members (e.g., `abstract void method();`).
     * - Kotlin’s abstract classes are like Java’s, but Kotlin simplifies syntax (e.g., no explicit `public` needed, null safety).
     * 
     * Key Points:
     * - Cannot create instances of abstract classes (e.g., `Base()` is invalid).
     * - Abstract members must be overridden in non-abstract subclasses using the `override` keyword.
     * - Concrete members can be inherited as-is or overridden if marked `open`.
     * - Use `super` to call parent class methods, like Java’s `super`.
     * 
     * Use Cases (Android Context):
     * - Defining base UI components (e.g., an abstract `View` class for `Button`, `TextView`).
     * - Modeling entity hierarchies (e.g., an abstract `Vehicle` for `Car`, `Bike`).
     * - Enforcing common behavior in Android apps (e.g., an abstract `Fragment` with shared logic).
     * 
     * Nuances:
     * - Abstract classes are useful for “is-a” relationships with shared code, unlike interfaces (which focus on “can-do”).
     * - Kotlin’s null safety applies to abstract properties/methods (e.g., `String?` for nullable).
     * - Prefer abstract classes when you need concrete implementations or state; use interfaces for pure contracts.
     * - Compared to Java, Kotlin reduces boilerplate (e.g., no need for explicit getter/setter for properties).
     */

    /*
     * EXAMPLE 1: ABSTRACT CLASS FOR UI COMPONENTS
     * 
     * Context:
     * - Modeling an Android-like UI component hierarchy.
     * - An abstract `View` class defines common properties/methods, with concrete `Button` and `TextView` subclasses.
     */

    // Abstract class (cannot be instantiated)
    abstract class View(val id: Int) {
        // Abstract property (must be implemented by subclasses)
        abstract val description: String
        
        // Abstract method (must be implemented)
        abstract fun draw()
        
        // Concrete property
        var isVisible: Boolean = true
        
        // Concrete method
        fun toggleVisibility() {
            isVisible = !isVisible
            println("View ID: $id visibility set to: $isVisible")
        }
    }

    // Concrete subclass: Button
    open class Button(id: Int, var text: String) : View(id) {
        // Implement abstract property
        override val description: String
            get() = "Button with text: $text"
        
        // Implement abstract method
        override fun draw() {
            println("Drawing Button: ID=$id, Text='$text', Visible=$isVisible")
        }
        
        // Additional method
        fun click() {
            println("Button '$text' clicked!")
        }
    }

    // Concrete subclass: TextView
    class TextView(id: Int, var content: String) : View(id) {
        override val description: String = "TextView with content: $content"
        
        override fun draw() {
            println("Drawing TextView: ID=$id, Content='$content', Visible=$isVisible")
        }
        
        fun updateContent(newContent: String) {
            content = newContent
            println("TextView content updated to: $content")
        }
    }

    /*
     * EXAMPLE 2: ABSTRACT CLASS WITH OVERRIDABLE CONCRETE MEMBERS
     * 
     * Context:
     * - Modeling a vehicle hierarchy for an Android app (e.g., a transport app).
     * - An abstract `Vehicle` class with abstract and concrete members, overridden in `Car`.
     */

    abstract class Vehicle(val model: String) {
        // Abstract property
        abstract val maxSpeed: Int
        
        // Abstract method
        abstract fun startEngine()
        
        // Concrete property, open for overriding
        open val fuelType: String = "Unknown"
        
        // Concrete method, open for overriding
        open fun describe() {
            println("Vehicle: Model=$model, Fuel=$fuelType")
        }
    }

    class Car(model: String, val isElectric: Boolean) : Vehicle(model) {
        override val maxSpeed: Int = 200
        
        override fun startEngine() {
            println("Starting $model’s ${if (isElectric) "electric motor" else "gas engine"}")
        }
        
        override val fuelType: String
            get() = if (isElectric) "Electric" else "Gasoline"
        
        override fun describe() {
            // Call parent’s describe, like Java’s super.describe()
            super.describe()
            println("Car: MaxSpeed=$maxSpeed, Electric=$isElectric")
        }
    }

    /*
     * EXAMPLE 3: ABSTRACT CLASS IN MULTILEVEL INHERITANCE
     * 
     * Context:
     * - Extending the UI component example to show multilevel inheritance.
     * - `SmartButton` inherits from `Button`, which inherits from `View`.
     * - Demonstrates how abstract class members propagate through the hierarchy.
     */

    class SmartButton(id: Int, text: String, var isInteractive: Boolean) : Button(id, text) {
        override val description: String = "SmartButton: Text='$text', Interactive=$isInteractive"
        
        override fun draw() {
            super.draw()
            println("Enhancing SmartButton: Interactive=$isInteractive")
        }
        
        fun toggleInteractive() {
            isInteractive = !isInteractive
            println("SmartButton interactivity set to: $isInteractive")
        }
    }

    // Demonstration function to showcase abstract classes
    fun demonstrate() {
        println("=== Abstract Classes Demo ===")

        /*
         * Example 1: UI Components
         */
        println("\n=== UI Components (Abstract View) ===")
        // val view = View(1) // Error: Cannot instantiate abstract class
        
        // Button instance
        val button = Button(id = 101, text = "Click Me")
        println("Button Description: ${button.description}")
        // Prints: Button with text: Click Me
        button.draw()
        // Prints: Drawing Button: ID=101, Text='Click Me', Visible=true
        button.toggleVisibility()
        // Prints: View ID: 101 visibility set to: false
        button.click()
        // Prints: Button 'Click Me' clicked!

        // TextView instance
        val textView = TextView(id = 102, content = "Hello")
        println("TextView Description: ${textView.description}")
        // Prints: TextView with content: Hello
        textView.draw()
        // Prints: Drawing TextView: ID=102, Content='Hello', Visible=true
        textView.updateContent("Welcome")
        // Prints: TextView content updated to: Welcome

        /*
         * Example 2: Vehicle Hierarchy
         */
        println("\n=== Vehicle Hierarchy ===")
        val car = Car(model = "Tesla Model 3", isElectric = true)
        car.startEngine()
        // Prints: Starting Tesla Model 3’s electric motor
        car.describe()
        // Prints:
        // Vehicle: Model=Tesla Model 3, Fuel=Electric
        // Car: MaxSpeed=200, Electric=true

        /*
         * Example 3: Multilevel Inheritance
         */
        println("\n=== Multilevel Inheritance (SmartButton) ===")
        val smartButton = SmartButton(id = 103, text = "Smart Click", isInteractive = true)
        println("SmartButton Description: ${smartButton.description}")
        // Prints: SmartButton: Text='Smart Click', Interactive=true
        smartButton.draw()
        // Prints:
        // Drawing Button: ID=103, Text='Smart Click', Visible=true
        // Enhancing SmartButton: Interactive=true
        smartButton.toggleInteractive()
        // Prints: SmartButton interactivity set to: false
    }
}

// Main function to run the demonstration
fun main() {
    // Create an instance of AbstractClassesDemo and run the demonstration
    println("=== Abstract Classes Demo ===")
    AbstractClassesDemo().demonstrate()
}