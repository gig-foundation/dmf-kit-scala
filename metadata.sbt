name := "dmf-scala-kit"
description := "Scala developer kit for working with Data Management Foundation."

ThisBuild / organization := "gig.foundation"
ThisBuild / organizationName := "Global Information Graph Foundation"

ThisBuild / homepage := Some(new URL("http://gig.foundation"))
ThisBuild / startYear := Some(2019)

ThisBuild / developers :=
  Developer("chrisgebhardt", "Chris Gebhardt", "chris.gebhardt@gig.foundation", url("http://github.com/chrisgebhardt")) ::
    Developer("michaelahlers", "Michael Ahlers", "michael.ahlers@gig.foundation", url("http://github.com/michaelahlers")) ::
    Nil

ThisBuild / scmInfo :=
  Some(ScmInfo(
    browseUrl = url("https://github.com/gig-foundation/dmf-cloud"),
    connection = "https://github.com/gig-foundation/dmf-cloud.git",
    devConnection = Some("git@github.com:gig-foundation/dmf-cloud.git")
  ))

ThisBuild / licenses += "MIT" -> new URL("http://opensource.org/licenses/MIT")


