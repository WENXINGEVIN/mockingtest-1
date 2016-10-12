# Project Deployment With Tomcat

This document is not talking about how to integrate maven with tomcat. It was one of our goals, but we don't
plan to do it now. It aims to give us another option to deploy and test out our project.

## Stuff needed

* Download and unzip Tomcat and put it in, for example, ~ in your machine.

* Tomcat plugin for eclipse, of course, for now we all use eclipse, we will look for other IDE in the future.
Configure tomcat path in your eclipse preferences, and then you will see three tomcat buttons in the toolbar of your eclipse. Start, Stop and Restart. Use these three buttons.

* Go to your project and do `mvn package`, now you will need to copy the war file to the tomcat/webapps dir.

