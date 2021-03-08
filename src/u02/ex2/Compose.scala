package u02.ex2

object Compose extends App {
  def compose (f: Int => Int, g: Int => Int): Int => Int = (x:Int) => f(g(x))
  println(compose(_-1,_*2)(5))// 9

  def genericCompose[A, B, C, D] (f: B => C, g: A => B): A => C = (x:A) => f(g(x))
  println(genericCompose[Int, Int, Int, Int](_-1,_*2)(5))// 9
}
