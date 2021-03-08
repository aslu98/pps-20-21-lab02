package u02.part2
import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

object Compose{
  def compose (f: Int => Int, g: Int => Int): Int => Int = (x:Int) => f(g(x))
  @Test def testCompose(): Unit ={
    assertEquals(9, compose(_-1,_*2)(5))
  }

  def genericCompose[A, B, C, D] (f: B => C, g: A => B): A => C = (x:A) => f(g(x))
  @Test def testGenericCompose(): Unit ={
    assertEquals(9, genericCompose[Int, Int, Int, Int](_-1,_*2)(5))
  }
}
