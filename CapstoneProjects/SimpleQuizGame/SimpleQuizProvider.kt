package Kotlin.CapstoneProjects.SimpleQuizGame

// Concrete quiz provider
class SimpleQuizProvider : QuizProvider {
    override fun getQuestions(): List<Question> {
        return listOf(
            Question.create(1, "What is the capital of France?", listOf("Paris", "London", "Berlin", "Madrid"), "Paris"),
            Question.create(2, "Which planet is known as the Red Planet?", listOf("Jupiter", "Mars", "Venus", "Mercury"), "Mars")
        )
    }
}