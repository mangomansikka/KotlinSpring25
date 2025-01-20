class Human {
    var name: String = ""
    var age: Int = 0

}

    fun getOlder() {
        val human = Human()

        human.age += 1
        println("Happy birthday ${human.name}! You are now ${human.age}")

    }
