package Kotlin.CapstoneProjects.GroceryListTracker

// Class to manage the grocery list
class GroceryListManager {
    /*
     * Class Overview:
     * - Encapsulates grocery list with private visibility.
     * - Java Equivalent: A class with a `private List<GroceryItem>` field.
     */
    
    private val items = mutableListOf<GroceryItem>()
    
    // Add a new item
    fun addItem(name: String, quantity: Int) {
        if (name.isBlank() || quantity <= 0) {
            println("Error: Invalid name or quantity.")
            return
        }
        val item = GroceryItem.create(name, quantity)
        items.add(item)
        println("Item added: $item")
    }
    
    // View all items
    fun viewItems() {
        if (items.isEmpty()) {
            println("Grocery list is empty.")
            return
        }
        println("\n=== Grocery List ===")
        items.forEach { println(it) }
    }
    
    // Remove an item by ID
    fun removeItem(id: Int) {
        val item = items.find { it.id == id }
        if (item == null) {
            println("Error: Item with ID $id not found.")
            return
        }
        items.remove(item)
        println("Item removed: $item")
    }
    
    // Mark an item as purchased by ID
    fun markPurchased(id: Int) {
        val item = items.find { it.id == id }
        if (item == null) {
            println("Error: Item with ID $id not found.")
            return
        }
        if (item.isPurchased) {
            println("Item with ID $id is already purchased.")
            return
        }
        item.purchase()
        println("Item purchased: $item")
    }
}

// Main function to run the app
fun main() {
    /*
     * Main Function:
     * - Provides a console-based menu for user interaction.
     * - Java Equivalent: A `main` method with a `Scanner` for input.
     */
    
    val manager = GroceryListManager()
    while (true) {
        println("\n=== Grocery List Tracker ===")
        println("1. Add Item")
        println("2. View Items")
        println("3. Remove Item")
        println("4. Mark Item as Purchased")
        println("5. Exit")
        print("Enter choice (1-5): ")
        
        when (readLine()?.toIntOrNull()) {
            1 -> {
                print("Enter item name: ")
                val name = readLine().orEmpty()
                print("Enter quantity: ")
                val quantity = readLine()?.toIntOrNull() ?: 0
                manager.addItem(name, quantity)
            }
            2 -> manager.viewItems()
            3 -> {
                print("Enter item ID to remove: ")
                val id = readLine()?.toIntOrNull()
                if (id != null) manager.removeItem(id)
                else println("Error: Invalid ID.")
            }
            4 -> {
                print("Enter item ID to mark purchased: ")
                val id = readLine()?.toIntOrNull()
                if (id != null) manager.markPurchased(id)
                else println("Error: Invalid ID.")
            }
            5 -> {
                println("Exiting...")
                break
            }
            else -> println("Error: Invalid choice. Please enter 1-5.")
        }
    }
}