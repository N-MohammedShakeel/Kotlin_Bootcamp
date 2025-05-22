package Kotlin.CapstoneProjects.SimpleQuizGame

// Class to manage the quiz game
class QuizGame(private val provider: QuizProvider) {
    /*
     * Class Overview:
     * - Manages quiz logic with private state.
     * - Java Equivalent: A class with private fields and public methods.
     */
    
    private var score = 0
    
    fun start() {
        val questions = provider.getQuestions()
        if (questions.isEmpty()) {
            println("No questions available.")
            return
        }
        
        println("\n=== Welcome to the Quiz Game ===")
        questions.forEachIndexed { index, question ->
            println("\nQuestion ${index + 1}: ${question.text}")
            question.options.forEachIndexed { i, option -> println("${i + 1}. $option") }
            print("Enter your answer (1-${question.options.size}): ")
            
            val answer = readLine()?.toIntOrNull()?.minus(1)
            if (answer != null && answer in 0 until question.options.size) {
                if (question.isCorrect(answer)) {
                    score++
                    println("Correct!")
                } else {
                    println("Wrong! Correct answer: ${question.options[question.correctAnswerIndex]}")
                }
            } else {
                println("Invalid input. Skipping question.")
            }
        }
        
        println("\n=== Quiz Complete ===")
        println("Your score: $score/${questions.size}")
    }
}

// Main function to run the app
fun main() {
    /*
     * Main Function:
     * - Initializes and starts the quiz game.
     * - Java Equivalent: A `main` method with game logic.
     */
    
    val provider = SimpleQuizProvider()
    val game = QuizGame(provider)
    game.start()
}