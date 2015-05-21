These instructions assume that:

* You are either a developer or sysadmin.
* You are familiar with Ubuntu, Java, MySQL, and Tomcat.
* You are installing the CATCH API on a version of Debian Linux (like Ubuntu 14.04).
* You have SSH'd onto the server to which you intend to deploy CATCH API.

# Dependencies

### Install Java 7+
```
$ sudo apt-get install openjdk-7-jre
```
### Install Tomcat 7+
```
$ sudo apt-get install tomcat7
$ sudo apt-get install tomcat7-admin
```
### Install MySQL 5.5+
```
$ sudo apt-get install mysql-server
```
# Database 

### Create the database 
```
$ mysql -u root -p -e 'create database catch default charset utf8;'
```

### Grant permissions to database user
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

### Stop tomcat7 server
```
$ sudo service tomcat7 stop
```
### Allocate memory for tomcat7 
NOTE: You will likely encounter OutOfMemoryErrors with Tomcat's default memory settings.  Therefore, we usually add a file (`/usr/share/tomcat7/bin/setenv.sh`) that is invoked by the Tomcat startup script and is used to control the amount of memory allocated to your instance of Tomcat. A very basic `setenv.sh` will look like this:  
```
export CATALINA_OPTS="-Xms512m -Xmx512m -XX:MaxPermSize=256m"
```
NOTE: You may be able to get away with using 256m as the max heap size, but 512m is a good setting, even for production environments.  Using more memory will allow you to cache more data, but does not always result in a better performing application.  So there's no need in getting carried away.  We've been using about 1024m in production for over a year and that suits us fine.

Once you've edited the file, make sure to change mod properties to allow execution of the bash script.
```
$ chmod +x /usr/share/tomcat7/bin/setenv.sh
```

### Download release
Download latest release by navigating to the the "latest" release page on GitHub and download the WAR file associated with the latest release. At the time this documentation was written, the latest release was v0.5.4
https://github.com/annotationsatharvard/catcha/releases/latest

If you wanted to do this from a shell on the server where you're installing the CATCH API, use wget with the following URL to get the latest WAR file.
```
$ wget https://github.com/annotationsatharvard/catcha/releases/download/v0.5.4/catch-0.5.4.war
```

### Deploy WAR to Tomcat
```
$ cp catch-0.5.4.war /var/lib/tomcat7/webapps/catch.war
```

### Start Tomcat
```
$ sudo service tomcat7 start
```

### Tail catalina.out
[optional] Lastly, tail the Tomcat catalina.out log to make sure that there are no errors.
```
$ tail -f /var/log/tomcat7/catalina.out
Using configuration locations [file:./catch-config.properties, file:./catch-config.groovy, classpath:catch-config.properties, classpath:catch-config.groovy, file:/home/jmiranda/.grails/catch-config.properties, file:/home/jmiranda/.grails/catch-config.groovy]
| Running Grails application
2015-05-15 11:01:46,958 [localhost-startStop-1] INFO  context.ContextLoader  - Root WebApplicationContext: initialization started
2015-05-15 11:01:46,971 [localhost-startStop-1] INFO  support.XmlWebApplicationContext  - Refreshing Root WebApplicationContext: startup date [Fri May 15 11:01:46 EDT 2015]; root of context hierarchy
2015-05-15 11:01:47,001 [localhost-startStop-1] INFO  xml.XmlBeanDefinitionReader  - Loading XML bean definitions from ServletContext resource [/WEB-INF/applicationContext.xml]
2015-05-15 11:01:47,097 [localhost-startStop-1] INFO  support.DefaultListableBeanFactory  - Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@7ba606ec: defining beans [grailsApplication,pluginManager,grailsConfigurator,grailsResourceLoader,characterEncodingFilter]; root of factory hierarchy
2015-05-15 11:01:48,313 [localhost-startStop-1] INFO  context.ContextLoader  - Root WebApplicationContext: initialization completed in 1355 ms

Configuring Spring Security Core ...
... finished configuring Spring Security Core

Configuring Spring Security OpenID ...
... finished configuring Spring Security OpenID
2015-05-15 11:01:50,034 [localhost-startStop-1] DEBUG pool.PooledConnection  - Instantiating driver using class: com.mysql.jdbc.Driver [url=jdbc:mysql://localhost:3306/catch_10apr2015?autoReconnect=true&zeroDateTimeBehavior=convertToNull&sessionVariables=storage_engine=InnoDB]
2015-05-15 11:01:50,219 [localhost-startStop-1] DEBUG pool.PooledConnection  - Instantiating driver using class: com.mysql.jdbc.Driver [url=jdbc:mysql://localhost:3306/catch_10apr2015?autoReconnect=true&zeroDateTimeBehavior=convertToNull&sessionVariables=storage_engine=InnoDB]
2015-05-15 11:01:50,224 [localhost-startStop-1] DEBUG pool.PooledConnection  - Instantiating driver using class: com.mysql.jdbc.Driver [url=jdbc:mysql://localhost:3306/catch_10apr2015?autoReconnect=true&zeroDateTimeBehavior=convertToNull&sessionVariables=storage_engine=InnoDB]
2015-05-15 11:01:50,229 [localhost-startStop-1] DEBUG pool.PooledConnection  - Instantiating driver using class: com.mysql.jdbc.Driver [url=jdbc:mysql://localhost:3306/catch_10apr2015?autoReconnect=true&zeroDateTimeBehavior=convertToNull&sessionVariables=storage_engine=InnoDB]
2015-05-15 11:01:50,234 [localhost-startStop-1] DEBUG pool.PooledConnection  - Instantiating driver using class: com.mysql.jdbc.Driver [url=jdbc:mysql://localhost:3306/catch_10apr2015?autoReconnect=true&zeroDateTimeBehavior=convertToNull&sessionVariables=storage_engine=InnoDB]
2015-05-15 11:01:50,239 [localhost-startStop-1] DEBUG pool.PooledConnection  - Instantiating driver using class: com.mysql.jdbc.Driver [url=jdbc:mysql://localhost:3306/catch_10apr2015?autoReconnect=true&zeroDateTimeBehavior=convertToNull&sessionVariables=storage_engine=InnoDB]
2015-05-15 11:01:50,244 [localhost-startStop-1] DEBUG pool.PooledConnection  - Instantiating driver using class: com.mysql.jdbc.Driver [url=jdbc:mysql://localhost:3306/catch_10apr2015?autoReconnect=true&zeroDateTimeBehavior=convertToNull&sessionVariables=storage_engine=InnoDB]
2015-05-15 11:01:50,249 [localhost-startStop-1] DEBUG pool.PooledConnection  - Instantiating driver using class: com.mysql.jdbc.Driver [url=jdbc:mysql://localhost:3306/catch_10apr2015?autoReconnect=true&zeroDateTimeBehavior=convertToNull&sessionVariables=storage_engine=InnoDB]
2015-05-15 11:01:50,254 [localhost-startStop-1] DEBUG pool.PooledConnection  - Instantiating driver using class: com.mysql.jdbc.Driver [url=jdbc:mysql://localhost:3306/catch_10apr2015?autoReconnect=true&zeroDateTimeBehavior=convertToNull&sessionVariables=storage_engine=InnoDB]
2015-05-15 11:01:50,259 [localhost-startStop-1] DEBUG pool.PooledConnection  - Instantiating driver using class: com.mysql.jdbc.Driver [url=jdbc:mysql://localhost:3306/catch_10apr2015?autoReconnect=true&zeroDateTimeBehavior=convertToNull&sessionVariables=storage_engine=InnoDB]
2015-05-15 11:01:50,264 [localhost-startStop-1] DEBUG pool.PooledConnection  - Instantiating driver using class: com.mysql.jdbc.Driver [url=jdbc:mysql://localhost:3306/catch_10apr2015?autoReconnect=true&zeroDateTimeBehavior=convertToNull&sessionVariables=storage_engine=InnoDB]
2015-05-15 11:01:50,269 [localhost-startStop-1] DEBUG pool.PooledConnection  - Instantiating driver using class: com.mysql.jdbc.Driver [url=jdbc:mysql://localhost:3306/catch_10apr2015?autoReconnect=true&zeroDateTimeBehavior=convertToNull&sessionVariables=storage_engine=InnoDB]
2015-05-15 11:01:50,274 [localhost-startStop-1] DEBUG pool.PooledConnection  - Instantiating driver using class: com.mysql.jdbc.Driver [url=jdbc:mysql://localhost:3306/catch_10apr2015?autoReconnect=true&zeroDateTimeBehavior=convertToNull&sessionVariables=storage_engine=InnoDB]
2015-05-15 11:01:50,279 [localhost-startStop-1] DEBUG pool.PooledConnection  - Instantiating driver using class: com.mysql.jdbc.Driver [url=jdbc:mysql://localhost:3306/catch_10apr2015?autoReconnect=true&zeroDateTimeBehavior=convertToNull&sessionVariables=storage_engine=InnoDB]
2015-05-15 11:01:50,284 [localhost-startStop-1] DEBUG pool.PooledConnection  - Instantiating driver using class: com.mysql.jdbc.Driver [url=jdbc:mysql://localhost:3306/catch_10apr2015?autoReconnect=true&zeroDateTimeBehavior=convertToNull&sessionVariables=storage_engine=InnoDB]
2015-05-15 11:01:50,290 [localhost-startStop-1] DEBUG pool.PooledConnection  - Instantiating driver using class: com.mysql.jdbc.Driver [url=jdbc:mysql://localhost:3306/catch_10apr2015?autoReconnect=true&zeroDateTimeBehavior=convertToNull&sessionVariables=storage_engine=InnoDB]
2015-05-15 11:01:50,295 [localhost-startStop-1] DEBUG pool.PooledConnection  - Instantiating driver using class: com.mysql.jdbc.Driver [url=jdbc:mysql://localhost:3306/catch_10apr2015?autoReconnect=true&zeroDateTimeBehavior=convertToNull&sessionVariables=storage_engine=InnoDB]
2015-05-15 11:01:50,301 [localhost-startStop-1] DEBUG pool.PooledConnection  - Instantiating driver using class: com.mysql.jdbc.Driver [url=jdbc:mysql://localhost:3306/catch_10apr2015?autoReconnect=true&zeroDateTimeBehavior=convertToNull&sessionVariables=storage_engine=InnoDB]
2015-05-15 11:01:50,306 [localhost-startStop-1] DEBUG pool.PooledConnection  - Instantiating driver using class: com.mysql.jdbc.Driver [url=jdbc:mysql://localhost:3306/catch_10apr2015?autoReconnect=true&zeroDateTimeBehavior=convertToNull&sessionVariables=storage_engine=InnoDB]
2015-05-15 11:01:50,311 [localhost-startStop-1] DEBUG pool.PooledConnection  - Instantiating driver using class: com.mysql.jdbc.Driver [url=jdbc:mysql://localhost:3306/catch_10apr2015?autoReconnect=true&zeroDateTimeBehavior=convertToNull&sessionVariables=storage_engine=InnoDB]
2015-05-15 11:01:50,316 [localhost-startStop-1] DEBUG pool.PooledConnection  - Instantiating driver using class: com.mysql.jdbc.Driver [url=jdbc:mysql://localhost:3306/catch_10apr2015?autoReconnect=true&zeroDateTimeBehavior=convertToNull&sessionVariables=storage_engine=InnoDB]
2015-05-15 11:01:50,320 [localhost-startStop-1] DEBUG pool.PooledConnection  - Instantiating driver using class: com.mysql.jdbc.Driver [url=jdbc:mysql://localhost:3306/catch_10apr2015?autoReconnect=true&zeroDateTimeBehavior=convertToNull&sessionVariables=storage_engine=InnoDB]
2015-05-15 11:01:50,325 [localhost-startStop-1] DEBUG pool.PooledConnection  - Instantiating driver using class: com.mysql.jdbc.Driver [url=jdbc:mysql://localhost:3306/catch_10apr2015?autoReconnect=true&zeroDateTimeBehavior=convertToNull&sessionVariables=storage_engine=InnoDB]
2015-05-15 11:01:50,329 [localhost-startStop-1] DEBUG pool.PooledConnection  - Instantiating driver using class: com.mysql.jdbc.Driver [url=jdbc:mysql://localhost:3306/catch_10apr2015?autoReconnect=true&zeroDateTimeBehavior=convertToNull&sessionVariables=storage_engine=InnoDB]
2015-05-15 11:01:50,334 [localhost-startStop-1] DEBUG pool.PooledConnection  - Instantiating driver using class: com.mysql.jdbc.Driver [url=jdbc:mysql://localhost:3306/catch_10apr2015?autoReconnect=true&zeroDateTimeBehavior=convertToNull&sessionVariables=storage_engine=InnoDB]
2015-05-15 11:01:50,416 [localhost-startStop-1] INFO  common.Version  - Hibernate Commons Annotations 3.2.0.Final
2015-05-15 11:01:50,421 [localhost-startStop-1] INFO  cfg.Environment  - Hibernate 3.6.10.Final
2015-05-15 11:01:50,423 [localhost-startStop-1] INFO  cfg.Environment  - hibernate.properties not found
2015-05-15 11:01:50,425 [localhost-startStop-1] INFO  cfg.Environment  - Bytecode provider name : javassist
2015-05-15 11:01:50,428 [localhost-startStop-1] INFO  cfg.Environment  - using JDK 1.4 java.sql.Timestamp handling
2015-05-15 11:01:50,588 [localhost-startStop-1] INFO  cfg.Configuration  - Hibernate Validator not found: ignoring
2015-05-15 11:01:50,599 [localhost-startStop-1] INFO  util.Version  - Hibernate Validator 4.1.0.Final
2015-05-15 11:01:50,609 [localhost-startStop-1] INFO  resolver.DefaultTraversableResolver  - Instantiated an instance of org.hibernate.validator.engine.resolver.JPATraversableResolver.
2015-05-15 11:01:50,695 [localhost-startStop-1] INFO  resolver.DefaultTraversableResolver  - Instantiated an instance of org.hibernate.validator.engine.resolver.JPATraversableResolver.
2015-05-15 11:01:50,715 [localhost-startStop-1] INFO  resolver.DefaultTraversableResolver  - Instantiated an instance of org.hibernate.validator.engine.resolver.JPATraversableResolver.
2015-05-15 11:01:50,719 [localhost-startStop-1] INFO  search.HibernateSearchEventListenerRegister  - Unable to find org.hibernate.search.event.FullTextIndexEventListener on the classpath. Hibernate Search is not enabled.
2015-05-15 11:01:50,748 [localhost-startStop-1] INFO  connection.ConnectionProviderFactory  - Initializing connection provider: org.springframework.orm.hibernate3.LocalDataSourceConnectionProvider
2015-05-15 11:01:50,752 [localhost-startStop-1] INFO  dialect.Dialect  - Using dialect: org.hibernate.dialect.MySQL5InnoDBDialect
2015-05-15 11:01:50,763 [localhost-startStop-1] INFO  cfg.SettingsFactory  - Database ->
       name : MySQL
    version : 5.5.41-MariaDB-1ubuntu0.14.10.1-log
      major : 5
      minor : 5
2015-05-15 11:01:50,763 [localhost-startStop-1] INFO  cfg.SettingsFactory  - Driver ->
       name : MySQL Connector Java
    version : mysql-connector-java-5.1.32 ( Revision: jess.balint@oracle.com-20140716155848-mlwabor66widht1n )
      major : 5
      minor : 1
2015-05-15 11:01:50,765 [localhost-startStop-1] INFO  transaction.TransactionFactoryFactory  - Transaction strategy: org.springframework.orm.hibernate3.SpringTransactionFactory
2015-05-15 11:01:50,768 [localhost-startStop-1] INFO  transaction.TransactionManagerLookupFactory  - No TransactionManagerLookup configured (in JTA environment, use of read-write or transactional second-level cache is not recommended)
2015-05-15 11:01:50,769 [localhost-startStop-1] INFO  cfg.SettingsFactory  - Automatic flush during beforeCompletion(): disabled
2015-05-15 11:01:50,769 [localhost-startStop-1] INFO  cfg.SettingsFactory  - Automatic session close at end of transaction: disabled
2015-05-15 11:01:50,769 [localhost-startStop-1] INFO  cfg.SettingsFactory  - JDBC batch size: 15
2015-05-15 11:01:50,769 [localhost-startStop-1] INFO  cfg.SettingsFactory  - JDBC batch updates for versioned data: disabled
2015-05-15 11:01:50,770 [localhost-startStop-1] INFO  cfg.SettingsFactory  - Scrollable result sets: enabled
2015-05-15 11:01:50,770 [localhost-startStop-1] INFO  cfg.SettingsFactory  - JDBC3 getGeneratedKeys(): enabled
2015-05-15 11:01:50,770 [localhost-startStop-1] INFO  cfg.SettingsFactory  - Connection release mode: auto
2015-05-15 11:01:50,770 [localhost-startStop-1] INFO  cfg.SettingsFactory  - Maximum outer join fetch depth: 2
2015-05-15 11:01:50,770 [localhost-startStop-1] INFO  cfg.SettingsFactory  - Default batch fetch size: 1
2015-05-15 11:01:50,770 [localhost-startStop-1] INFO  cfg.SettingsFactory  - Generate SQL with comments: disabled
2015-05-15 11:01:50,770 [localhost-startStop-1] INFO  cfg.SettingsFactory  - Order SQL updates by primary key: disabled
2015-05-15 11:01:50,770 [localhost-startStop-1] INFO  cfg.SettingsFactory  - Order SQL inserts for batching: disabled
2015-05-15 11:01:50,770 [localhost-startStop-1] INFO  cfg.SettingsFactory  - Query translator: org.hibernate.hql.ast.ASTQueryTranslatorFactory
2015-05-15 11:01:50,772 [localhost-startStop-1] INFO  ast.ASTQueryTranslatorFactory  - Using ASTQueryTranslatorFactory
2015-05-15 11:01:50,772 [localhost-startStop-1] INFO  cfg.SettingsFactory  - Query language substitutions: {}
2015-05-15 11:01:50,772 [localhost-startStop-1] INFO  cfg.SettingsFactory  - JPA-QL strict compliance: disabled
2015-05-15 11:01:50,772 [localhost-startStop-1] INFO  cfg.SettingsFactory  - Second-level cache: enabled
2015-05-15 11:01:50,772 [localhost-startStop-1] INFO  cfg.SettingsFactory  - Query cache: disabled
2015-05-15 11:01:50,772 [localhost-startStop-1] INFO  cfg.SettingsFactory  - Cache region factory : net.sf.ehcache.hibernate.EhCacheRegionFactory
2015-05-15 11:01:50,779 [localhost-startStop-1] INFO  cfg.SettingsFactory  - Optimize cache for minimal puts: enabled
2015-05-15 11:01:50,780 [localhost-startStop-1] INFO  cfg.SettingsFactory  - Structured second-level cache entries: disabled
2015-05-15 11:01:50,783 [localhost-startStop-1] INFO  cfg.SettingsFactory  - Echoing all SQL to stdout
2015-05-15 11:01:50,783 [localhost-startStop-1] INFO  cfg.SettingsFactory  - Statistics: disabled
2015-05-15 11:01:50,783 [localhost-startStop-1] INFO  cfg.SettingsFactory  - Deleted entity synthetic identifier rollback: disabled
2015-05-15 11:01:50,784 [localhost-startStop-1] INFO  cfg.SettingsFactory  - Default entity-mode: pojo
2015-05-15 11:01:50,784 [localhost-startStop-1] INFO  cfg.SettingsFactory  - Named query checking : enabled
2015-05-15 11:01:50,784 [localhost-startStop-1] INFO  cfg.SettingsFactory  - Check Nullability in Core (should be disabled when Bean Validation is on): disabled
2015-05-15 11:01:50,796 [localhost-startStop-1] INFO  impl.SessionFactoryImpl  - building session factory
2015-05-15 11:01:50,799 [localhost-startStop-1] INFO  type.BasicTypeRegistry  - Type registration [clob] overrides previous : org.hibernate.type.ClobType@2b3bd34
2015-05-15 11:01:50,799 [localhost-startStop-1] INFO  type.BasicTypeRegistry  - Type registration [java.sql.Clob] overrides previous : org.hibernate.type.ClobType@2b3bd34
2015-05-15 11:01:50,799 [localhost-startStop-1] INFO  type.BasicTypeRegistry  - Type registration [blob] overrides previous : org.hibernate.type.BlobType@664aa24e
2015-05-15 11:01:50,799 [localhost-startStop-1] INFO  type.BasicTypeRegistry  - Type registration [java.sql.Blob] overrides previous : org.hibernate.type.BlobType@664aa24e
2015-05-15 11:01:50,799 [localhost-startStop-1] INFO  type.BasicTypeRegistry  - Type registration [characters_clob] overrides previous : org.hibernate.type.PrimitiveCharacterArrayClobType@2de5e359
2015-05-15 11:01:50,799 [localhost-startStop-1] INFO  type.BasicTypeRegistry  - Type registration [wrapper_materialized_blob] overrides previous : org.hibernate.type.WrappedMaterializedBlobType@4fb0ff99
2015-05-15 11:01:50,799 [localhost-startStop-1] INFO  type.BasicTypeRegistry  - Type registration [wrapper_characters_clob] overrides previous : org.hibernate.type.CharacterArrayClobType@6d5cbeae
2015-05-15 11:01:50,799 [localhost-startStop-1] INFO  type.BasicTypeRegistry  - Type registration [materialized_clob] overrides previous : org.hibernate.type.MaterializedClobType@63eac999
2015-05-15 11:01:50,799 [localhost-startStop-1] INFO  type.BasicTypeRegistry  - Type registration [materialized_blob] overrides previous : org.hibernate.type.MaterializedBlobType@4b598f0e
2015-05-15 11:01:50,904 [localhost-startStop-1] WARN  id.UUIDHexGenerator  - Using org.hibernate.id.UUIDHexGenerator which does not generate IETF RFC 4122 compliant UUID values; consider using org.hibernate.id.UUIDGenerator instead
2015-05-15 11:01:51,514 [localhost-startStop-1] INFO  impl.SessionFactoryObjectFactory  - Not binding factory to JNDI, no JNDI name configured
2015-05-15 11:01:54,577 [localhost-startStop-1] INFO  support.DefaultListableBeanFactory  - Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@6890c309: defining beans [org.grails.plugin.resource.CSSRewriterResourceMapper,org.grails.plugin.resource.BundleResourceMapperInstance,org.grails.plugin.resource.CSSRewriterResourceMapperInstance,org.grails.plugin.resource.BundleResourceMapper,org.grails.plugin.resource.BaseUrlResourceMapperInstance,org.grails.plugin.resource.BaseUrlResourceMapper,org.grails.plugin.resource.CSSPreprocessorResourceMapperInstance,org.grails.plugin.resource.CSSPreprocessorResourceMapper]; parent: org.codehaus.groovy.grails.commons.spring.ReloadAwareAutowireCapableBeanFactory@6709736f
2015-05-15 11:01:55,990 [localhost-startStop-1] WARN  intercept.AnnotationFilterInvocationDefinition  - replaced rule for '/annotator/**' with tokens [permitAll] with tokens [IS_AUTHENTICATED_ANONYMOUSLY]
2015-05-15 11:01:56,704 [localhost-startStop-1] INFO  dialect.Dialect  - Using dialect: org.hibernate.dialect.MySQL5InnoDBDialect
2015-05-15 11:01:58,873 [localhost-startStop-1] INFO  liquibase  - Reading from `DATABASECHANGELOG`
2015-05-15 11:01:59,067 [localhost-startStop-1] WARN  liquibase  - modifyDataType will lose primary key/autoincrement/not null settings for mysql.  Use <sql> and re-specify all configuration if this is the case
2015-05-15 11:01:59,067 [localhost-startStop-1] WARN  liquibase  - modifyDataType will lose primary key/autoincrement/not null settings for mysql.  Use <sql> and re-specify all configuration if this is the case
2015-05-15 11:01:59,067 [localhost-startStop-1] WARN  liquibase  - modifyDataType will lose primary key/autoincrement/not null settings for mysql.  Use <sql> and re-specify all configuration if this is the case
2015-05-15 11:01:59,067 [localhost-startStop-1] WARN  liquibase  - modifyDataType will lose primary key/autoincrement/not null settings for mysql.  Use <sql> and re-specify all configuration if this is the case
2015-05-15 11:01:59,068 [localhost-startStop-1] WARN  liquibase  - modifyDataType will lose primary key/autoincrement/not null settings for mysql.  Use <sql> and re-specify all configuration if this is the case
2015-05-15 11:01:59,068 [localhost-startStop-1] WARN  liquibase  - modifyDataType will lose primary key/autoincrement/not null settings for mysql.  Use <sql> and re-specify all configuration if this is the case
2015-05-15 11:01:59,068 [localhost-startStop-1] WARN  liquibase  - modifyDataType will lose primary key/autoincrement/not null settings for mysql.  Use <sql> and re-specify all configuration if this is the case
2015-05-15 11:01:59,069 [localhost-startStop-1] INFO  databasemigration.MigrationRunner  - No migrations to run for DataSource 'dataSource'
2015-05-15 11:01:59,196 [localhost-startStop-1] INFO  web.DefaultSecurityFilterChain  - Creating filter chain: Ant [pattern='/**'], [org.springframework.security.web.context.SecurityContextPersistenceFilter@767933a2, grails.plugin.springsecurity.web.authentication.logout.MutableLogoutFilter@56cdbf26, grails.plugin.springsecurity.web.authentication.RequestHolderAuthenticationFilter@a2e8e9f, org.springframework.security.openid.OpenIDAuthenticationFilter@76956df1, org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter@4c652609, grails.plugin.springsecurity.web.filter.GrailsRememberMeAuthenticationFilter@4a4400e, grails.plugin.springsecurity.web.filter.GrailsAnonymousAuthenticationFilter@3b695983, org.springframework.security.web.access.ExceptionTranslationFilter@173c5ee, org.springframework.security.web.access.intercept.FilterSecurityInterceptor@57c78d00]
Using configuration locations: [file:./catch-config.properties, file:./catch-config.groovy, classpath:catch-config.properties, classpath:catch-config.groovy, file:/home/jmiranda/.grails/catch-config.properties, file:/home/jmiranda/.grails/catch-config.groovy]
2015-05-15 11:01:59,915 [localhost-startStop-1] INFO  conf.BootStrap  - ------------------------------------------------------------------------
2015-05-15 11:01:59,915 [localhost-startStop-1] INFO  conf.BootStrap  - >> INITIALIZING DEFAULTS
2015-05-15 11:01:59,915 [localhost-startStop-1] INFO  conf.BootStrap  - ------------------------------------------------------------------------
2015-05-15 11:01:59,915 [localhost-startStop-1] INFO  conf.BootStrap  - ** Users Roles
2015-05-15 11:02:00,000 [localhost-startStop-1] INFO  conf.BootStrap  - ------------------------------------------------------------------------
2015-05-15 11:02:00,000 [localhost-startStop-1] INFO  conf.BootStrap  - ** Groups Roles
2015-05-15 11:02:00,035 [localhost-startStop-1] INFO  conf.BootStrap  - ------------------------------------------------------------------------
2015-05-15 11:02:00,035 [localhost-startStop-1] INFO  conf.BootStrap  - ** Groups Status
2015-05-15 11:02:00,067 [localhost-startStop-1] INFO  conf.BootStrap  - ------------------------------------------------------------------------
2015-05-15 11:02:00,067 [localhost-startStop-1] INFO  conf.BootStrap  - ** Groups Privacy
2015-05-15 11:02:00,100 [localhost-startStop-1] INFO  conf.BootStrap  - ------------------------------------------------------------------------
2015-05-15 11:02:00,100 [localhost-startStop-1] INFO  conf.BootStrap  - ** User Status in Group
2015-05-15 11:02:00,134 [localhost-startStop-1] INFO  conf.BootStrap  - ------------------------------------------------------------------------
2015-05-15 11:02:00,134 [localhost-startStop-1] INFO  conf.BootStrap  - >> USERS
2015-05-15 11:02:00,134 [localhost-startStop-1] INFO  conf.BootStrap  - ------------------------------------------------------------------------
2015-05-15 11:02:00,134 [localhost-startStop-1] INFO  conf.BootStrap  - ** Users
2015-05-15 11:02:00,134 [localhost-startStop-1] INFO  conf.BootStrap  - Initializing: admin
2015-05-15 11:02:00,185 [localhost-startStop-1] INFO  conf.BootStrap  - Initializing: user
2015-05-15 11:02:00,189 [localhost-startStop-1] INFO  conf.BootStrap  - ------------------------------------------------------------------------
2015-05-15 11:02:00,189 [localhost-startStop-1] INFO  conf.BootStrap  - >> GROUPS

```
