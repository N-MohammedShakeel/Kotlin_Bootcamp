package Kotlin.DesignPatterns.Factory_Pattern

// Concrete products
class EmailNotification : NotificationInterface {
    override fun send(message: String) {
        println("Sending Email: $message")
    }
}

class SMSNotification : NotificationInterface {
    override fun send(message: String) {
        println("Sending SMS: $message")
    }
}