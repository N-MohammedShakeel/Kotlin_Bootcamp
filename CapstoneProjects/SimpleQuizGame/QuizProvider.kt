package Kotlin.CapstoneProjects.SimpleQuizGame

// Interface for quiz providers
interface QuizProvider {
    /*
     * Interface Overview:
     * - Defines a contract for providing questions.
     * - Java Equivalent: A Java interface (e.g., `interface QuizProvider { List<Question> getQuestions(); }`).
     */
    fun getQuestions(): List<Question>
}