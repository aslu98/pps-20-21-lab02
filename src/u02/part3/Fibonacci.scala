package u02.part3

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

object Fibonacci{
  def fib (n: Int) : Int = n match {
   case 0 => 0
   case 1 => 1
   case _ => fib(n - 1) + fib(n - 2)
  }
  /*non è tail perchè dopo aver eseguito la chiamata alla funzione ricorsiva non basta ritornarla, bisogna sommarla con l'altra chiamata*/

  @Test def testFib(): Unit ={
    assertEquals(0, fib(0));
    assertEquals(1, fib(1));
    assertEquals(1, fib(2));
    assertEquals(2, fib(3));
    assertEquals(3, fib(4));
    assertEquals(5, fib(5));
    assertEquals(8, fib(6));
  }
}
