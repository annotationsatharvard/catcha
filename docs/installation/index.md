These instructions assume that:

* You are installing the CATCH API on a version of Debian Linux (like Ubuntu 14.04).
* You have SSH'd onto the server to which you intend to deploy CATCH API.
* You are familiar with Ubuntu, Java, MySQL, and Tomcat.

# Dependencies

Install Java 7+
```
$ sudo apt-get install openjdk-7-jre
```
Install Tomcat 7+
```
$ sudo apt-get install tomcat7
$ sudo apt-get install tomcat7-admin
```
Install MySQL 5.5+
```
$ sudo apt-get install mysql-server
```
# Database 

Create the database 
```
$ mysql -u root -p -e 'create database catch default charset utf8;'
```

Grant permissions to database user
```
mysql -u root -p -e 'grant all on catch.* to 'catch'@'localhost' identified by "password";'
```
NOTE: For security reasons, you should probably consider using a different password.  The username and password properties should be configured using the `dataSource.username` and `dataSource.password` configuration properties in `catch-config.properties`.

# Configuration
Create a config file (catch-config.properties) to store runtime configuration properties.
``` 
$ mkdir /usr/share/tomcat7/.grails
$ vi /usr/share/tomcat7/.grails/catch-config.properties
```
**catch-config.properties**

```
# Database Configuration
dataSource.url=jdbc:mysql://localhost:3306/catch?useUnicode=yes&characterEncoding=UTF-8&autoReconnect=true
dataSource.username=catch
dataSource.password=password
# CATCH Configuration
af.shared.name=CATCH-A
af.shared.title=CATCH-A, Annotations at Harvard
af.shared.logo.title=CATCH
af.shared.logo.subtitle=Annotation Hub
af.shared.copyright.label=Annotations @ Harvard 
af.shared.copyright.link=http://www.annotations.harvard.edu/
af.security.initialize.user=true
af.security.moderation.user.request=true
af.node.organization=Massachusetts General Hospital
af.node.administrator.name=Dr. Paolo Ciccarese
af.node.administrator.email.to=paolo.ciccarese@gmail.com
af.node.administrator.email.display=paolo dot ciccarese at gmail.com
af.node.base.url=http://localhost:8080/catch/
```
NOTE: Documentation for each available configuration will be provided soon.

# Deployment

Stop tomcat7 server
```
$ sudo service tomcat7 stop
```

NOTE: You will likely encounter OutOfMemoryErrors with Tomcat's default memory settings.  Therefore, we usually add a file (`/usr/share/tomcat7/bin/setenv.sh`) that is invoked by the Tomcat startup script and is used to control the amount of memory allocated to your instance of Tomcat. A very basic `setenv.sh` will look like this:  
```
export CATALINA_OPTS="-Xms512m -Xmx512m -XX:MaxPermSize=256m"
```
NOTE: You may be able to get away with using 256m as the max heap size, but 512m is a good setting, even for production environments.  Using more memory will allow you to cache more data, but does not always result in a better performing application.  So there's no need in getting carried away.  We've been using about 1024m in production for over a year and that suits us fine.

Once you've edited the file, make sure to change mod properties to allow execution of the bash script.
```
$ chmod +x /usr/share/tomcat7/bin/setenv.sh
```
Download latest release by navigating to the the "latest" release page on GitHub and download the WAR file associated with the latest release. At the time this documentation was written, the latest release was v0.5.4
https://github.com/annotationsatharvard/catcha/releases/latest

If you wanted to do this from a shell on the server where you're installing the CATCH API, use wget with the following URL to get the latest WAR file.
```
$ wget https://github.com/annotationsatharvard/catcha/releases/download/v0.5.4/catch-0.5.4.war
```

Deploy WAR to Tomcat
```
$ cp catch-0.5.4.war /var/lib/tomcat7/webapps/catch.war
```

Start Tomcat
```
$ sudo service tomcat7 start
```

[optional] Lastly, tail the Tomcat catalina.out log to make sure that there are no errors.
```
$ tail -f /var/log/tomcat7/catalina.out
```