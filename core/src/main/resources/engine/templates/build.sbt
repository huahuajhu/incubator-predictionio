name := "yourengine"

organization := "org.yourorg"

scalaVersion := "2.10.4"

scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature")

libraryDependencies ++= Seq("io.prediction" %% "core" % "0.8.0-SNAPSHOT")
