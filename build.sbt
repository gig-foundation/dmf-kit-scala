lazy val `dmf-kit` =
  (project in file("."))
    .aggregate(
      `models-common`,
      `models-encoding-border`)

lazy val `models-common` = project in file("modules") / "models" / "common"

lazy val `models-encoding-border` =
  (project in file("modules") / "models" / "encoding-borer")
    .dependsOn(`models-common`)

publish / skip := true

ThisBuild / scalafmtOnCompile := true

ThisBuild / Test / testOptions += Tests.Argument(TestFrameworks.ScalaTest, "-oD")

ThisBuild / versionScheme := Some("semver-spec")
