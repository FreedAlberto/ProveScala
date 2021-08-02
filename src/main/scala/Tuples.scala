object Tuples extends App {
  val tup = (11, 1.0, "ab")

  println(tup._1)
  println(tup._2)
  println(tup._3)

  def getAaplInfo(): (String, BigDecimal, Long) = {
    ("AAPL", BigDecimal(123.45), 11111L)
  }

  val (symbol, price, volume) = getAaplInfo()

  println(symbol)
  println(price)
  println(volume)
}
