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
}
