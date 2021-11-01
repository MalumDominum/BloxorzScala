package individual

import IndividualTask.*

/** Variant 11 */
class IndividualSuite extends munit.FunSuite {
  test("Test list of even numbers") {
    val result = evenNumbers.count(x => x % 2 == 1)
    assertEquals(0, result)
  }

  test("Test list of reversed numbers") {
    val reversedIntNumbers = ((reversedNumbers split " ") map (x => x.toInt)) to List
    assertEquals(numbers.reverse, reversedIntNumbers)
  }

  test("Test list of negate numbers") {
    val result = negateNumbers.count(x => x >= 0)
    assertEquals(0, result)
  }

  test("Test lists of even and odd numbers") {
    val resultEven = evenAndOddNumbers._1.count(x => x % 2 == 1)
    val resultOdd = evenAndOddNumbers._2.count(x => x % 2 == 0)
    assertEquals(0, resultEven)
    assertEquals(0, resultOdd)
    assert(evenAndOddNumbers._1.length > 0 && evenAndOddNumbers._2.length > 0)
  }

  import scala.concurrent.duration._
  override val munitTimeout: FiniteDuration = 10.seconds
}
