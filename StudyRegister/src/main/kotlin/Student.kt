class Student(name : String, age: Int) : Human(name, age){
    var courses: MutableList<CourseRecord> = mutableListOf()

    init {
        this.name = name
        this.age = age
    }

    fun addCourse(course: CourseRecord) {
        courses.add(course)
    }

    fun weightedAverage(): Double {
        var totalWeightedGrades = 0.0
        var totalCredits = 0

        for (course in courses) {
            totalWeightedGrades += course.grade * course.credits
            totalCredits += course.credits
        }

        return if (totalCredits > 0) totalWeightedGrades / totalCredits else 0.0
    }

    fun weightedAverageY(year: Int): Double {
        var total = 0.0
        var totalGrades = 0

        for (course in courses) {
            if (course.yearCompleted == year) {
                total += course.grade * course.credits
                totalGrades += course.credits
            }
        }
        return total / totalGrades
    }

    fun getCredits (): Int {
        var totalCredits = 0

        for (course in courses) {
            totalCredits += course.credits
        }

        return totalCredits
    }

    fun minMaxGrades(): Pair<Double, Double> {
        var minGrade = 5.0
        var maxGrade = 1.0

        for (course in courses) {
            if (course.grade < minGrade) {
                minGrade = course.grade
            }

            if (course.grade > maxGrade) {
                maxGrade = course.grade
            }
        }

        return Pair(minGrade, maxGrade)
    }
}