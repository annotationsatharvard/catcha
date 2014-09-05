import grails.converters.JSON
import org.mindinformatics.ann.framework.module.persistence.Annotation
import org.mindinformatics.ann.framework.module.persistence.AnnotationRange
import org.mindinformatics.ann.framework.module.security.groups.GroupPrivacy
import org.mindinformatics.ann.framework.module.security.groups.GroupRole
import org.mindinformatics.ann.framework.module.security.groups.GroupStatus
import org.mindinformatics.ann.framework.module.security.groups.UserStatusInGroup
import org.mindinformatics.ann.framework.module.security.systems.SystemApi
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

        // A better way to register the marshallers
        //[ new AnnotationMarshaller(), new AnnotationRangeMarshaller()].each { it.register() }

        // Decided to do it this way to make it easier to customize
        /*
        JSON.registerObjectMarshaller(Annotation) { annotation ->
            return [
                    id: annotation.id,
                    //text: annotation.text,
                    //quote: annotation.quote,
                    uri: annotation.uri,
                    json: annotation.json
                    //ranges: annotation.ranges,

            ]
        }
        */
        /**
        JSON.registerObjectMarshaller(AnnotationRange) { range ->
            return [
                    id: range.id,
                    start: range.start,
                    startOffset: range.startOffset,
                    end: range.end,
                    endOffset: range.endOffset
            ]
        }
        */


        println "Using configuration locations: " + grailsApplication.config.grails.config.locations


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

        // Prevents duplicate key exception when we try to add new role to user
        def roleUser = Role.findByAuthority(DefaultUsersRoles.USER.value())
        def roleManager = Role.findByAuthority(DefaultUsersRoles.MANAGER.value())
        def roleAdmin = Role.findByAuthority(DefaultUsersRoles.ADMIN.value()
        )
        if (!admin.authorities.contains(roleUser)) {
            UserRole.create admin, roleUser
        }
        if (!admin.authorities.contains(roleAdmin)) {
            UserRole.create admin, roleAdmin
        }
        if (!admin.authorities.contains(roleManager)) {
            UserRole.create admin, roleManager
        }



        def firstApp =
            new SystemApi(name: "My First App", shortName: "myfirstapp", description: "My First Application",
                    apikey: "0cbfa370-b73c-4e3a-ae46-582df284b7c3", enabled: true, accessToPublicData: true, createdBy: admin).save(flush: true)


        def secondApp =
            new SystemApi(name: "My Second App", shortName: "mysecondapp", description: "My Second Application",
                    apikey: "80404495-7196-4879-8719-54c21f44a31a", enabled: true, accessToPublicData: true, createdBy: admin).save(flush: true)

        def thirdApp =
            new SystemApi(name: "My Third App", shortName: "mythirddapp", description: "My Third Application",
                    apikey: "4c7f4d1c-8ac4-4e9f-84c8-b271c57fcac4", enabled: true, accessToPublicData: true, createdBy: admin).save(flush: true)

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

            // Prevents duplicate key exception when we try to add new role to user
            if (!user.authorities.contains(roleUser)) {
    			UserRole.create user, roleUser
            }
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
