package AdvancedKotlin.Generics

// Class to demonstrate generic classes, functions, and interfaces
class GenericDemo<T : Task> {
    /*
     * Generics: Generic Classes
     * - Definition: Classes parameterized by a type `T`, allowing reusable code for different types.
     * - Why Important? Enables type-safe, flexible code (e.g., collections like `List<T>`).
     * - Java Equivalent: `class GenericDemo<T> { ... }`, but Kotlin’s syntax is more concise.
     * - Use Case: A generic ViewModel in Android handling different data types (e.g., `Task`, `User`).
     * - From Your Knowledge: Builds on collections (`List<T>`) and OOP (type safety).
     * - Note: `T : Task` is a type constraint (see ReifiedTypeDemo).
     */

    private val items = mutableListOf<T>()

    // Generic function to add an item
    fun addItem(item: T) {
        /*
         * Generics: Generic Functions
         * - Definition: Functions with type parameters, allowing flexible input/output types.
         * - Why Important? Reduces code duplication while maintaining type safety.
         * - Java Equivalent: `<T> void addItem(T item)`.
         * - Use Case: Adding items to a generic Repository in Android.
         */
        items.add(item)
        println("Added: $item")
    }

    // Generic interface for processing items
    interface Processor<T> {
        fun process(item: T): String
        /*
         * Generics: Generic Interfaces
         * - Definition: Interfaces with type parameters, defining contracts for different types.
         * - Why Important? Allows polymorphic behavior for generic types.
         * - Java Equivalent: `interface Processor<T> { String process(T item); }`.
         * - Use Case: A generic event handler in Android (e.g., processing UI events).
         */
    }

    // Function using generic interface
    fun processItems(processor: Processor<T>) {
        items.forEach { println(processor.process(it)) }
    }

    fun demonstrate() {
        /*
         * Generics Context:
         * - Demonstrates generic class, function, and interface usage.
         * - Creates a `GenericDemo<BasicTask>` and processes tasks.
         */
        println("=== Generic Class, Function, Interface Demo ===")
        val demo = GenericDemo<BasicTask>()
        demo.addItem(BasicTask(1, "Write code"))
        demo.addItem(BasicTask(2, "Test app"))
        demo.processItems(object : Processor<BasicTask> {
            override fun process(item: BasicTask) = "Processed: ${item.title}"
        })
    }
}