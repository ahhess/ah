package edu.ucar.cisl.gwtRESTTutorialView.client;

import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;

import edu.ucar.cisl.gwtRESTTutorialView.client.bean.EmployeeItemData;

public class EmployeePopup extends PopupPanel {
	static protected EmployeePopup instance=null;
	protected Grid grid = new Grid(6, 2);
	protected Label firstNameLabel = new Label("First Name");
	protected Label firstNameValueLabel = new Label("First Name");
	protected Label nickNameLabel = new Label("Nickname");
	protected Label nickNameValueLabel = new Label("Nick Name");
	protected Label lastNameLabel = new Label("Last Name");
	protected Label lastNameValueLabel = new Label("Last Name");
	protected Label titleLabel = new Label("Title");
	protected Label titleValueLabel = new Label("Title");
	protected Label phoneLabel = new Label("Phone Number");
	protected Label phoneValueLabel = new Label("Phone Number");
	protected Label emailNameLabel = new Label("Email");
	protected Label emailValueLabel = new Label("Email");

	protected EmployeePopup() {
		super(true);
		grid.setWidget(0, 0, firstNameLabel);
		grid.setWidget(0, 1, firstNameValueLabel);

		grid.setWidget(1, 0, nickNameLabel);
		grid.setWidget(1, 1, nickNameValueLabel);

		grid.setWidget(2, 0, lastNameLabel);
		grid.setWidget(2, 1, lastNameValueLabel);

		grid.setWidget(3, 0, titleLabel);
		grid.setWidget(3, 1, titleValueLabel);

		grid.setWidget(4, 0, phoneLabel);
		grid.setWidget(4, 1, phoneValueLabel);

		grid.setWidget(5, 0, emailNameLabel);
		grid.setWidget(5, 1, emailValueLabel);

		grid.setWidth("300px");
		// grid.setHeight("400px");
		setWidget(grid);
	}
	
    protected static EmployeePopup getInstance() {
    	if (instance == null)
    		instance = new EmployeePopup();
    	
    	return instance;
    }
    
	public void setEmployeeData(EmployeeItemData iData) {
		String firstName = iData.getFirstName();
		String lastName = iData.getLastName();
		String nickName = iData.getNickName();
		String phone = iData.getPhone();
		String email = iData.getEmail();
		String title = iData.getTitle();

		firstNameValueLabel.setText(firstName);
		if (nickName != null && nickName.length() > 0) {
			nickNameValueLabel.setVisible(true);
			nickNameLabel.setVisible(true);
			nickNameValueLabel.setText(nickName);
		} else {
			nickNameValueLabel.setVisible(false);
			nickNameLabel.setVisible(false);
		}
		lastNameValueLabel.setText(lastName);
		phoneValueLabel.setText(phone);
		emailValueLabel.setText(email);
		titleValueLabel.setText(title);
	}

	public static void show(int leftOffset, int topOffset,
			EmployeeItemData eData) {
		EmployeePopup popup = getInstance();
		popup.setEmployeeData(eData);
		popup.setPopupPosition(leftOffset, topOffset);
		popup.show();
	}

}
