lazy val `dmf-kit` =
  (project in file("."))
    .aggregate(`persistence`)

lazy val `persistence` = project in file("modules") / "persistence"

publish / skip := true

ThisBuild / scalafmtOnCompile := true

ThisBuild / Test / testOptions += Tests.Argument(TestFrameworks.ScalaTest, "-oD")
