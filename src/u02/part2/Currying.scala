package u02.part2
import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

object Currying {
  val p1: Int => (Int => (Int => Boolean)) = x => (y => (z => x <= y && y <=z))
  @Test def testP1(): Unit ={
    val firstEl: (Int => (Int => Boolean)) = p1(2)
    val secondEl: (Int => Boolean) = firstEl(3)
    val ThirdEl: Boolean = secondEl(4)
    assertTrue(ThirdEl) //true
    assertFalse(p1(6)(5)(4)) //false
  }

  val p2: (Int, Int, Int) => Boolean = (x, y, z) => x <= y && y <=z;
  @Test def testP2(): Unit ={
    assertTrue(p2(2,2,2)); // true
    assertFalse(p2(2,1,2)); // false
  }

  def p3 (x:Int)(y:Int)(z:Int) : Boolean =  x <= y && y <=z
  @Test def testP3(): Unit ={
    assertTrue(p3(1)(2)(3)) //true
    assertFalse(p3(6)(5)(4)) //false
  }

  def p4 (x:Int, y:Int, z:Int) : Boolean =  x <= y && y <=z
  @Test def testP4(): Unit ={
    assertTrue(p4(1, 2, 3)) //true
    assertFalse(p4(6, 5, 4)) //false
  }
}
