lazy val `dmf-kit` = project in file(".")

publish / skip := true

ThisBuild / scalafmtOnCompile := true

ThisBuild / Test / testOptions += Tests.Argument(TestFrameworks.ScalaTest, "-oD")

ThisBuild / versionScheme := Some("semver-spec")
