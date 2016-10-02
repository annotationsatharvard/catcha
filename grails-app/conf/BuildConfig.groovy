grails.servlet.version = "3.0" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

// uncomment (and adjust settings) to fork the JVM to isolate classpaths
//grails.project.fork = [
//   run: [maxMemory:1024, minMemory:64, debug:false, maxPerm:256]
//]

grails.plugin.location.'af-shared' = 'plugins/AfShared'
grails.plugin.location.'af-security' = 'plugins/AfSecurity'
grails.plugin.location.'af-persistence' = 'plugins/AfPersistence'

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // specify dependency exclusions here; for example, uncomment this to disable ehcache:
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve
    legacyResolve false // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

    repositories {
        inherits true // Whether to inherit repository definitions from plugins

        grailsPlugins()
        grailsHome()
        grailsCentral()

        mavenLocal()
        mavenCentral()

        // uncomment these (or add new ones) to enable remote dependency resolution from public Maven repositories
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
        mavenRepo 'http://repo.spring.io/milestone'
        mavenRepo "http://mavenrepo.fzi.de/semweb4j.org/repo/"
        mavenRepo "https://repository.jboss.org/nexus/content/repositories/thirdparty-releases"
        mavenRepo "https://repo.grails.org/grails/plugins"
        //mavenRepo "http://repo.aduna-software.org/maven2/releases/"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.
        runtime 'mysql:mysql-connector-java:5.1.32'

        compile ("org.semweb4j:rdf2go.api:4.8.3") {
            excludes 'slf4j-api'
        }
        compile ("org.semweb4j:rdf2go.impl.sesame:4.8.3") {
            excludes 'slf4j-api'
            //excludes "sesame-runtime-osgi"
        }

		compile "org.apache.marmotta:sesame-tools-rio-jsonld:3.0.0-incubating"

		compile ("org.apache.jena:jena-core:2.11.0") {
			excludes 'slf4j-api', 'xercesImpl'
		}
		compile ("org.apache.jena:jena-arq:2.9.3")


        compile("org.apache.httpcomponents:httpcore:4.4.1")
        runtime 'joda-time:joda-time:2.9.4'

        // Commented this out because this dependency should be brought in with the compile scope above.
        //runtime "org.semweb4j:rdf2go.api:4.8.2"
		//runtime "org.semweb4j:rdf2go.impl.sesame:4.8.2"

        //runtime "org.semweb4j:rdf2go.impl.base:4.6.2"
		//compile "org.openrdf:openrdf-sesame-onejar-osgi:2.1.2"
		//compile "org.openrdf.sesame:sesame-query:2.7.2"
    }

    plugins {
        runtime ":hibernate:$grailsVersion"
        runtime ":jquery:1.8.3"
        runtime ":resources:1.2.6"
        runtime ":cors:1.1.3"
        runtime ":httplogger:1.1"

        // Uncomment these (or add new ones) to enable additional resources capabilities
        //runtime ":zipped-resources:1.0"
        //runtime ":cached-resources:1.0"
        //runtime ":yui-minify-resources:0.1.5"

        build ":tomcat:$grailsVersion"
        runtime ":database-migration:1.3.8"

        compile ':cache:1.1.1'
        rumtime ":svn:1.0.2"

        //compile ":joda-time:1.4"
        //compile "org.grails.plugins:spring-security-facebook:0.11"

        //compile ":functional-test:1.2.7"
		compile ':spring-security-core:2.0-RC2'
		compile ":spring-security-openid:2.0-RC2"
        compile ":build-test-data:2.2.3"
        compile ":joda-time:1.4"
        compile ":jdbc-pool:7.0.47"

//        compile (":functional-test:1.2.7") {
//            excludes "commons-codec"
//        }

        // #21 Keep this here so commons-codec:1.3 does not get included
        compile (":functional-test:2.0.RC1") {
            excludes "commons-codec"
        }
    }
}
