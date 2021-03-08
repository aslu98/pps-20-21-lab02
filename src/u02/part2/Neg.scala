package u02.part2
import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

object Neg {
  def neg (f: (String => Boolean))(str:String): Boolean = !f(str)
  val empty: String => Boolean = _=="" // predicate on strings
  val notEmpty: String => Boolean = neg(empty) // which type of notEmpty?

  @Test def testNeg() {
    assertTrue(notEmpty("foo")) // true
    assertFalse(notEmpty("")) // false
    assertTrue(notEmpty("foo") && !notEmpty("")) // true.. a comprehensive test
  }

  val valNeg: (String => Boolean) => (String => Boolean) = f => (str => !f(str))
  val valEmpty: String => Boolean = _=="" // predicate on strings
  val valNotEmpty: String => Boolean = valNeg(empty) // which type of notEmpty?

  @Test def testValNeg() {
    assertTrue(valNotEmpty("foo")) // true
    assertFalse(valNotEmpty(""))// false
    assertTrue(valNotEmpty("foo") && !valNotEmpty("")) // true.. a comprehensive test
  }

  def genericNeg[A] (f: (A => Boolean))(elem:A): Boolean = !f(elem)
  val zero: Int => Boolean = _==0 // predicate on strings
  val notZero: Int => Boolean = genericNeg(zero) // which type of notEmpty?

  @Test def testGenericNeg() {
    assertTrue(notZero(7))// true
    assertFalse(notZero(0)) // false
    assertTrue(notZero(7) && !notZero(0))// true.. a comprehensive test
  }
}
