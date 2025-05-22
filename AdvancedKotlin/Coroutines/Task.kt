package AdvancedKotlin.Coroutines

// Data class for a task, leveraging your OOP knowledge
data class Task(val id: Int, val title: String, val priority: Int) {
    /*
     * Coroutines Context:
     * - Models tasks for async processing, used across coroutine demos.
     * - Java Equivalent: A POJO with fields, getters, setters, and manual method implementations.
     * - From Your Knowledge: Builds on data classes for immutability and encapsulation (OOP).
     * - Android Relevance: Represents data (e.g., to-do items) fetched asynchronously in a ViewModel.
     */
    
    companion object {
        /*
         * Coroutines Context:
         * - Factory method for task creation, ensuring controlled instantiation.
         * - Java Equivalent: `public static Task create(...)`.
         * - From Your Knowledge: Similar to factory design pattern.
         */
        fun create(id: Int, title: String, priority: Int): Task {
            return Task(id, title, priority)
        }
    }
}