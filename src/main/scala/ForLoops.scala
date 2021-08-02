object ForLoops extends App {

  // args in env variable for For Loops
  for(arg <- args) println(arg)

  for(i <- 0 to 5) println(i)

  for(i <- 0 to 10 by 2) println(i)

  val x = for(i <- 1 to 5) yield i * 2

  println(x)

  val fruits = List("apple", "banana", "lime", "orange")

  val fruitLenth = for {
    f <- fruits
    if f.length > 4
  } yield f.length

  println(fruitLenth)
}
