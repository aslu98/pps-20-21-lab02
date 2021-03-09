package u02.part2
import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

object Neg {
  val valNeg: (String => Boolean) => (String => Boolean) = f => (str => !f(str))
  val valEmpty: String => Boolean = _==""
  val valNotEmpty: String => Boolean = valNeg(empty)

  @Test def testValNeg() {
    assertTrue(valNotEmpty("foo"))
    assertFalse(valNotEmpty(""))
    assertTrue(valNotEmpty("foo") && !valNotEmpty(""))
  }

  def neg (f: (String => Boolean))(str:String): Boolean = !f(str)
  val empty: String => Boolean = _==""
  val notEmpty: String => Boolean = neg(empty)

  @Test def testNeg() {
    assertTrue(notEmpty("foo"))
    assertFalse(notEmpty(""))
    assertTrue(notEmpty("foo") && !notEmpty(""))
  }

  def genericNeg[A] (f: (A => Boolean))(elem:A): Boolean = !f(elem)
  val zero: Int => Boolean = _==0
  val notZero: Int => Boolean = genericNeg(zero)

  @Test def testGenericNeg() {
    assertTrue(notZero(7))
    assertFalse(notZero(0))
    assertTrue(notZero(7) && !notZero(0))
  }
}
