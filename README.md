Sandbox Application Server
=======================
This is the aggregate application for the Travel Innovation Sandbox. 
It gathers up all the disparate JARs representing each sandbox interface implementation, and publishes them as a single WAR, including all the dependant JARs

Setting up
==========
To setup the sandbox you need to install Maven 3.0.4 (or some compatible version) and Java 7.
You will need to install the child project sandbox-hotel-shopping and build it first so that the pre-requisite JARs exist in your repo. 

To build the jar, run
> mvn install

If for some reason you get an error, it's likely that the default Amadeus settings.xml is causing the import to be ignored. This is evil but easily fixed.
Find your settings.xml, usually `D:\<myusername>\.m2` and in the mirrorOf line, if you see something like this

> <mirrorOf>*, !jcp.repository.wlm</mirrorOf>

make it something like this

> <mirrorOf>*, !jcp.repository.wlm, !project.local</mirrorOf>

Where is everything
================

