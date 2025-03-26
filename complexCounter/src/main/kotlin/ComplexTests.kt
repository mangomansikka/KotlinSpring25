import org.junit.jupiter.api.Test
import kotlin.math.abs
import kotlin.math.sqrt


internal class ComplexTests {

    @Test
    fun testConstructor1() {
        val a = ComplexC(1, 2)
        assert(((a.real/1.0 - 1.0) < EPS) && ((a.imaginary/2.0 -
                1.0) < EPS))
    }

    @Test
    fun testConstructor2() {
        val a = ComplexC(1, 2)
        assert((abs(a.real/1.0 - 1.0) < EPS) &&
                (abs(a.imaginary/2.0 - 1.0) < EPS))
    }

    @Test
    fun testEquals1() {
        val a = ComplexC(1, 2)
        val b = ComplexC(1, 2)
        assert(a == b)
    }

    @Test
    fun testEquals2() {
        val a = ComplexC(1, 2)
        val b = ComplexC(1, 3)
        assert(a != b)
    }

    @Test
    fun testPlus() {
        val a = ComplexC(1,2)
        val b = ComplexC(3,4)
        assert((a + b) == ComplexC(4,6))
    }

    @Test
    fun testMinus() {
        val a = ComplexC(1,2)
        val b = ComplexC(3,4)
        assert((a - b) == ComplexC(-2,-2))
    }

    @Test
    fun testTimes1() {
        val a = ComplexC(0,1)
        val b = ComplexC(0,1)
        assert((a * b) == ComplexC(-1,0))
    }

    @Test
    fun testTimes2() {
        val a = ComplexC(1,2)
        val b = ComplexC(3,4)
        assert((a * b) == ComplexC(-5,10))
    }

    @Test
    fun testTimes3() {
        val a = ComplexC(1,2)
        val b = ComplexC(1,-2)
        assert((a * b) == ComplexC(5,0))
    }

    @Test
    fun testAbs1() {
        val a = ComplexC(1,0)
        assert(abs(a.abs - 1.0) < EPS)
    }

    @Test
    fun testAbs2() {
        val a = ComplexC(1,1)
        assert(abs(a.abs - sqrt(2.0)) < EPS)
    }
}