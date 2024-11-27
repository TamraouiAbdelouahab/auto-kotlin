// FillInTheBlankQuestion class
class FillInTheBlankQuestion(
    val questionText: String,
    val answer: String,
    val difficulty: String
){}
// TrueOrFalseQuestion Class
class TrueOrFalseQuestion(
    val questionText: String,
    val answer: Boolean,
    val difficulty: String
){}
// NumericQuestion Class
class NumericQuestion(
    val questionText: String,
    val answer: Int,
    val difficulty: String
){}
class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: String
    
){}
data class Question2<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
    
){
    fun display()
    {
        println("question est : "+questionText+", reponse est : "
        +answer +", difficulty : " + difficulty);
    }
}
enum class Difficulty {
    EASY, MEDIUM, HARD
}
fun main() {
    val question = Question2<String>("Quoth the raven ___", "nevermore", Difficulty.HARD)
    println(question.toString());
    val question1 = Question<String>("Quoth the raven ___", "nevermore", "medium")
    val question2 = Question<Boolean>("The sky is green. True or false", false, "easy")
    val question3 = Question<Int>("How many days are there between full moons?", 28, "hard")
    println(question1.answer)
    println(question2.answer)
    println(question3.answer)
}