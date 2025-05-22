package Kotlin.OOP// This file demonstrates Kotlin's Object-Oriented Programming (OOP) concept of Inheritance,
// including its types (Single, Hierarchical, Multilevel), with comparisons to Java for clarity.
// All explanations are provided within comments for learning purposes.

// Class to demonstrate inheritance with practical examples
class InheritanceDemo {
    /*
     * INHERITANCE OVERVIEW
     * 
     * Definition (Kotlin):
     * - Inheritance allows a class (subclass/child) to inherit properties and methods from another class (superclass/parent).
     * - In Kotlin, classes are `final` by default (cannot be inherited). Use the `open` keyword to allow inheritance.
     * - Declared using a colon (`:`), e.g., `class Child : Parent()`.
     * 
     * Java Equivalent:
     * - In Java, inheritance is similar, using `extends` (e.g., `class Child extends Parent`).
     * - Java classes are inheritable by default unless marked `final`, unlike Kotlin’s default `final`.
     * - Kotlin’s `open` is like Java’s absence of `final` on a class.
     * 
     * Types of Inheritance:
     * - Single Inheritance: One class inherits from one parent class.
     * - Hierarchical Inheritance: Multiple classes inherit from the same parent class.
     * - Multilevel Inheritance: A class inherits from a parent, which itself inherits from another parent.
     * - Note: Kotlin (like Java) does not support Multiple Inheritance (a class inheriting from multiple parents) to avoid complexity. Use interfaces for similar needs (covered later).
     * 
     * Key Points:
     * - Subclasses inherit all non-private members (properties, methods) of the parent.
     * - Methods and properties in the parent must be `open` to be overridden in the child.
     * - Use `override` keyword in the child to redefine parent methods or properties.
     * - Use `super` to call parent class methods or constructors, like Java’s `super`.
     * 
     * Use Cases (Android Context):
     * - Modeling UI components (e.g., a `Button` inheriting from a `View`).
     * - Creating entity hierarchies (e.g., `Employee` as a base for `Manager` and `Developer`).
     * - Reusing code in Android apps (e.g., a base `Fragment` class for common logic).
     * 
     * Nuances:
     * - Overriding requires explicit `open` and `override` keywords, reducing accidental overrides compared to Java.
     * - Kotlin’s null safety applies to inherited properties and methods.
     * - Prefer composition over inheritance for flexibility, unless a clear “is-a” relationship exists.
     */

    /*
     * SINGLE INHERITANCE
     * 
     * Definition:
     * - A single subclass inherits from one superclass.
     * - Simplest form of inheritance, common in most OOP designs.
     * 
     * Java Equivalent:
     * - Same as Java’s single class extending another (e.g., `class Dog extends Animal`).
     * 
     * Example:
     * - A `Button` class inheriting from a `View` class, modeling an Android UI component.
     */

    // Parent class (open to allow inheritance)
    open class View(val id: Int) {
        // Open property for overriding
        open val description: String = "Generic View"
        
        // Open method for overriding
        open fun draw() {
            println("Drawing View with ID: $id, Description: $description")
        }
    }

    // Child class (single inheritance)
    open class Button(id: Int, var text: String) : View(id) {
        // Override property
        override val description: String = "Button with text: $text"
        
        // Override method
        override fun draw() {
            // Call parent’s draw method, like Java’s super.draw()
            super.draw()
            println("Rendering Button with text: $text")
        }

        // Additional method specific to Button
        fun click() {
            println("Button '$text' clicked!")
        }
    }

    /*
     * HIERARCHICAL INHERITANCE
     * 
     * Definition:
     * - Multiple subclasses inherit from the same superclass.
     * - Each subclass customizes or extends the parent’s behavior.
     * 
     * Java Equivalent:
     * - Same as Java, where multiple classes extend one parent (e.g., `Dog` and `Cat` extend `Animal`).
     * 
     * Example:
     * - `Manager` and `Developer` classes inheriting from an `Employee` class, modeling an HR app.
     */

    // Parent class
    open class Employee(val name: String, val salary: Double) {
        open fun work() {
            println("$name is working. Salary: $$salary")
        }
    }

    // Child class 1
    class Manager(name: String, salary: Double, var department: String) : Employee(name, salary) {
        override fun work() {
            println("$name is managing the $department department. Salary: $$salary")
        }
    }

    // Child class 2
    class Developer(name: String, salary: Double, var programmingLanguage: String) : Employee(name, salary) {
        override fun work() {
            println("$name is coding in $programmingLanguage. Salary: $$salary")
        }
    }

    /*
     * MULTILEVEL INHERITANCE
     * 
     * Definition:
     * - A chain of inheritance where a class inherits from a parent, which itself inherits from another parent.
     * - Forms a hierarchy (e.g., Grandparent -> Parent -> Child).
     * 
     * Java Equivalent:
     * - Same as Java’s multilevel inheritance (e.g., `Puppy extends Dog extends Animal`).
     * 
     * Example:
     * - `SmartButton` inheriting from `Button`, which inherits from `View`, modeling an advanced Android UI component.
     */

    // Child class inheriting from Button
    class SmartButton(id: Int, text: String, var isInteractive: Boolean) : Button(id, text) {
        override val description: String = "SmartButton with text: $text, Interactive: $isInteractive"
        
        override fun draw() {
            super.draw()
            println("Rendering SmartButton, Interactive: $isInteractive")
        }

        fun toggleInteractive() {
            isInteractive = !isInteractive
            println("SmartButton interactivity set to: $isInteractive")
        }
    }

    // Demonstration function to showcase all inheritance types
    fun demonstrate() {
        println("=== Inheritance Demo ===")

        /*
         * Single Inheritance Demo
         */
        println("\n=== Single Inheritance ===")
        val button = Button(id = 101, text = "Click Me")
        println("Button Description: ${button.description}")
        // Prints: Button with text: Click Me
        button.draw()
        // Prints:
        // Drawing View with ID: 101, Description: Button with text: Click Me
        // Rendering Button with text: Click Me
        button.click() // Prints: Button 'Click Me' clicked!

        /*
         * Hierarchical Inheritance Demo
         */
        println("\n=== Hierarchical Inheritance ===")
        val manager = Manager(name = "Alice", salary = 80000.0, department = "HR")
        val developer = Developer(name = "Bob", salary = 75000.0, programmingLanguage = "Kotlin")
        manager.work()
        // Prints: Alice is managing the HR department. Salary: $80000.0
        developer.work()
        // Prints: Bob is coding in Kotlin. Salary: $75000.0

        /*
         * Multilevel Inheritance Demo
         */
        println("\n=== Multilevel Inheritance ===")
        val smartButton = SmartButton(id = 102, text = "Smart Click", isInteractive = true)
        println("SmartButton Description: ${smartButton.description}")
        // Prints: SmartButton with text: Smart Click, Interactive: true
        smartButton.draw()
        // Prints:
        // Drawing View with ID: 102, Description: SmartButton with text: Smart Click, Interactive: true
        // Rendering Button with text: Smart Click
        // Rendering SmartButton, Interactive: true
        smartButton.toggleInteractive()
        // Prints: SmartButton interactivity set to: false
    }
}

// Main function to run the demonstration
fun main() {
    // Create an instance of InheritanceDemo and run the demonstration
    println("=== Inheritance Demo ===")
    InheritanceDemo().demonstrate()
}