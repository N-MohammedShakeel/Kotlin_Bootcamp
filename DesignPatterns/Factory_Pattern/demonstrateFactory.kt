package Kotlin.DesignPatterns.Factory_Pattern

// Demonstration function
fun demonstrateFactory() {
    println("=== Factory Pattern Demo ===")
    val emailNotification = NotificationFactory.create("email")
    emailNotification.send("Hello via Email")
    // Prints: Sending Email: Hello via Email
    val smsNotification = NotificationFactory.create("sms")
    smsNotification.send("Hello via SMS")
    // Prints: Sending SMS: Hello via SMS
}

fun main(){
    demonstrateFactory()
}