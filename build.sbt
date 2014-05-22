organization := "com.amadeus"

name := "sandbox-application"

version := "1.2"

autoScalaLibrary := false

crossPaths := false

EclipseKeys.projectFlavor := EclipseProjectFlavor.Java

EclipseKeys.createSrc := EclipseCreateSrc.Default + EclipseCreateSrc.Resource

seq(webSettings :_*)

//Require servlet
libraryDependencies += "javax.servlet" % "javax.servlet-api" % "3.0.1" % "provided"

//Jetty container by default, but you could publish anywhere
libraryDependencies ++= Seq(
  "org.eclipse.jetty" % "jetty-webapp" % "9.1.0.v20131115" % "container",
  "org.eclipse.jetty" % "jetty-plus"   % "9.1.0.v20131115" % "container"
)