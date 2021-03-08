package u02.ex4
import org.junit.jupiter.api._
import org.junit.jupiter.api.Assertions._
import u02.ex3.Fibonacci.fib

object GeometricShapes{
  sealed trait Shape
  case class Rectangle ( h : Double , w: Double ) extends Shape
  case class Circle ( r: Double ) extends Shape
  case class Square ( l: Double ) extends Shape

  def perimeter(shape:Shape): Double = shape match {
    case Circle(r) => 2*r*Math.PI
    case Square(l) => l*4
    case Rectangle(h, w) => (h+w)*2
  }
  def area(shape:Shape): Double = shape match {
    case Circle(r) => Math.pow(r,2)*Math.PI
    case Square(l) => Math.pow(l,2)
    case Rectangle(h, w) => h*w
  }

  @Test def testPerimeter(): Unit ={
    val rectangle = Rectangle(4.0, 5.0)
    val circle = Circle(2)
    val square= Square(5)
    assertEquals((4+5)*2, perimeter(rectangle))
    assertEquals(2*2*Math.PI, perimeter(circle))
    assertEquals(5*4, perimeter(square))
  }

  @Test def testArea(): Unit ={
    val rectangle = Rectangle(4.0, 5.0)
    val circle = Circle(2)
    val square= Square(5)
    assertEquals(4*5, area(rectangle))
    assertEquals(Math.pow(2,2)*Math.PI, area(circle))
    assertEquals(Math.pow(5,2), area(square))
  }
}
