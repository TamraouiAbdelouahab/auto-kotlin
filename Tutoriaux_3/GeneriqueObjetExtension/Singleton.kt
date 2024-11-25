object StudentProgress {
    var total: Int = 10
    var answered: Int = 3
}

fun main()
{
    println(StudentProgress.total)
    println("${StudentProgress.answered} of ${StudentProgress.total} answered.")

}