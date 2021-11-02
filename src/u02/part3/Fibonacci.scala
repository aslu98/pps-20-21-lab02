package u02.part3

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

object Fibonacci{
  
  def fib(n: Int): Int = {
    @tailrec
    def fib2(n: Int, acc0: Int, acc1: Int): Int = n match {
      case 0 => acc0
      case 1 => acc1
      case _ => fib2(n - 1, acc1, acc0 + acc1)
    }

    fib2(n, 0, 1)
  }

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
