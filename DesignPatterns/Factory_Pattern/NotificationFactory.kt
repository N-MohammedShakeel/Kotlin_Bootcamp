package Kotlin.DesignPatterns.Factory_Pattern// This file demonstrates the Factory Design Pattern in Kotlin, with Java comparisons.





// Factory class
class NotificationFactory {
    /*
     * FACTORY PATTERN OVERVIEW
     * 
     * Definition:
     * - Provides a way to create objects without specifying the exact class, using a factory method.
     * - In Kotlin, often implemented with a companion object or a dedicated factory class.
     * 
     * Java Equivalent:
     * - In Java, typically a `static` factory method or a separate factory class (e.g., `public static Notification create(String type)`).
     * - Kotlin’s companion object simplifies factory methods compared to Java’s `static`.
     * 
     * Use Case (Android):
     * - Creating different notification types (e.g., email, SMS) based on user settings.
     * 
     * Nuances:
     * - Promotes loose coupling by abstracting object creation.
     * - Can be extended with dependency injection frameworks in Android.
     */
    
    companion object {
        fun create(type: String): NotificationInterface {
            return when (type.lowercase()) {
                "email" -> EmailNotification()
                "sms" -> SMSNotification()
                else -> throw IllegalArgumentException("Unknown notification type: $type")
            }
        }
    }
}

