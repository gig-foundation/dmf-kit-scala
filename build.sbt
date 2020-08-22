lazy val `dmf-kit` =
  (project in file("."))
    .aggregate(
      `core`,
      `persistence`,
      `persistence-cbor`)

lazy val `core` = project in file("modules") / "core"

lazy val `persistence` =
  (project in file("modules") / "persistence")
    .dependsOn(`core`)

lazy val `persistence-cbor` =
  (project in file("modules") / "persistence-cbor")
    .dependsOn(`persistence`)

publish / skip := true

ThisBuild / scalafmtOnCompile := true

ThisBuild / Test / testOptions += Tests.Argument(TestFrameworks.ScalaTest, "-oD")
