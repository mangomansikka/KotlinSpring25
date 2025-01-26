data class Student1(val name: String, val studentNumber: Int, val credits: Int = 123) {
    var stNum = 0

    fun doStuff(points : Int) {

        if ((1..15).contains(points))
            this.stNum += points
    }

    override fun toString(): String {
        return "$name, $studentNumber, $credits"
    }

}

val students = (1..10).map { Student1("John", it) }
students


students.forEach {it.doStuff((1..15).random())}
students.sumOf {it.stNum}.toDouble() / students.size


data class Student2(val name: String, val studentNumber: Int, val credits: Int = 123) {
    val results: MutableList<Pair<Int, Int>> = mutableListOf()

    fun register(course: Pair<Int, Int>) {
        if ((1..15).contains(course.first) && (1..5).contains(course.second))
            results.add(course)
    }
}

// map loops as many times as the range is defined
val students2 = (1..10).map { Student2("John", it) }

(1..10).forEach {students2.forEach { it.register((1..15).random() to (1..5).random()) }}

students2[0].results

// painotettu keskiarvo
students2[0].results
students2[0].results.sumOf { it.first * it.second }.toDouble() / students2[0].results.sumOf { it.first }

