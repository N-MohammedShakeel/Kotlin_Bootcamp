package Kotlin.DesignPatterns.Observer_Pattern

// Concrete observer
class UIComponent(val name: String) : ObserverInterface {
    override fun update(event: String) {
        println("$name received event: $event")
    }
}