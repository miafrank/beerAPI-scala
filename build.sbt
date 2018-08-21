val ScalatraVersion = "2.6.3"

organization := "com.example"

name := "My Scalatra Web App"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.12.6"

resolvers += Classpaths.typesafeReleases

containerPort :=8081

libraryDependencies ++= Seq(
  "org.scalatra" %% "scalatra" % ScalatraVersion,
  "org.scalatra" %% "scalatra-scalatest" % ScalatraVersion % "test",
  "ch.qos.logback" % "logback-classic" % "1.2.3" % "runtime",
  "org.eclipse.jetty" % "jetty-webapp" % "9.4.9.v20180320" % "container",
  "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided",
  "org.json4s"   %% "json4s-jackson" % "3.5.2",
  "org.json4s" %% "json4s-mongo" % "3.5.2",
  "org.mongodb" %% "casbah" % "3.1.1",
  "net.liftweb" %% "lift-json" % "3.3.0",
  "org.scalatra" %% "scalatra-json" % ScalatraVersion,
)

enablePlugins(SbtTwirl)
enablePlugins(ScalatraPlugin)
