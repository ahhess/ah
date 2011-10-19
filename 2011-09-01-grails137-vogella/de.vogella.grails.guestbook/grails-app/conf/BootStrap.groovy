import de.vogella.grails.guestbook.*

import org.apache.shiro.crypto.hash.Sha512Hash

class BootStrap {

    def init = { servletContext ->
	/***/
		User user = new User(name:'lars', email:'muster@muster.com', webpage:'http://www.vogella.de')
		User otherUser = new User(name:'jim', email:'jim@muster.com', webpage:'http://www.vogella.de')
		if (!user.save()){
			log.error "Could not save user!!"
			log.error "${user.errors}"
		}
		if (!otherUser.save()){
			log.error "Could not save otherUser!!"
		}
		
		Feedback feedback = new Feedback(title:'First feedback', feedback:'This is my first feedback', user:user)
		feedback.save()

		Comment comment = new Comment(comment:'Hello, my name is Jim', user:otherUser)
		comment.feedback = feedback
		comment.save(); 

		// shiro security:

		def adminRole = new ShiroRole(name: "Administrator")
		adminRole.addToPermissions("*:*")
		adminRole.save()
		
		def userRole = new ShiroRole(name: "User")
		userRole.addToPermissions("index:*")
		userRole.addToPermissions("feedback:*")
		userRole.addToPermissions("comment:*")
		userRole.addToPermissions("user:index,list,show")
		userRole.save()

        def uuser = new ShiroUser(username: "user", passwordHash: new Sha512Hash("user").toHex())
        uuser.addToRoles(userRole)
        uuser.save()

        def uadmin = new ShiroUser(username: "admin", passwordHash: new Sha512Hash("admin").toHex())
        uadmin.addToRoles(adminRole)
        uadmin.save()
		
	/***/
	}

    def destroy = {
    }
} 
