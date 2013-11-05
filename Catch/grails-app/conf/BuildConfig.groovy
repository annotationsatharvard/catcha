grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.plugin.location.'af-shared' = '../annotationframework/AfShared'
grails.plugin.location.'af-security' = '../annotationframework/AfSecurity'
grails.plugin.location.'af-persistence' = '../annotationframework/AfPersistence'

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve

    repositories {
        inherits true // Whether to inherit repository definitions from plugins
        grailsPlugins()
        grailsHome()
        grailsCentral()
        mavenCentral()

        // uncomment these to enable remote dependency resolution from public Maven repositories
        //mavenCentral()
        //mavenLocal()
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
		mavenRepo "http://repo.aduna-software.org/maven2/releases/"
		mavenRepo "https://repository.jboss.org/nexus/content/repositories/thirdparty-releases"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.
		//provided 'mysql:mysql-connector-java:5.1.13'
		//runtime 'mysql:mysql-connector-java:5.1.13'
        runtime 'mysql:mysql-connector-java:5.1.16' 
		
		compile "org.apache.marmotta:sesame-tools-rio-jsonld:3.0.0-incubating"
		compile "org.semweb4j:rdf2go.impl.sesame:4.8.2"
		compile "org.semweb4j:rdf2go.api:4.8.2"

        // Commented this out because this dependency should be brought in with the compile scope above.
		//runtime "org.semweb4j:rdf2go.impl.sesame:4.8.2"
		//runtime "org.semweb4j:rdf2go.api:4.8.2"

        //runtime "org.semweb4j:rdf2go.impl.base:4.6.2"
		//compile "org.openrdf:openrdf-sesame-onejar-osgi:2.1.2"
		//compile "org.openrdf.sesame:sesame-query:2.7.2"
    }

    plugins {
        runtime ":hibernate:$grailsVersion"
        runtime ":jquery:1.7.1"
        runtime ":resources:1.1.6"
		
		//compile "org.grails.plugins:spring-security-facebook:0.11"

        // Uncomment these (or add new ones) to enable additional resources capabilities
        //runtime ":zipped-resources:1.0"
        //runtime ":cached-resources:1.0"
        //runtime ":yui-minify-resources:0.1.4"

        build ":tomcat:$grailsVersion"

        runtime ":cors:1.1.0"

        //compile ":joda-time:1.4"
		
		compile ':spring-security-core:2.0-RC2'
		compile ":spring-security-openid:2.0-RC2"
    }
}
