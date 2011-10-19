package de.vogella.grails.guestbook
class ShiroUser {
    String username
    String passwordHash
	String name
	String email
    
    static hasMany = [ roles: ShiroRole, permissions: String ]

    static constraints = {
        username(nullable: false, blank: false)
        name(nullable: false, blank: false)
    }
  
	String toString(){
		return name + "(" + username + ")"; 
	}
}
