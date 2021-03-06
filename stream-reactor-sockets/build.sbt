import sbt.Resolver

name := "stream.reactor.sockets"

version := "1.0"

organization := "com.landoop"

scalaVersion := "2.11.8"

val kafkaVersion = "0.10.0.0"
val confluentVersion = "3.0.0"
val akkaVersion = "2.4.10"
val akkaSseVersion = "1.8.1"
val akkaKafkaVersion = "0.12"
val jacksonVersion = "2.8.2"

libraryDependencies ++= Seq(
  "io.confluent" % "kafka-connect-avro-converter" % confluentVersion exclude("org.slf4j", "slf4j-log4j12"),
  "com.datamountaineer" % "kcql" % "0.8.3",
  //akka
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream-kafka" % akkaKafkaVersion,
  "com.typesafe.akka" %% "akka-http-experimental" % akkaVersion,
  "com.typesafe.akka" %% "akka-http-spray-json-experimental" % akkaVersion,
  "de.heikoseeberger" %% "akka-sse" % akkaSseVersion,
  // kafka
  "org.apache.kafka" % "kafka-clients" % kafkaVersion,
  "org.apache.kafka" %% "kafka" % kafkaVersion exclude("org.slf4j", "*"),
  // logging
  "ch.qos.logback" % "logback-classic" % "1.0.1", // by using logback, we are actually using SLF4J
  "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
  "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0",
  // json parsing
  "com.fasterxml.jackson.core" % "jackson-databind" % jacksonVersion,
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % jacksonVersion,
  // mine
  "org.apache.kafka" % "connect-api" % kafkaVersion, // provided
  "org.apache.avro" % "avro" % "1.8.0",
  "log4j" % "log4j" % "1.2.17",
  "org.scalatest" %% "scalatest" % "2.2.4" % "test",
  //test deps
  "com.typesafe.akka" %% "akka-http-testkit" % akkaVersion % "test",
  "com.typesafe.akka" %% "akka-stream-testkit" % akkaVersion % "test"
)

resolvers ++= Seq(
  Resolver.sonatypeRepo("public"),
  "Confluent Maven Repo" at "http://packages.confluent.io/maven/"
)

// Errors creating spark contexts otherwise
parallelExecution in Test := false