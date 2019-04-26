name := """ChatTheme"""
organization := "chattheme"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
  jdbc,
  ws,
  guice,
  "com.typesafe.play" %% "anorm" % "2.5.3",
  "mysql" % "mysql-connector-java" % "8.0.8-dmr",
  "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.1" % Test
)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "chattheme.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "chattheme.binders._"
