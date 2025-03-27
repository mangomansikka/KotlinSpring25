import java.util.concurrent.ThreadLocalRandom

class LottoThread {
    private val secretNumbers = (1..40).shuffled().take(7).sorted()
    private val stats = mutableListOf<Int>()
    private var actualGuesses = 0
    private var startTime = 0
    private var endTime = 0

    private fun check(numbers: List<Int>): Int {
        return numbers.intersect(secretNumbers.toSet()).size
    }

    fun main() {
        val totalGuesses = 13_500_000
        val numThreads = 16
        val guessesPerThread = totalGuesses / numThreads

        val threads = (1..numThreads).map {
            Thread {
                println("Thread $it / $numThreads starting for $guessesPerThread guesses")
                val lotto = LottoThread()
                repeat(guessesPerThread) {
                    val guess = ThreadLocalRandom.current().ints(7, 1, 41).toArray().toList()
                    val correctCount = lotto.check(guess)
                    synchronized(stats) {
                        actualGuesses++
                        stats.add(correctCount)
                    }
                }
            }
        }

        threads.forEach(Thread::start)
        threads.forEach(Thread::join)
        println("All joined")
        startTime = System.currentTimeMillis().toInt()
        println("Checksum: " + actualGuesses/numThreads + " should be: " + totalGuesses)
        println(stats.groupingBy { it }.eachCount())
        endTime = System.currentTimeMillis().toInt()-startTime
        println("Ending time: $endTime")
    }
}

fun main() {
    LottoThread().main()
}