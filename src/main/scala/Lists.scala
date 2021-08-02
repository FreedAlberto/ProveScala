object Lists extends App {
  val nums = List.range(0, 10)

  nums.foreach(println)

  val nums2 = (1 to 10 by 2)

  nums2.foreach(println)

  val letters = ('a' to 'f').toList

  letters.foreach(println)

  val oddLetters = ('a' to 'f' by 2).toList

  oddLetters.foreach(println)

  nums
    .filter(_ < 4)
    .foreach(println)

  nums
    .map(_ * 2)
    .foreach(println)

  val names = List("joel", "ed", "chirs", "maurice")

  names
    .map(_.capitalize)
    .foreach(println)

  val nums2Sum = nums2
    .foldLeft(0)(_ + _)

  println(nums2Sum)

  val nums2Mult = nums2
    .foldLeft(1)(_ * _)

  println(nums2Mult)
}
