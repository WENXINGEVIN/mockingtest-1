# Maven Integration with Jetty

## Jetty Maven Plugin

Required maven 3 and Java 7 up

	<plugin>
  		<groupId>org.eclipse.jetty</groupId>
  		<artifactId>jetty-maven-plugin</artifactId>
  		<version>9.3.0.v20150612</version>
	</plugin>

then,

	mvn jetty:run

This starts Jetty and serves up your project on http://localhost:8080/.

Then for example, for our mockingtest project,
we can see localhost:8080/welcome, just test some controller you know of,

The jetty server console will look like the following,
 
```
[INFO] Configuring Jetty for project: app Maven Webapp
[INFO] webAppSourceDirectory not set. Trying src/main/webapp
[INFO] Reload Mechanic: automatic
[INFO] Classes = /Users/xiaofeng/cloud/mockingtest/app/target/classes
[INFO] Logging initialized @23388ms
[INFO] Context path = /
[INFO] Tmp directory = /Users/xiaofeng/cloud/mockingtest/app/target/tmp
[INFO] Web defaults = org/eclipse/jetty/webapp/webdefault.xml
[INFO] Web overrides =  none
[INFO] web.xml file = file:///Users/xiaofeng/cloud/mockingtest/app/src/main/webapp/WEB-INF/web.xml
[INFO] Webapp directory = /Users/xiaofeng/cloud/mockingtest/app/src/main/webapp
[INFO] jetty-9.3.0.v20150612
[INFO] No Spring WebApplicationInitializer types detected on classpath
[INFO] Initializing Spring root WebApplicationContext
Sep 01, 2016 10:48:14 PM org.springframework.web.context.ContextLoader initWebApplicationContext
INFO: Root WebApplicationContext: initialization started
Sep 01, 2016 10:48:14 PM org.springframework.web.context.support.XmlWebApplicationContext prepareRefresh
INFO: Refreshing Root WebApplicationContext: startup date [Thu Sep 01 22:48:14 CDT 2016]; root of context hierarchy
Sep 01, 2016 10:48:14 PM org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
INFO: Loading XML bean definitions from ServletContext resource [/WEB-INF/spring-security.xml]
```

Theoretically, for testing our webapp, it should not rely on the tomcat's own lib.

Jetty continues to run until you stop it. While it runs, it periodically scans for changes to your project files, so if you save changes and recompile your class files, Jetty redeploys your webapp, and you can instantly test the changes you just made.

You can terminate the plugin with a ctrl-c in the terminal window where it is running.

To see a list of all goals supported by the Jetty Maven plugin, do:

	mvn jetty:help

and more detailed,

	mvn jetty:help -Ddetail=true -Dgoal= goal-name

## Configure the Jetty Container

for `mvn jetty:run` is what you will need in development, it runs from webapp source not zip to war file and unzip war to deploy. Thus, it saves time for you. Also the scanIntervalSeconds can help you save time when there is any change happended after you deploy and start the server. Any changes you make are immediately reflected in the running instance of Jetty, letting you quickly jump from coding to testing, rather than going through the cycle of: code, compile, reassemble, redeploy, test.

So it will look like the following,

	<plugin>
  		<groupId>org.eclipse.jetty</groupId>
  		<artifactId>jetty-maven-plugin</artifactId>
  		<version>9.3.0.v20150612</version>
  		<configuration>
    		<scanIntervalSeconds>10</scanIntervalSeconds>
    		<webApp>
      			<contextPath>/test</contextPath>
    		</webApp>
    		<jettyXml> </jettyXml>
  		</configuration>
	</plugin>

And there are more to read on when needed.


## References
* http://www.eclipse.org/jetty/documentation/9.3.0.v20150612/jetty-maven-plugin.html (up2date)

* http://www.benoitschweblin.com/2013/03/run-jetty-in-maven-life-cycle.html (too old but good for older version)

 
 