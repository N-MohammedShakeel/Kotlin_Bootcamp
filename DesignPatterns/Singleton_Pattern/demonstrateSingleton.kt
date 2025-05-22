package Kotlin.DesignPatterns.Singleton_Pattern

// Demonstration function
fun demonstrateSingleton() {
    println("=== Singleton Pattern Demo ===")
    DatabaseConnection.connect()
    DatabaseConnection.query("SELECT * FROM users")
    // Prints:
    // Database connected: true
    // Executing query: SELECT * FROM users
}

fun main(){
    demonstrateSingleton()
}