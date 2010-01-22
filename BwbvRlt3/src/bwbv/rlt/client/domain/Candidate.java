package bwbv.rlt.client.domain;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * 
 * Domain objects (under client package) can be used on the server and in the web app
 *
 */
//use IsSerializable instead Serializable to avoid problems running on linux
public class Candidate implements IsSerializable {
	
    private String name; 
    private int age;
    
	public Candidate(String name, int age) {
		this.name=name;
		this.age=age;
	}
	
	/**
	 * Needs an empty constructor to be serializable
	 */
	public Candidate() {
		super();
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
