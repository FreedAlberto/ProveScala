package graphQLSangria

import sangria.macros._
import sangria.execution._
import sangria.marshalling.circe._
import io.circe.Json

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object Exec extends App {

  val query =
    graphql"""
    query MyProduct {
      product(id: "2") {
        name
        description

        picture(size: 500) {
          width, height, url
        }
      }

      products {
        name
      }
    }
  """


  val result: Future[Json] =
    Executor.execute(SchemaDefinition.schema, query, new ProductRepo)

  result.foreach(j => println(j))

  scala.io.StdIn.readLine()
}
