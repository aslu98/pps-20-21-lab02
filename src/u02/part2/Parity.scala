package u02.part2
import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

object Parity {
  val parityFunctionLiteral = (num: Int) => num match {
    case num if (num % 2 == 0) => "even"
    case _ => "odd"
  }

  @Test def testParityFunctionLiteral(){
    assertEquals("odd", parityFunctionLiteral(3))
    assertEquals("even", parityFunctionLiteral(6))
    assertEquals("even", parityFunctionLiteral(0))
  }

  def parityMethod(n: Int): String = n match {
    case n if (n % 2 == 0) => "even"
    case _ => "odd"
  }

  @Test def testParityMethod(){
    assertEquals("odd", parityMethod(3))
    assertEquals("even", parityMethod(6))
    assertEquals("even", parityMethod(0))
  }
}
