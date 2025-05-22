package Kotlin.DesignPatterns.Builder_Pattern// This file demonstrates the Builder Design Pattern in Kotlin, with Java comparisons.

// Product class
data class UserProfile(
    val name: String,
    val email: String?,
    val age: Int?
) {
    /*
     * BUILDER PATTERN OVERVIEW
     * 
     * Definition:
     * - Allows constructing complex objects step-by-step, with a fluent interface.
     * - In Kotlin, implemented with a `Builder` class and chained methods.
     * 
     * Java Equivalent:
     * - In Java, a `Builder` inner class with methods like `withName(String name)` and a `build()` method.
     * - Kotlin’s data classes and concise syntax make builders simpler.
     * 
     * Use Case (Android):
     * - Building user profiles with optional fields for a registration form.
     * 
     * Nuances:
     * - Kotlin’s default arguments can reduce the need for builders, but builders are useful for complex objects.
     * - Ensures immutability and validates object state before creation.
     */
    
    class Builder {
        private var name: String = "Guest"
        private var email: String? = null
        private var age: Int? = null
        
        fun name(name: String) = apply { this.name = name }
        fun email(email: String?) = apply { this.email = email }
        fun age(age: Int?) = apply { this.age = age }
        
        fun build(): UserProfile {
            return UserProfile(name, email, age)
        }
    }
}

// Demonstration function
fun demonstrateBuilder() {
    println("=== Builder Pattern Demo ===")
    val profile = UserProfile.Builder()
        .name("Alice")
        .email("alice@example.com")
        .age(30)
        .build()
    println("Profile: $profile")
    // Prints: Profile: UserProfile(name=Alice, email=alice@example.com, age=30)
}

fun main(){
    demonstrateBuilder()
}