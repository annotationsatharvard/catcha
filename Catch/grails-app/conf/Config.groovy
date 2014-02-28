import grails.util.Metadata;

// Necessary for Grails 2.0 as the variable ${appName} is not available 
// anymore in the log4j closure. It needs the import above.
def appName = Metadata.current.getApplicationName();

// locations to search for config files that get merged into the main config
// config files can either be Java properties files or ConfigSlurper scripts

// See: http://stackoverflow.com/questions/3807267/grails-external-configuration-grails-config-locations-absolute-path-file
grails.config.locations = ["classpath:${appName}-config.properties", "file:./${appName}-config.properties"]

grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination
grails.mime.file.extensions = true // enables the parsing of file extensions from URLs into the request format
grails.mime.use.accept.header = false
grails.mime.types = [ html: ['text/html','application/xhtml+xml'],
                      xml: ['text/xml', 'application/xml'],
                      text: 'text/plain',
                      js: 'text/javascript',
                      rss: 'application/rss+xml',
                      atom: 'application/atom+xml',
                      css: 'text/css',
                      csv: 'text/csv',
                      all: '*/*',
                      json: ['application/json','text/json'],
                      form: 'application/x-www-form-urlencoded',
                      multipartForm: 'multipart/form-data'
                    ]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// What URL patterns should be processed by the resources plugin
grails.resources.adhoc.patterns = ['/images/*', '/css/*', '/js/*', '/plugins/*']


// The default codec used to encode data with ${}
grails.views.default.codec = "none" // none, html, base64
grails.views.gsp.encoding = "UTF-8"
grails.converters.encoding = "UTF-8"
// enable Sitemesh preprocessing of GSP pages
grails.views.gsp.sitemesh.preprocess = true
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []
// whether to disable processing of multi part requests
grails.web.disable.multipart=false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// enable query caching by default
grails.hibernate.cache.queries = true

// set per-environment serverURL stem for creating absolute links
environments {
    development {
        grails.logging.jul.usebridge = true
    }
    production {
        grails.dbconsole.enabled = true
        grails.logging.jul.usebridge = false
        // TODO: grails.serverURL = "http://www.changeme.com"

        af.shared.name = "CATCH-A"
        af.shared.title = "CATCH-A, Annotations at Harvard"

        af.shared.logo.title = "CATCH"
        af.shared.logo.subtitle = "Annotation Hub"

        af.shared.copyright.label = "Annotations @ Harvard"
        af.shared.copyright.link = "http://www.annotations.harvard.edu/"

        af.security.initialize.user=true
        af.security.moderation.user.request=true

        af.node.organization="Massachusetts General Hospital"
        af.node.administrator.name="Dr. Paolo Ciccarese"
        af.node.administrator.email.to = "paolo.ciccarese@gmail.com"
        af.node.administrator.email.display= "paolo dot ciccarese at gmail.com"

        //af.node.base.url=http://purl.org/catcha/1/
        af.node.base.url = "http://catch.aws.af.com/"


    }
}

log4j = {

    error  'org.codehaus.groovy.grails.web.servlet',        // controllers
            'org.codehaus.groovy.grails.web.pages',          // GSP
            'org.codehaus.groovy.grails.web.sitemesh',       // layouts
            'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
            'org.codehaus.groovy.grails.web.mapping',        // URL mapping
            'org.codehaus.groovy.grails.commons',            // core / classloading
            'org.codehaus.groovy.grails.plugins',            // plugins
            'org.codehaus.groovy.grails.orm.hibernate',      // hibernate integration
            'net.sf.ehcache.hibernate'

    info    'grails.app',
            'grails.app.jobs',
            'org.liquibase',
            'org.hibernate',
            'org.springframework',
            'org.springframework.security',
            'org.codehaus.groovy.grails.rest',
            'grails.plugin.databasemigration',
            'grails.plugins.httplogger',
            'org.springframework',
            'org.hibernate',
            'com.mchange',
            'grails.app.controller',
            'grails.app.bootstrap',
            'grails.app.service',
            'grails.app.task',
            'grails.plugin.springcache',
            'grails.plugin.springsecurity',
            'BootStrap',
            'liquibase'

    debug   'org.apache.tomcat.jdbc.pool',
            'org.apache.commons.dbcp'

    /*
     debug 'org.codehaus.groovy.grails.plugins.springsecurity',
           'grails.plugins.springsecurity',
           'org.springframework.security'
    */
}

// -------------------------------------------------------------------------------------------------------------------------------------------
// database-migration

grails.plugin.databasemigration.updateOnStart = true
grails.plugin.databasemigration.updateOnStartFileNames = ["changelog.groovy"]


// -------------------------------------------------------------------------------------------------------------------------------------------
// Spring Security Configuration
// The following have to be defined in the Config.groovy of the main application in order for Spring Security to work properly

grails.plugin.springsecurity.userLookup.userDomainClassName 			= 'org.mindinformatics.ann.framework.module.security.users.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName 			= 'org.mindinformatics.ann.framework.module.security.users.UserRole'
grails.plugin.springsecurity.authority.className 						= 'org.mindinformatics.ann.framework.module.security.users.Role'

// Default since spring-security-core:2.0-RC2
grails.plugin.springsecurity.password.algorithm 						= 'bcrypt' 

grails.plugin.springsecurity.rememberMe.persistent 						= true
grails.plugin.springsecurity.rememberMe.persistentToken.domainClassName = 'org.mindinformatics.ann.framework.module.security.PersistentLogin'
grails.plugin.springsecurity.openid.domainClass 						= 'org.mindinformatics.ann.framework.module.security.OpenID'

grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	'/info'					: ['permitAll'],
	'/main/**'				: ['ROLE_ADMIN', 'ROLE_MANAGER', 'ROLE_USER'],
	'/secure/**'			: ['ROLE_ADMIN', 'ROLE_MANAGER', 'ROLE_USER'],
	'/upload/**'			: ['ROLE_ADMIN', 'ROLE_MANAGER', 'ROLE_USER'],
	'/tripleStore/**'		: ['ROLE_ADMIN', 'ROLE_MANAGER', 'ROLE_USER'],
	'/administrator/**'		: ['ROLE_ADMIN', 'ROLE_MANAGER', 'ROLE_USER'],
    '/annotation/**'		: ['ROLE_ADMIN', 'ROLE_MANAGER', 'ROLE_USER'],
	'/dashboard/**'			: ['ROLE_ADMIN', 'ROLE_MANAGER', 'ROLE_USER'],
    '/dbconsole/**'			: ['permitAll'],
    '/tag/**'		        : ['ROLE_ADMIN', 'ROLE_MANAGER', 'ROLE_USER']
]
// -------------------------------------------------------------------------------------------------------------------------------------------
// cors:1.1.0

// origin, authorization, accept, content-type, x-requested-with
// cors.expose.headers = 'X-app-header1,X-app-header2'
cors.enabled = true
cors.headers = [
    'Access-Control-Allow-Origin': '*',
    'Access-Control-Allow-Headers': 'content-length, content-type, x-annotator-auth-token, x-requested-with, x-csrftoken'
]
cors.expose.headers = 'x-annotator-auth-token'
cors.url.pattern = '/annotator/*'

// -------------------------------------------------------------------------------------------------------------------------------------------
// httplogger:1.1

//should you wish to disable it temporarily or based on environment
grails.plugins.httplogger.enabled = true

//list of headers to log by the default HttpLogger implementation
grails.plugins.httplogger.headers = 'cookie, host, connection, accept, accept-language, accept-encoding, origin, x-annotator-auth-token, user-agent, content-type, referer, x-requested-with, x-crsftoken, content-type, content-length'

// - lists of Ant-style patterns to be included/excluded by the default RequestMatcher implementation
//   (AntPatternRequestMatcher)
// - includes take precedence over excludes
// - if none of them are given - all requests are logged
grails.plugins.httplogger.includeUrls = ['/annotator/**']
//grails.plugins.httplogger.excludeUrls = ['/css/**', '/**/*.js']

//grails.plugin.httplogger.enabled = true
//environments {
//    test {
//        grails.plugin.httplogger.enabled = false
//    }
//}
//
//grails.plugin.httplogger.headers = 'content-length, content-type, x-annotator-auth-token, x-requested-with, x-csrftoken'
//list of headers to log by the default HttpLogger implementation
//
//grails.plugin.httplogger.includeUrls = ['/api/**',]
//grails.plugin.httplogger.excludeUrls = ['/css/**', '/**/*.js']
