package Kotlin.CapstoneProjects.GroceryListTracker

// Data class for a grocery item
data class GroceryItem private constructor(
    val id: Int,
    val name: String,
    val quantity: Int,
    var isPurchased: Boolean = false
) {
    /*
     * Data Class Overview:
     * - Uses `data class` for automatic `toString`, `equals`, `hashCode`.
     * - Java Equivalent: A POJO with fields and manual method implementations.
     * - Private constructor for controlled instantiation.
     */
    
    companion object {
        private var lastId = 0
        
        // Factory method, like Java’s `public static GroceryItem create(...)`
        fun create(name: String, quantity: Int): GroceryItem {
            return GroceryItem(++lastId, name, quantity)
        }
    }
    
    // Public method to mark as purchased
    fun purchase() {
        isPurchased = true
    }
}