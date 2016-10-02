[![Stories in Ready](https://badge.waffle.io/annotationsatharvard/catcha.png?label=ready&title=Ready)](https://waffle.io/annotationsatharvard/catcha)
[![Build Status](https://travis-ci.org/annotationsatharvard/catcha.svg?branch=master)](https://travis-ci.org/annotationsatharvard/catcha)
[![Documentation Status](https://readthedocs.org/projects/catcha/badge/?version=latest)](http://catcha.readthedocs.io/en/latest/?badge=latest)

catcha
======

Catching Annotation (Catch-A)

This software was created for the Harvard Library Labs project CATCH (https://osc.hul.harvard.edu/liblab/proj/catch) awarded to Phil Desenne, Martin Schreiner and Paolo Ciccarese

The software was originally written by:
* Dr. Paolo Ciccarese http://paolociccarese.info
* Justin Miranda https://github.com/jmiranda

You can find the core plugin dependencies at [https://github.com/annotationframework](https://github.com/annotationframework).

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
There are several plugins that are included as "local plugin" dependencies within the application's `BuildConfig.groovy`. It's important that the root directory of these plugins (`annotationframework`) is located at the same level as the `catcha` directory.  
```
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


## Develop with Docker

When developing with Docker, all the dependencies are included in docker images. No need to install anything on the host other than (docker)[https://docs.docker.com/engine/installation/]

NOTE: This repo has submodules. If `--recursive` is not specified when cloning the repo, you need to run `git submodule update --init` to pull down the submodules.

### Update configruation

Update the following line in `catch-config.properties`:

```
dataSource.url=jdbc:mysql://localhost:3306/catch_test?useUnicode=yes&characterEncoding=UTF-8&autoReconnect=true
```
To
```
dataSource.url=jdbc:mysql://db:3306/catch?useUnicode=yes&characterEncoding=UTF-8&autoReconnect=true
```

### Start application

```
docker-compose up -d
```

Docker will download official MySQL image and build catcha image. Docker-compose will create a docker network and run both images. Once they are started, the application can be accessed at http://localhost:8080.

Once the docker containers are running, you can make changes to the files on the host and they will be auto-reloaded.

### Check logs

```
docker logs -f catch_app_1
```

### Stop application

```
docker-compose stop
```

### Tear down application

```
docker-compose down
```
