package Kotlin.DesignPatterns.Observer_Pattern

import Kotlin.DesignPatterns.Builder_Pattern.demonstrateBuilder

// This file demonstrates the Observer Design Pattern in Kotlin, with Java comparisons.

// Demonstration function
fun demonstrateObserver() {
    println("=== Observer Pattern Demo ===")
    val eventManager = EventManager()
    val component1 = UIComponent("Button")
    val component2 = UIComponent("TextView")
    
    eventManager.addObserver(component1)
    eventManager.addObserver(component2)
    eventManager.notify("Data updated")
    // Prints:
    // Button received event: Data updated
    // TextView received event: Data updated
}

fun main(){
    demonstrateObserver()
}