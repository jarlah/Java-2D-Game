name := "hello"

version := "1.0"

scalaVersion := "2.11.2"

libraryDependencies ++= Seq(
  "junit" % "junit" % "4.11" % Test,
  "com.novocode" % "junit-interface" % "0.11" % Test exclude("junit", "junit-dep")
)