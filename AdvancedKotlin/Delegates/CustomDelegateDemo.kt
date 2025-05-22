package AdvancedKotlin.Delegates

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

// Class to demonstrate custom delegates
class CustomDelegateDemo {
    /*
     * Delegates: Custom Delegates
     * - Definition: Custom delegates implement `ReadWriteProperty` or `ReadOnlyProperty` to define
     *   reusable property behavior (e.g., logging, validation).
     * - Why Important? Encapsulates complex property logic for reuse across classes.
     * - Java Equivalent: Custom getter/setter logic or proxy classes, but Kotlin’s delegate syntax
     *   is more elegant.
     * - Use Case: Logging property changes in a ViewModel or validating task properties.
     * - From Your Knowledge: Leverages OOP (encapsulation) and functional programming (lambdas).
     */
    
    // Custom delegate for logging property changes
    class LoggingDelegate<T>(private var value: T) : ReadWriteProperty<Any?, T> {
        /*
         * Custom Delegate Context:
         * - Implements `ReadWriteProperty` to log get/set operations.
         * - Stores the property value and logs changes with property name.
         * - Java Equivalent: A proxy class with logging in getters/setters.
         */
        override fun getValue(thisRef: Any?, property: KProperty<*>): T {
            println("Getting ${property.name}: $value")
            return value
        }
        
        override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
            println("Setting ${property.name} from ${this.value} to $value")
            this.value = value
        }
    }
    
    // Property using custom delegate
    var taskDescription: String by LoggingDelegate("Initial Description")
    
    fun demonstrate() {
        /*
         * Custom Delegate Context:
         * - Shows `LoggingDelegate` logging get/set operations for `taskDescription`.
         */
        println("\n=== Custom Delegate Demo ===")
        println(taskDescription) // Triggers get
        taskDescription = "Updated Description" // Triggers set
        println(taskDescription) // Triggers get
    }
}