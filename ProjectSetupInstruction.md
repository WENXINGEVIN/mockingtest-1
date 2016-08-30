# Project setup instruction

# techdoc

techdoc are under the mockingtest/ dir. You will need to import mockingtest
as a non-java project from git repository. Then you can edit the *.md file and commit

# webapp code

webapp code is in mockingtest/app, once you git clone the mockingtest dir.
You can further import Java existing project from the git repository. Import> GIT>...; For code development, you will need to checkout this app dir as a Java project, in order to Run As in tomcat.

# library versions

Details can be checked in pom.xml

* spring security 4.1.2.RELEASE
* hibernate core 4.3.1, and others
* spring core, spring-web, spring-webmvc, spring-beans, spring-context,
  spring-aop, spring-expression are 4.2.1
* tiles, apache-commons related
* slf4j, common-logging related, json related
* flyway

# Developer machine setup

* Java 8 required
* maven 3 up required
* tomcat 8 required
* Eclipse neon + Tomcat plugin (If you use other like intelli J it is ok, solution not supported here)