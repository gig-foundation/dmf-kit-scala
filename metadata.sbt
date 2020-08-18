name := "dmf-kit-scala"
description := "Scala developer kit for working with Data Management Foundation."

ThisBuild / organization := "gig.foundation"
ThisBuild / organizationName := "gig Foundation"

// ThisBuild / homepage := ???
ThisBuild / startYear := Some(2020)

ThisBuild / developers :=
  Developer("michaelahlers", "Michael Ahlers", "michael.ahlers@gig.foundation", url("http://github.com/michaelahlers")) ::
    Nil

ThisBuild / scmInfo :=
  Some(
    ScmInfo(
      browseUrl = url("https://github.com/gig-foundation/dmf-kit-scala"),
      connection = "https://github.com/gig-foundation/dmf-kit-scala.git",
      devConnection = Some("git@github.com:gig-foundation/dmf-kit-scala.git")
    ))

ThisBuild / licenses += "MIT" -> new URL("http://opensource.org/licenses/MIT")
