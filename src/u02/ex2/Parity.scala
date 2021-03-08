package u02.ex2

object Parity extends App {
  val parityFunctionLiteral = (num: Int) => num match {
    case num if (num % 2 == 0) => "even"
    case _ => "odd"
  }

  /*println(parityFunctionLiteral(3))
  parityFunctionLiteral(6)
  parityFunctionLiteral(0)
   */

  def parityMethod(n: Int): String = n match {
    case n if (n % 2 == 0) => "even"
    case _ => "odd"
  }
}
