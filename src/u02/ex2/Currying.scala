package u02.ex2

object Currying extends App {
  val p1: Int => (Int => (Int => Boolean)) = x => (y => (z => x <= y && y <=z))
  val firstEl: (Int => (Int => Boolean)) = p1(2)
  val secondEl: (Int => Boolean) = firstEl(3)
  val ThirdEl: Boolean = secondEl(4)
  println(ThirdEl) //true
  println(p1(6)(5)(4)) //false
  println()

  val p2: (Int, Int, Int) => Boolean = (x, y, z) => x <= y && y <=z;
  println(p2(2,2,2)); // true
  println(p2(2,1,2)); // false
  println()

  def p3 (x:Int)(y:Int)(z:Int) : Boolean =  x <= y && y <=z
  println(p3(1)(2)(3)) //true
  println(p3(6)(5)(4)) //false
  println()

  def p4 (x:Int, y:Int, z:Int) : Boolean =  x <= y && y <=z
  println(p4(1, 2, 3)) //true
  println(p4(6, 5, 4)) //false
  println()
}
