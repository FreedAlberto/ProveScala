package jsonCirce

import io.circe._
import io.circe.parser._
import io.circe.optics.JsonPath._

object optics extends App {

  val validJson: Json = parse("""
  {
    "order": {
      "customer": {
        "name": "Custy McCustomer",
        "contactDetails": {
          "address": "1 Fake Street, London, England",
          "phone": "0123-456-789"
        }
      },
      "items": [{
        "id": 123,
        "description": "banana",
        "quantity": 1
      }, {
        "id": 456,
        "description": "apple",
        "quantity": 2
      }],
      "total": 123.45
    }
  }
""").getOrElse(Json.Null)

  val phoneNumPath = root.order.customer.contactDetails.phone.string

  val phoneNumber = phoneNumPath.getOption(validJson).getOrElse("")

  println(phoneNumber)

  val invalidJson = parse("pippo").getOrElse(Json.Null)

  val invalidPhoneNumber = phoneNumPath.getOption(invalidJson)

  println(invalidPhoneNumber)

  val user =
    """
      |{
      |"name" : "Alberto"
      |}
      |""".stripMargin

  val namePath = root.name.string

  def toEither[T](n: Option[T]): Either[String, T] = n match {
    case Some(value) => Right(value)
    case None => Left("Option is empty")
  }

  val parseResult = for{
    parsedJson <- parse(user)
    nameValue <- toEither(namePath.getOption(parsedJson))
  } yield nameValue

  parseResult match {
    case Right(name) => println(name)
    case Left(err) => println(err)
  }
}

