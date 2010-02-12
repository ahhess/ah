package edu.ucar.cisl.gwtRESTTutorialView.client;

import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;

import edu.ucar.cisl.gwtRESTTutorialView.client.bean.OrganizationItemData;

public class OrganizationPopup extends PopupPanel {
	static protected OrganizationPopup instance=null;
	protected Grid grid = new Grid(3, 2);
	protected Label nameLabel = new Label("Full Name");
	protected Label nameValueLabel = new Label("Full Name");
	protected Label leadNameLabel = new Label("Lead");
	protected Label leadNameValueLabel = new Label("Lead Name");
	protected Label totalEmployeesLabel = new Label("Total Employees");
	protected Label totalEmployeesValueLabel = new Label("Total Employees");

	public OrganizationPopup() {
		super(true);
		grid.setWidget(0, 0, nameLabel);
		grid.setWidget(0, 1, nameValueLabel);

		grid.setWidget(1, 0, leadNameLabel);
		grid.setWidget(1, 1, leadNameValueLabel);

		grid.setWidget(2, 0, totalEmployeesLabel);
		grid.setWidget(2, 1, totalEmployeesValueLabel);

		grid.setWidth("700px");
		// grid.setHeight("400px");
		setWidget(grid);
	}

	public void setOrganizationData(OrganizationItemData iData) {
		nameValueLabel.setText(iData.getName());
		leadNameValueLabel.setText(iData.getLeadName());
		totalEmployeesValueLabel.setText(new Integer(iData.getTotalEmployees())
				.toString());
	}

	protected static OrganizationPopup getInstance() {
    	if (instance == null)
    		instance = new OrganizationPopup();
    	
    	return instance;
    }
	
	public static void show(int leftOffset, int topOffset,
			OrganizationItemData oData) {
		OrganizationPopup popup = getInstance();
		popup.setOrganizationData(oData);
		popup.setPopupPosition(leftOffset, topOffset);
		popup.show();
	}

}
