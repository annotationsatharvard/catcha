catcha
======

Catch-a - Catching annotation

This software was created for the Harvard Library Labs project CATCH (https://osc.hul.harvard.edu/liblab/proj/catch) awarded to Phil Desenne, Martin Schreiner and Paolo Ciccarese

The software was originally written by:
* Dr. Paolo Ciccarese http://paolociccarese.info
* Justin Miranda


# Getting Started

## Developer Installation

### Install dependencies
* GVM - http://gvmtool.net/
* Grails 2.2.1+
* Tomcat 6+
* MySQL 5.5+

#### Install GVM
See http://gvmtool.net/
```
$ curl -s get.gvmtool.net | bash
```

#### Install Grails
After downloading the source code check `catcha/Catch/application.properties` to find the required Grails version.
```
app.grails.version=2.2.1
```

To install the appropriate grails version:
```
$ gvm install grails 2.2.1
```

#### MySQL 
See http://dev.mysql.com/downloads/installer/. On Ubuntu 
```
sudo apt-get install mysql-server
```

### Build application from source 

#### Download application source code
```
$ git clone https://github.com/annotationsatharvard/catcha.git
```

#### Download plugin source code
It's important that these plugins are located under the `catcha/annotationframework` directory -- they are included as "local plugin" dependencies within the application's BuildConfig.groovy.
```
$ cd catcha 
$ mkdir annotationframework
$ cd annotationframework
$ git clone https://github.com/annotationframework/AfPersistence.git
$ git clone https://github.com/annotationframework/AfSecurity.git
$ git clone https://github.com/annotationframework/AfShared.git
```

##### Create database 
```
mysql -u root -p -e 'create database catch default charset utf8;'
```
##### Create database user 
```
mysql -u root -p -e 'grant all on catch.* to "catch"@"localhost" identified by "<password>";'
```

##### Create external configuration file 
If you changed the database name, username, or password you need to edit an external configuration file.

NOTE: I needed to rename the file (lowercase 'c') in order to get the application to read this file.
```
$ cd Catch
$ mv Catch-config.properties catch-config.properties
```

Add the following properties to `catcha/Catch/catch-config.properties`.
```
# Database connection settings
dataSource.url=jdbc:mysql://localhost:3306/catch?autoReconnect=true&zeroDateTimeBehavior=convertToNull&sessionVariables=storage_engine=InnoDB
dataSource.username=catch
dataSource.password=<password>
```

NOTE: Do NOT change the database name as there is a bug I just discovered in the Liquibase changesets that hard-codes the schema name to "catch" when dealing with foreign key contstraints.

### Run application in development mode
```
$ grails run-app
```







