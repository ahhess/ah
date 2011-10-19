import de.vogella.grails.guestbook.*

import org.apache.shiro.crypto.hash.Sha512Hash

class BootStrap {

    def init = { servletContext ->
    /***/

		// shiro security:

		def adminRole = new ShiroRole(name: "AdministratorRole")
		adminRole.addToPermissions("*:*")
		adminRole.save()
		
		def userRole = new ShiroRole(name: "UserRole")
		userRole.addToPermissions("index:*")
		userRole.addToPermissions("feedback:*")
		userRole.addToPermissions("comment:*")
		userRole.addToPermissions("user:index,list,show")
		userRole.save()

        def uuser = new ShiroUser(username: "user", name: "Jim Morrison", passwordHash: new Sha512Hash("user").toHex(), email:"jim@u2.com")
        uuser.addToRoles(userRole)
        uuser.save()

        def uadmin = new ShiroUser(username: "admin", name: "Roger Waters", passwordHash: new Sha512Hash("admin").toHex(), email:"roger@pinkfloyd.com")
        uadmin.addToRoles(adminRole)
        uadmin.save()

		// app data
		 
		Feedback feedback = new Feedback(title:'First feedback', feedback:'This is my first feedback', user:uuser)
		feedback.save()

		Comment comment = new Comment(comment:'Hello, my name is ADMIN', user:uadmin)
		comment.feedback = feedback
		comment.save(); 
		
	/***/
	}

    def destroy = {
    }
} 
