# Project Setup Instruction

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
* maven 3 up required (brew install mvn)
* tomcat 8 required
* Eclipse neon + Tomcat plugin (If you use other like intelli J it is ok, solution not supported here)
* nodeJS 5 (brew install -g node)
* npm 3 (brew install -g npm@3)

# Commits

Please make sure that you do a `mvn clean` and do not commit anything in the target/ directory.

# Useful commands

* Run the project 
 In app/ directory, do a 
 `mvn clean package`. Then select index.jsp and "Run as" > "Run on server", select tomcat8 to run the project. "mvn site" or "mvn deploy" is not configured yet. 

* jetty is integrated so you don't need tomcat to run the project

After you checout the project, try to do `mvn clean compile jetty:run`

* Database migration (This part is not done)
  `mvn flyway:migrate`
   
* Maven debugging with -X flag