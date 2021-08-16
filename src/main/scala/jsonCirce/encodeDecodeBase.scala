package jsonCirce

import io.circe.generic.auto._
import io.circe.parser._
import io.circe.syntax._

object jsonCirce extends App {
  println("Start Test 1")

  val foo: Foo = Qux(19, Some(14.0))

  val jSon = foo.asJson.noSpaces
  println(jSon)

  val decodedFoo = decode[Foo](jSon)
  println(decodedFoo)

  println("Finished Test 1")

  println("Start Test 2")

  val validJson: String =
    """
      |{
      | "foo": "bar",
      | "baz": 123,
      | "list of stuff": [4, 5, 6]
      |}
      |""".stripMargin

  println(validJson)

  val parseValidJsonResult = parse(validJson)

  //val json = parseResult.getOrElse(null)
  //println(json)

  val x = parseValidJsonResult match {
    case Left(failure) => println(failure)
    case Right(value) => value
  }

  println(x)

  val invalidJson =
    """
      |blablabla
      |""".stripMargin

  val parseInvalidJsonResult = parse(invalidJson)

  val y = for{
    j <- parseInvalidJsonResult
  } yield j

  println(y) // Left(io.circe.ParsingFailure)

  println("Finished Test 2")
}

sealed trait Foo
case class Bar(xs: Vector[String]) extends Foo
case class Qux(i: Int, d: Option[Double]) extends Foo

