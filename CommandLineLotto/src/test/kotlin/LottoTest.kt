
import org.junit.jupiter.api.Test

internal class LottoTest {

    @Test
    fun generateLottoNumbers() {
        val lotto = Lotto()
        val numbers = lotto.generateLottoNumbers()
        assert(numbers.size == 7)
        assert(numbers.all { it in 1..40 })
    }

    @Test
    fun guessedNumbers() {
        val lotto = Lotto()
        assert(lotto.guessedNumbers("1,2,3,4,5,6,7") == listOf(1, 2, 3, 4, 5, 6, 7))
    }

    @Test
    fun isLegalGuess() {
        val lotto = Lotto()
        assert(lotto.isLegalGuess(listOf(1, 2, 3, 4, 5, 6, 7)))
        assert(!lotto.isLegalGuess(listOf(1, 2, 3, 4, 5, 6, 7, 8)))
        assert(!lotto.isLegalGuess(listOf(1, 2, 3, 4, 5, 6, 41)))
    }

    @Test
    fun equalsCount() {
        val lotto = Lotto()
        assert(lotto.equalsCount(listOf(1, 2, 3, 4, 5, 6, 7), listOf(1, 2, 3, 4, 5, 6, 7)) == 7)
        assert(lotto.equalsCount(listOf(1, 2, 3, 4, 5, 6, 7), listOf(1, 2, 3, 4, 5, 6, 8)) == 6)
        assert(lotto.equalsCount(listOf(1, 2, 3, 4, 5, 6, 7), listOf(1, 2, 3, 4, 5, 31, 41)) == 5)
    }
}