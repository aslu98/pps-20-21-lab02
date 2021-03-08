package u02.ex2

object Neg extends App {
  def neg (f: (String => Boolean))(str:String): Boolean = !f(str)
  val empty: String => Boolean = _=="" // predicate on strings
  val notEmpty: String => Boolean = neg(empty) // which type of notEmpty?
  println(notEmpty("foo"))// true
  println(notEmpty("")) // false
  println(notEmpty("foo") && !notEmpty(""))// true.. a comprehensive test

  println()

  val valNeg: (String => Boolean) => (String => Boolean) = f => (str => !f(str))
  val valEmpty: String => Boolean = _=="" // predicate on strings
  val valNotEmpty: String => Boolean = valNeg(empty) // which type of notEmpty?
  println(valNotEmpty("foo"))// true
  println(valNotEmpty("")) // false
  println(valNotEmpty("foo") && !valNotEmpty(""))// true.. a comprehensive test

  println()

  def genericNeg[A] (f: (A => Boolean))(elem:A): Boolean = !f(elem)
  val zero: Int => Boolean = _==0 // predicate on strings
  val notZero: Int => Boolean = genericNeg(zero) // which type of notEmpty?
  println(notZero(7))// true
  println(notZero(0)) // false
  println(notZero(7) && !notZero(0))// true.. a comprehensive test
}
