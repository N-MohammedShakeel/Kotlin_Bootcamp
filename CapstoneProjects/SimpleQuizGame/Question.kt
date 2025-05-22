package Kotlin.CapstoneProjects.SimpleQuizGame

// Data class for a quiz question
data class Question(
    val id: Int,
    val text: String,
    val options: List<String>,
    val correctAnswerIndex: Int
) {
    /*
     * Data Class Overview:
     * - Uses `data class` for automatic `toString`, `equals`, `hashCode`.
     * - Java Equivalent: A POJO with fields and manual method implementations.
     * - Private `correctAnswerIndex` for encapsulation.
     */
    
    // Public method to check answer
    fun isCorrect(answerIndex: Int): Boolean {
        return answerIndex == correctAnswerIndex
    }
    
    companion object {
        // Factory method, like Java’s `public static Question create(...)`
        fun create(id: Int, text: String, options: List<String>, correctAnswer: String): Question {
            val correctIndex = options.indexOf(correctAnswer)
            if (correctIndex == -1) throw IllegalArgumentException("Correct answer not in options")
            return Question(id, text, options, correctIndex)
        }
    }
}