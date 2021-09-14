name := "ProveScala"

version := "0.1"

scalaVersion := "2.13.6"

val circeVersion = "0.14.1"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser",
  "io.circe" %% "circe-optics"
).map(_ % circeVersion)

libraryDependencies += "org.sangria-graphql" %% "sangria" % "2.0.0"

libraryDependencies += "org.sangria-graphql" %% "sangria-circe" % "1.3.0"
