Sandbox Application Server
=======================
This is the aggregate application for the Travel Innovation Sandbox. 
It gathers up all the disparate JARs representing each sandbox interface implementation, and publishes them as a single WAR, including all the dependant JARs

Setting up
==========
To setup the project you need to install SBT. See http://www.scala-sbt.org/release/docs/Getting-Started/Setup.html
On Windows you can also install using Chocolatey, the package name is SBT.

The project is preconfigured with sbt-eclipse, to build your workspace run 
> sbt eclipse

from the same folder as this readme. Then in eclipse, choose Import -> Existing Project and choose this folder.

To build the jar, run
> sbt package

Where is everything
================
The SBT project file will gather all the compiled sandbox implementations from your local Ivy repository.
That means you have to have it running locally. It would be cool to put these all in a Maven repo some day!

