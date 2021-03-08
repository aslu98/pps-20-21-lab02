package u02.ex2

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class ParityTest {
  import u02.ex2.Parity._

  @Test def testParityFunctionLiteral(){
    val parityFunctionLiteral = (num:Int) => num match {
      case num if (num % 2 == 0) => "even"
      case _ => "odd"
    }
    assertEquals("odd", parityFunctionLiteral(3))
    assertEquals("even", parityFunctionLiteral(6))
    assertEquals("even", parityFunctionLiteral(0))
  }

  @Test def testParityMethod(){
    assertEquals("odd", parityMethod(3))
    assertEquals("even", parityMethod(6))
    assertEquals("even", parityMethod(0))
  }
}
