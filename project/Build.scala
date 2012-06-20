import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "babylon-control"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
        "org.scalatest" %% "scalatest" % "1.7.1" % "test"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
        testOptions in Test := Nil  //to run scalatest in play2 console arghhhh!!!
    )

}
