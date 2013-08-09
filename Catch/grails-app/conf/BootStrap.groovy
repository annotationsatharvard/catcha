import grails.converters.JSON
import org.mindinformatics.ann.framework.module.persistence.Annotation
import org.mindinformatics.ann.framework.module.persistence.AnnotationRange
import org.mindinformatics.ann.framework.module.security.groups.GroupPrivacy
import org.mindinformatics.ann.framework.module.security.groups.GroupRole
import org.mindinformatics.ann.framework.module.security.groups.GroupStatus
import org.mindinformatics.ann.framework.module.security.groups.UserStatusInGroup
import org.mindinformatics.ann.framework.module.security.users.Role
import org.mindinformatics.ann.framework.module.security.users.User
import org.mindinformatics.ann.framework.module.security.users.UserRole
import org.mindinformatics.ann.framework.module.security.utils.DefaultGroupPrivacy
import org.mindinformatics.ann.framework.module.security.utils.DefaultGroupRoles
import org.mindinformatics.ann.framework.module.security.utils.DefaultGroupStatus
import org.mindinformatics.ann.framework.module.security.utils.DefaultUserStatusInGroup
import org.mindinformatics.ann.framework.module.security.utils.DefaultUsersRoles


class BootStrap {

	def grailsApplication
	def springSecurityService
	
    def init = { servletContext ->

        //[ new AnnotationMarshaller(), new AnnotationRangeMarshaller()].each { it.register() }

        JSON.registerObjectMarshaller(Annotation) { annotation ->
            return [
                    id: annotation.id,
                    text: annotation.text,
                    quote: annotation.quote,
                    uri: annotation.uri,
                    ranges: annotation.ranges
            ]
        }

        JSON.registerObjectMarshaller(AnnotationRange) { range ->
            return [
                    id: range.id,
                    start: range.start,
                    startOffset: range.startOffset,
                    end: range.end,
                    endOffset: range.endOffset
            ]
        }



		String password = springSecurityService.encodePassword('password')
		
		separator();
		log.info  '>> INITIALIZING DEFAULTS'
		separator();
		log.info  '** Users Roles'
		DefaultUsersRoles.values().each {
			if(!Role.findByAuthority(it.value())) {
				new Role(authority: it.value(), ranking: it.ranking(), label: it.label(), description: it.description()).save(failOnError: true)
				log.info "Initialized: " + it.value()
			}
		}
		
		separator();
		log.info  '** Groups Roles'
		DefaultGroupRoles.values().each {
			if(!GroupRole.findByAuthority(it.value())) {
				new GroupRole(authority: it.value(), ranking: it.ranking(), label: it.label(), description: it.description()).save(failOnError: true)
				log.info "Initialized: " + it.value()
			}
		}
		
		separator();
		log.info  '** Groups Status'
		DefaultGroupStatus.values().each {
			if(!GroupStatus.findByValue(it.value())) {
				new GroupStatus(value: it.value(), uuid: it.uuid(), label: it.label(), description: it.description()).save(failOnError: true)
				log.info "Initialized: " + it.value()
			}
		}
		
		separator();
		log.info  '** Groups Privacy'
		DefaultGroupPrivacy.values().each {
			if(!GroupPrivacy.findByValue(it.value())) {
				new GroupPrivacy(value: it.value(), uuid: it.uuid(), label: it.label(), description: it.description()).save(failOnError: true)
				log.info "Initialized: " + it.value()
			}
		}
		
		separator();
		log.info  '** User Status in Group'
		DefaultUserStatusInGroup.values().each {
			if(!UserStatusInGroup.findByValue(it.value())) {
				new UserStatusInGroup(value: it.value(), label: it.label(), description: it.description()).save(failOnError: true)
				log.info "Initialized: " + it.value()
			}
		}
		
		separator();
		log.info  '>> USERS'
		separator();
		log.info  '** Users'
		
		def adminUsername = 'admin'
		log.info  "Initializing: " + adminUsername
		def admin = User.findByUsername(adminUsername);
		if(admin==null) {
			admin = new User(username: adminUsername,
				password: password, firstName: 'Jack', lastName: 'White',
				displayName: 'Dr. White', enabled: true, email:'paolo.ciccarese@gmail.com').save(failOnError: true)
			log.warn  "CHANGE PASSWORD for: " + adminUsername + "!!!"
		}
		UserRole.create admin, Role.findByAuthority(DefaultUsersRoles.USER.value())
		UserRole.create admin, Role.findByAuthority(DefaultUsersRoles.MANAGER.value())
		UserRole.create admin, Role.findByAuthority(DefaultUsersRoles.ADMIN.value())
		
		if(grailsApplication.config.af.security.initialize.user=='true') { 
			def userUsername = 'user'
			log.info "Initializing: " + userUsername
			def user = User.findByUsername(userUsername);
			if(user==null) {
				user = new User(username: userUsername,
					password: password, firstName: 'John', lastName: 'Smith', 
					displayName: 'Dr. Smith', enabled: true, email:'yo@yo.com').save(failOnError: true)
				log.warn  "CHANGE PASSWORD for: " + userUsername + "!!!"
			}
			UserRole.create user, Role.findByAuthority(DefaultUsersRoles.USER.value())		
		}	
		
		separator();
		log.info  '>> GROUPS'

    }
	def separator = {
		log.info  '------------------------------------------------------------------------';
	}
    def destroy = {
    }
}
