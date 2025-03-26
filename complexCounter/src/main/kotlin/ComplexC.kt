import kotlin.math.abs

const val EPS = 0.0000001 // used in equals comparison

class ComplexC(re: Int, im: Int) {

    var abs: Double = Math.sqrt((re * re + im * im).toDouble())
    var real: Int = re
    var imaginary: Int = im

    // operators are given another complex value and return a new complex value

    operator fun plus(other: ComplexC): ComplexC {
        return ComplexC(real + other.real, imaginary + other.imaginary)
    }

    operator fun minus(other: ComplexC): ComplexC {
        return ComplexC(real - other.real, imaginary - other.imaginary)
    }

    operator fun times(other: ComplexC): ComplexC {
        return ComplexC(real * other.real - imaginary * other.imaginary,
            real * other.imaginary + imaginary * other.real)
    }

    override fun toString(): String {
        return "$real + ${imaginary}i"
    }

    override fun equals(other: Any?): Boolean {
        if (other is ComplexC) {
            return (kotlin.math.abs(other.real - real) < EPS) && (kotlin.math.abs(other.imaginary - imaginary) < EPS)
        }
        return false
    }

    override fun hashCode(): Int {
        var result = real
        result = 31 * result + imaginary
        return result
    }

}