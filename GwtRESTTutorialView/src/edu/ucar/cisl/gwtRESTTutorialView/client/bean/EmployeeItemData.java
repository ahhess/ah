package edu.ucar.cisl.gwtRESTTutorialView.client.bean;

public class EmployeeItemData extends ItemData {
	protected String firstName;
	protected String lastName;
	protected String nickName;
	protected String phone;
	protected String email;
	protected String title;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String buildUri()
	{
		return "http://localhost:8080/gwtRESTTutorial/rrh/employees/"  + id;
		
	}
}
