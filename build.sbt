lazy val `dmf-kit` =
  (project in file("."))
    .aggregate(
      `models-canonical`,
      `models-common`)

lazy val `models-canonical` =
  (project in file("modules") / "models" / "canonical")
    .dependsOn(`models-common`)

lazy val `models-common` = project in file("modules") / "models" / "common"

publish / skip := true

ThisBuild / scalafmtOnCompile := true

ThisBuild / Test / testOptions += Tests.Argument(TestFrameworks.ScalaTest, "-oD")
