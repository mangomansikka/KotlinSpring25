class Lotto1 {
    val secret = (1 .. 40).toList().shuffled().take(7).sorted()

    fun check(numbers: List<Int>): Int {
        return if (numbers.all { it in (1 .. 40) } && numbers.toSet().size == 7) {
            numbers.toSet().intersect(secret.toSet()).size
        } else {
            0
        }
    }
}

fun makeQuess() = (1..40).toList().shuffled().take(7).sorted()

val lotto = Lotto1()

while (true) {
    val guess = makeQuess()

    if (lotto.check(guess) == 0) {
        for (n in (1..40).toList().minus(guess.toSet())) {
            val newguess = guess.take(6) + listOf(n)
            if (lotto.check(newguess) == 1) {
                println("Found a number: $n")
            }
            break
        }
    }
}