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
}
