class Major(name: String) {
    var name: String = ""
    var students: MutableList<Student> = mutableListOf()

    init {
        this.name = name
    }

    fun addStudent(student: Student) {
        students.add(student)
    }

    fun stats(): Triple<Double, Double, Double> {
        var total = 0.0
        var maxAverage = Double.MIN_VALUE
        var minAverage = Double.MAX_VALUE

        for (student in students) {
            val studentAverage = student.weightedAverage()
            total += studentAverage

            if (studentAverage < minAverage) minAverage = studentAverage
            if (studentAverage > maxAverage) maxAverage = studentAverage
        }
        return Triple(minAverage, maxAverage, (total / students.size))
    }

    fun statsCourse(courseName: String): Triple<Double, Double, Double> {
        var total = 0.0
        var totalCredits = 0.0
        var maxGrade = Double.MIN_VALUE
        var minGrade = Double.MAX_VALUE

        for (student in students) {
            for (course in student.courses) {
                if (course.name == courseName) {
                    total += course.grade * course.credits
                    totalCredits += course.credits

                    if (course.grade > maxGrade) {
                        maxGrade = course.grade
                    }

                    if (course.grade < minGrade) {
                        minGrade = course.grade
                    }
                }
            }
        }
        return Triple(minGrade, maxGrade, (total / totalCredits))
    }
}