package Kotlin.DesignPatterns.Observer_Pattern

// Subject class
class EventManager {
    /*
     * OBSERVER PATTERN OVERVIEW
     * 
     * Definition:
     * - Defines a one-to-many dependency where multiple observers are notified of state changes.
     * - In Kotlin, implemented with a list of observers and notification methods.
     * 
     * Java Equivalent:
     * - In Java, similar to `java.util.Observable` and `Observer` or custom implementations with a list of observers.
     * - Kotlin’s functional style (e.g., lambdas) can simplify observer registration.
     * 
     * Use Case (Android):
     * - Notifying UI components of data changes (e.g., LiveData in Android).
     * 
     * Nuances:
     * - Ensures loose coupling between subject and observers.
     * - Kotlin’s delegates or coroutines can enhance observer patterns in Android.
     */
    
    private val observers = mutableListOf<ObserverInterface>()
    
    fun addObserver(observer: ObserverInterface) {
        observers.add(observer)
    }
    
    fun removeObserver(observer: ObserverInterface) {
        observers.remove(observer)
    }
    
    fun notify(event: String) {
        observers.forEach { it.update(event) }
    }
}