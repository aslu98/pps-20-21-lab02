package u02.part5
import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

object Optionals {

  sealed trait Option[A] // An Optional data type
  object Option {

    case class None[A]() extends Option[A]
    case class Some[A](a: A) extends Option[A]
    case class Two[A](first:A, second:A) extends Option[A]

    def isEmpty[A](opt: Option[A]): Boolean = opt match {
      case None() => true
      case _ => false
    }

    def getOrElse[A, B >: A](opt: Option[A], orElse: B): B = opt match {
      case Some(a) => a
      case _ => orElse
    }

    def flatMap[A, B](opt: Option[A])(f: A => Option[B]): Option[B] = opt match {
      case Some(a) => f(a)
      case _ => None()
    }

    def filter[A](opt: Option[A])(f: A => Boolean) : Option[A] = opt match {
      case Some(a: A) if f(a) => Some(a)
      case _ => None()
    }

    def map[A](opt: Option[A])(f: A => Boolean) : Option[Boolean] = opt match {
      case Some(a:A) if f(a) => Some(true)
      case _ => None()
    }

    def map2[A](opt1: Option[A], opt2: Option[A]) : Option[A] = (opt1, opt2) match{
      case (Some(a: A), Some(b:A)) => Two(a, b)
      case _ => None()
    }

    def modify[A](opt: Option[A], f: Option[A] => Option[A]) : Option[A] = f(opt)
  }

  import Option._

  @Test def testMap(): Unit ={
    assertEquals(None(), map(None[Int])(_ > 2)) // None
    assertEquals(Some(true), map(Some(5))(_ > 2))// Some(true)
  }

  @Test def testMap2(): Unit ={
    assertEquals(None(), map2(None(), None())) // None
    assertEquals(None(), map2(None(), Some(1))) // None
    assertEquals(Two(5,3), map2(Some(5), Some(3)))
  }

  @Test def testFilter(): Unit ={
    assertEquals(Some(5), filter(Some(5))(_>2))
    assertEquals(None(), filter(Some(5))(_>8))
  }

  @Test def testDouble(): Unit ={
    val double: Option[Int] => Option[Int] = {
      case Some(a) => Some(a * 2)
      case _ => None()
    }
    assertEquals(Some(10), modify(Some(5), double))
    assertEquals(None(), modify(None(), double))
  }

  @Test def tesNeg(): Unit ={
    val neg: Option[Boolean] => Option[Boolean] = {
      case Some(a) => Some(!a)
      case _ => None()
    }

    assertEquals(Some(false), modify(Some(true), neg))
    assertEquals(None(), modify(None(), neg))
  }
}
