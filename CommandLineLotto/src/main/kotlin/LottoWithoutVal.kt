class LottoWithoutVal {
    fun generateLottoNumbers(): List<Int> {
        return (1..40).shuffled().take(7).sorted()
    }

    fun guessedNumbers(s: String?): List<Int>? {
        return s?.split(",")?.map { it.trim().toInt() }
    }

    fun isLegalGuess(guess: List<Int>?): Boolean {
        return guess?.let { it.size <= 7 && it.all { num -> num in 1..40 } } ?: false
    }

    fun equalsCount(a: List<Int>?, b: List<Int>?): Int {
        return a?.intersect(b?.toSet() ?: emptySet())?.size ?: 0
    }

    fun main() {
        val lotto = LottoWithoutVal()
        val correct = lotto.generateLottoNumbers()
        while (true) {
            println("Enter your guess (comma-separated):")
            val guess = readlnOrNull()
            if (guess == "quit") {
                println("Lotto ended")
                break
            }
            val realGuess = lotto.guessedNumbers(guess)
            if (!lotto.isLegalGuess(realGuess)) {
                println("Illegal guess. Try again.")
                continue
            }
            val correctCount = lotto.equalsCount(correct, realGuess)
            println("Correct numbers guessed: $correctCount")
            // println("Secret numbers: ${correct.joinToString()}")
            if (correctCount == 7) {
                println("You won!")
                break
            }
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            LottoWithoutVal().main()
        }
    }
}