open class Human(name : String, age: Int) {
    var name: String = ""
    var age: Int = 0

    init {
        this.name = name
        this.age = age
    }

    fun getOlder() {
        age++
    }

}

