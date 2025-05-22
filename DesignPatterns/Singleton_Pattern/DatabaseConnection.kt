package Kotlin.DesignPatterns.Singleton_Pattern// This file demonstrates the Singleton Design Pattern in Kotlin, with Java comparisons.

// Class implementing the Singleton pattern
object DatabaseConnection {
    /*
     * SINGLETON PATTERN OVERVIEW
     * 
     * Definition:
     * - Ensures a class has only one instance and provides a global access point.
     * - In Kotlin, use `object` declaration for a simple singleton (no class instantiation).
     * 
     * Java Equivalent:
     * - In Java, implemented with a `private` constructor, a `static` instance, and a `public static getInstance()` method (often with lazy initialization or double-checked locking).
     * - Kotlin’s `object` is simpler, automatically thread-safe, and equivalent to a Java static singleton.
     * 
     * Use Case (Android):
     * - Managing a single database connection or shared preferences in an Android app.
     * 
     * Nuances:
     * - Kotlin’s `object` is lazily initialized and thread-safe by default.
     * - Use for global resources; avoid overuse to prevent tight coupling.
     */
    
    // Property
    private var isConnected: Boolean = false
    
    // Method
    fun connect() {
        isConnected = true
        println("Database connected: $isConnected")
    }
    
    fun query(query: String) {
        if (isConnected) {
            println("Executing query: $query")
        } else {
            println("Error: Not connected")
        }
    }
}

