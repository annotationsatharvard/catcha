import org.apache.tomcat.jdbc.pool.DataSource
import org.codehaus.groovy.grails.commons.ConfigurationHolder
import org.mindinformatics.ann.framework.module.persistence.services.InMemoryTripleStorePersistenceImpl
import org.mindinformatics.ann.framework.module.security.AuthenticationApplicationListener

// Place your Spring DSL code here
beans = {
	//authenticationSuccessHandler(CustomAuthenticationSuccessHandler)
	applicationListener(AuthenticationApplicationListener)
	//userDetailsService(org.mindinformatics.ann.framework.module.security.CustomUserDetailsService)
	
	iTripleStorePersistence(InMemoryTripleStorePersistenceImpl) { bean ->
		bean.autowire = 'byName'
	}

    //annotatorToOpenAnnotationConverter (org.mindinformatics.ann.framework.module.converter.AnnotatorToOpenAnnotationConverter) { bean ->
    //
    //}
    annotationConverter org.mindinformatics.ann.framework.module.converter.AnnotationConverter
    conversionService (org.springframework.context.support.ConversionServiceFactoryBean) { bean ->
        //    bean.autowire = 'byName'
        converters = [ annotationConverter ]
    }
    customPropertyEditorRegistrar(org.mindinformatics.ann.framework.module.propertyeditors.CustomPropertyEditorRegistrar)

    dataSource(DataSource) {
        // mandatory
        driverClassName = '${dataSource.driverClassName}'
        username = '${dataSource.username}'
        password = '${dataSource.password}'
        url = '${dataSource.url}'
        // optional
        initialSize=25
        minEvictableIdleTimeMillis=1800000
        timeBetweenEvictionRunsMillis=1800000
        numTestsPerEvictionRun=3
        testOnBorrow=true
        testWhileIdle=true
        testOnReturn=true
        validationQuery="SELECT 1"
    }

}
