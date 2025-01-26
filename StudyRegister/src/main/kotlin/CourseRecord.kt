class CourseRecord(name: String, yearCompleted: Int, credits: Int, grade: Double) {
    var name: String = ""
    var yearCompleted: Int = 0
    var credits: Int = 0
    var grade: Double = 0.0

    init {
        this.name = name
        this.yearCompleted = yearCompleted
        this.credits = credits
        this.grade = grade
    }
}