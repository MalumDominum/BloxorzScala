package individual

/** Variant 11 */
object IndividualTask extends App {
  val range = ((-250 to 250) map (x => (x, 100, 3))) to List
  val neededRangeAndTransform: PartialFunction[(Int, Int, Int), Int] = {
    case x if x._1 < -200 => x._1 + x._2
    case x if x._1 > 200 => Math.pow(x._1, x._3).toInt
    case _ => 0
  }

  // the method collect can use isDefinedAt to select which members to collect
  val numbers = (range collect neededRangeAndTransform).distinct
  numbers map (x => print(x + ", "))

  val evenNumbers = numbers filter (x => x % 2 == 0)
  print("\nfilter: ")
  evenNumbers map (x => print(x + ", "))

  val sumNumbers = numbers reduce (_ + _)
  print("\nreduce: " + sumNumbers)

  val reversedNumbers = (numbers foldRight "") ((x: Int, acc: String) => acc + (x + " "))
  print("\nfoldRight: " + reversedNumbers)

  val negateNumbers = numbers takeWhile (x => x < 0)
  print("\ntakeWhile: ")
  negateNumbers map (x => print(x + ", "))

  val evenAndOddNumbers = numbers partition (x => x % 2 == 0)
  print("\npartition (Even): ")
  evenAndOddNumbers._1 map (x => print(x + ", "))
  print("\npartition (Odd): ")
  evenAndOddNumbers._2 map (x => print(x + ", "))
}
