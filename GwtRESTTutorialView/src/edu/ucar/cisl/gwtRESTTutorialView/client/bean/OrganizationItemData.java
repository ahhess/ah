package edu.ucar.cisl.gwtRESTTutorialView.client.bean;


public class OrganizationItemData extends ItemData {
	
	protected String name;
	protected String leadName;
	protected String leadTitle;
	protected int totalEmployees;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getLeadName() {
		return leadName;
	}

	public void setLeadName(String leadName) {
		this.leadName = leadName;
	}

	public int getTotalEmployees() {
		return totalEmployees;
	}

	public void setTotalEmployees(int totalEmployees) {
		this.totalEmployees = totalEmployees;
	}

	
	public String getLeadTitle() {
		return leadTitle;
	}

	public void setLeadTitle(String leadTitle) {
		this.leadTitle = leadTitle;
	}

	public String buildUri()
	{
		return "http://localhost:8080/gwtRESTTutorial/rrh/organizations/" + id;
	}

}
