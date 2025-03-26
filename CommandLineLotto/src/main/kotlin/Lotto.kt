class Lotto {

    fun generateLottoNumbers(): List<Int> {
        return (1..40).shuffled().take(7).sorted()
    }

    fun guessedNumbers(s: String?): List<Int>? {
        return s?.split(" ")?.map { it.toInt() }
    }

    fun isLegalGuess(guess: List<Int>?): Boolean {
        return guess?.let { it.size <= 7 && it.all { num -> num in 1..40 } } ?: false
    }

    fun equalsCount(a: List<Int>?, b: List<Int>?): Int {
        return a?.intersect(b?.toSet() ?: emptySet())?.size ?: 0
    }

    fun main() {
        val lotto = Lotto()
        val correct = lotto.generateLottoNumbers()
        val guesses = mutableListOf<List<Int>>()
        while (true) {
            println("Enter your guess:")
            val guess = readlnOrNull()
            if (guess == "exit") {
                println("Lotto ended")
                break
            }
            val realGuess = lotto.guessedNumbers(guess)
            realGuess?.let { guesses.add(it) }
            val guessList = guesses.flatten()
            if (!lotto.isLegalGuess(realGuess)) {
                println("Illegal guess. Try again.")
                continue
            }
            val correctCount = lotto.equalsCount(correct, guessList)
            println("Correct numbers guessed: $correctCount")
            // println("Correct numbers: ${correct.joinToString()}")
            if (correctCount == 7) {
                println("You won!")
                break
            }
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Lotto().main()
        }
    }
}