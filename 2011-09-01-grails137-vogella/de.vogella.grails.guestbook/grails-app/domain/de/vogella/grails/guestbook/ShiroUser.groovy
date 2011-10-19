package de.vogella.grails.guestbook
class ShiroUser {
    String username
    String passwordHash
    
    static hasMany = [ roles: ShiroRole, permissions: String ]

    static constraints = {
        username(nullable: false, blank: false)
    }
  
	String toString(){
		return username; 
	}
}
