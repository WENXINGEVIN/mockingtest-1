# Project Progress

## Initial stage checklist

* Project setup with Spring, Hibernate, Tiles, db drivers and other components dependencies using Maven system  (xiaofeng, done)
* Project setup instructions (xiaofeng, done)
* Basic controller, Spring security integration (xiaofeng, done)
* Flyway DB integration with maven (xiaofeng, http://stackoverflow.com/questions/39240213/unable-to-obtain-jdbc-connection-from-datasource-for-user-root-could-not-crea, currently not working due to known/reported bug, the plugin is very vulerable to the different version of the mysql drivers, currently there is NPE and unknown timezone issue)
* Spring with tiles integration (xiaofeng, Sep 2end, done, doc added)
* React+webpack doc added, example added (done and continuing, xiaofeng, Sep 2nd)
* SQL words data merged, data processing java code merged, flyway migration/data encoding tested (xiaofeng, Sep 2nd, done)
* Spring with hibernate integration (xiaofeng, Sep 3rd, need a markdown file)
* RequestData filter (xiaofeng, By Sep 10th, this is to get user's request info regarding GeoLocation)
* Login/Logout filter (security) (xiaofeng By Sep 5nd)
* User registration (By Sep 5th)
* Rememberme service
* Basic website css. 

## Stage one

* Frontend JS framework integration, research of webpack, react and Restful.
  Need to get the basic stuff from json to render in the frontend. (Xin, Sep 15th)
* Oauth2 integration (xiaofeng, before Sep 25th)
* Database mocking test (xiaofeng, by Sep 4th)
* Maven with property file for production and test servers (By Nov 20th)

## Stage two

* Start rework on database design, need to reserve a field for pronunciation and how to represent that in alphabets. (This might requires a notation system design and parser)

 ref: 
 http://wordnet.princeton.edu/
 http://androidtech.com/html/wordnet-mysql-20.php (very promisíing)
 dict.cn, no API, need to write one to work with it.
 
 


* Start UI desing
* Start Frontpage design
* Start on service design

## Reference 

* Maven with diffferent properties file
https://maven.apache.org/guides/mini/guide-building-for-different-environments.html
* Flyway integration with Maven
* https://flywaydb.org/documentation/maven/migrate.html
* https://flywaydb.org/getstarted/firststeps/maven
* https://flywaydb.org/getstarted/firststeps/api
* http://chariotsolutions.com/blog/post/using-maven-to-integrate-flyway-in-an-existing-database-part-1/
* http://chariotsolutions.com/blog/post/using-maven-to-integrate-flyway-in-an-existing-database-part-2/
* http://blog.trifork.com/2014/12/09/integrating-flywaydb-in-a-spring-framework-application/
* http://stackoverflow.com/questions/28920131/configuration-for-maven-and-flyway-in-multiple-environments-plus-integration-te
* http://stackoverflow.com/questions/23545657/how-to-use-flyway-configuration-to-handle-multiple-databases