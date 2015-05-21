

## Using the Command Line
Upgrading the CATCH API from the command line is fairly straightforward if you've ever worked with Tomcat before. 

### Backup WAR
This is a precaution in case you need to rollback to the previous version after a failed deployment.
```
sudo cp /var/lib/tomcat7/webapps/catch.war <backup-directory>

```


### Backup database
This is an extra precaution just in case there are database migrations that fail and you need to rollback to the previous version.
```
$ mysqldump -u catch -p catch > <backup-directory>/catch-<year>-<month>-<day>.sql 
```


### Stop Tomcat
```
$ sudo server tomcat7 stop
```

### Undeploy the application
```
$ sudo rm -rf /var/lib/tomcat7/webapps/catch
$ sudo rm -rf /var/lib/tomcat7/webapps/catch.war
```

### Deploy the new application
```
$ sudo cp catch-<version>.war /usr/lib/tomcat7/webapps/catch.war
```

### Start tomcat
```
$ sudo service tomcat7 start
```

### Tail catalina.out 
The reason you want to tail the log file is to ensure that all Liquibase database migration changesets go through. The log below shows that there were no database migrations for this version of the 
```
$ tail -f /var/log/tomcat7/catalina.out
Using configuration locations [file:./catch-config.properties, file:./catch-config.groovy, classpath:catch-config.properties, classpath:catch-config.groovy, file:/home/jmiranda/.grails/catch-config.properties, file:/home/jmiranda/.grails/catch-config.groovy]

2015-05-15 11:01:58,873 [localhost-startStop-1] INFO  liquibase  - Reading from `DATABASECHANGELOG`
2015-05-15 11:01:59,067 [localhost-startStop-1] WARN  liquibase  - modifyDataType will lose primary key/autoincrement/not null settings for mysql.  Use <sql> and re-specify all configuration if this is the case
2015-05-15 11:01:59,067 [localhost-startStop-1] WARN  liquibase  - modifyDataType will lose primary key/autoincrement/not null settings for mysql.  Use <sql> and re-specify all configuration if this is the case
2015-05-15 11:01:59,067 [localhost-startStop-1] WARN  liquibase  - modifyDataType will lose primary key/autoincrement/not null settings for mysql.  Use <sql> and re-specify all configuration if this is the case
2015-05-15 11:01:59,067 [localhost-startStop-1] WARN  liquibase  - modifyDataType will lose primary key/autoincrement/not null settings for mysql.  Use <sql> and re-specify all configuration if this is the case
2015-05-15 11:01:59,068 [localhost-startStop-1] WARN  liquibase  - modifyDataType will lose primary key/autoincrement/not null settings for mysql.  Use <sql> and re-specify all configuration if this is the case
2015-05-15 11:01:59,068 [localhost-startStop-1] WARN  liquibase  - modifyDataType will lose primary key/autoincrement/not null settings for mysql.  Use <sql> and re-specify all configuration if this is the case
2015-05-15 11:01:59,068 [localhost-startStop-1] WARN  liquibase  - modifyDataType will lose primary key/autoincrement/not null settings for mysql.  Use <sql> and re-specify all configuration if this is the case
2015-05-15 11:01:59,069 [localhost-startStop-1] INFO  databasemigration.MigrationRunner  - No migrations to run for DataSource 'dataSource'
...
INFO: Deployment of web application archive /var/lib/tomcat7/webapps/catch.war has finished in 88,304 ms
May 21, 2015 1:51:35 PM org.apache.coyote.AbstractProtocol start
INFO: Starting ProtocolHandler ["http-bio-8080"]
May 21, 2015 1:51:35 PM org.apache.catalina.startup.Catalina start
INFO: Server startup in 88663 ms
```

NOTE: Obviously, if you've changed the WAR filename to `ROOT.war` (see [Installation instructions](installation.md)) then you'll want to delete the `ROOT.war` and `ROOT` directory under `/usr/lib/tomcat7/webapps/`.


## Using Tomcat Manager
You can also upgrade the application through the Tomcat Manager app. 

### Undeploy the current version of the application

![Screenshot](/img/tomcat/undeploy-war.png)


### Deploy the latest version of the application

![Screenshot](/img/tomcat/deploy-war-1.png)

### Make sure the application has been deployed and is running

![Screenshot](/img/tomcat/deploy-war-2.png)

## Troubleshooting

### The request was rejected because its size (XXX) exceeds the configured maximum (52428800)

#### Problem

![Screenshot](/img/tomcat/exceed-file-size-limit.png)

#### Solution
Edit **/usr/share/tomcat7-admin/manager/WEB-INF/web.xml** 
```
    <servlet>
        <servlet-name>HTMLManager</servlet-name>
        <servlet-class>org.apache.catalina.manager.HTMLManagerServlet</servlet-class>
        <init-param>
          <param-name>debug</param-name>
          <param-value>2</param-value>
        </init-param>
        <!-- Uncomment this to show proxy sessions from the Backup manager or a
             StoreManager in the sessions list for an application
        <init-param>
          <param-name>showProxySessions</param-name>
          <param-value>true</param-value>
        </init-param>
        -->
        <multipart-config>
          <!-- 50MB max -->
          <max-file-size>52428800</max-file-size>
          <max-request-size>52428800</max-request-size>
          <file-size-threshold>0</file-size-threshold>
        </multipart-config>
    </servlet>
```
Increase the max-file-size and max-request-size from 50MB to 100MB:
```
    <multipart-config>
        <!-- 100MB max -->
        <max-file-size>104857600</max-file-size>
        <max-request-size>104857600</max-request-size>
        <file-size-threshold>0</file-size-threshold>
    </multipart-config>
```


