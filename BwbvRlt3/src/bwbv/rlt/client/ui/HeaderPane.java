/*
 * Copyright 2002-2008 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package bwbv.rlt.client.ui;

import bwbv.rlt.client.ClientController;
import bwbv.rlt.client.ClientState;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * A {@link Pane} that shows the header of the main page. This header consists
 * of a title and a logout button/link.
 * 
 * Borrowed from Beginning Google Web Toolkit Book
 */
public class HeaderPane extends Composite implements ClientState.ChangeListener {

	private ClientState clientState;
	private ClientController clientController;
	private PopupPanel confirmPopup;
	private DockPanel main;

	/**
	 * Constructs a new HeaderPane that displays the given text.
	 * 
	 * @param titleText
	 *            The text this header should show as a title.
	 */
	public HeaderPane(ClientState clientState, ClientController clientController) {
		this.clientState = clientState;
		this.clientController = clientController;
		clientState.addChangeListener(ClientState.ChangeListener.USERCHANGED_EVENT, this);

		main = new DockPanel();
		main.add(new Label("BWBV RLT Online"), DockPanel.CENTER);
		reset();
		initWidget(main);
		setStyleName("HeaderPane");
	}

	public void reset() {
		//TODO: call isLoggedIn() ?
		boolean isLoggedIn = clientState.getUserName() != null;
		HorizontalPanel panel = buildHeaderPanel(isLoggedIn);
		main.remove(0);
		main.add(panel, DockPanel.EAST);
	}

	/**
	 * Build this conditionally based on isLoggedIn
	 * @param isLoggedIn
	 * @return
	 */
	private HorizontalPanel buildHeaderPanel(boolean isLoggedIn) {
		HorizontalPanel panel = new HorizontalPanel();
		panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		if (isLoggedIn) {
			panel.setSpacing(10);
			panel.add(new Label("Welcome " + clientState.getUserName()));

			Button logoutButton = new Button("Logout");
			logoutButton.setStyleName("LogoutButton");
			logoutButton.addClickListener(new ClickListener() {
				public void onClick(Widget sender) {
					logout();
				}
			});
			panel.add(logoutButton);
		} else {
			Button loginButon = new Button("Login");
			loginButon.setStyleName("LoginButton");
			loginButon.addClickListener(new ClickListener() {
				public void onClick(Widget sender) {
					showNewUserNameRequestPopupPanel();
				}
			});
			panel.add(loginButon);
		}
		return panel;
	}

	private void showNewUserNameRequestPopupPanel() {
		confirmPopup = new PopupPanel(false, true);
		VerticalPanel panel = new VerticalPanel();
//		panel.add(new Label("What is your login Name?"));
//		panel.add(textBox);
		Grid grid = new Grid(2, 2);
		grid.setText(0, 0, "Benutzer:");
		final TextBox textBox = new TextBox();
		grid.setWidget(0, 1, textBox);
		grid.setText(1, 0, "Passwort:");
		final PasswordTextBox pwdBox = new PasswordTextBox();
		grid.setWidget(1, 1, pwdBox);
		panel.add(grid);
		Button ok = new Button("OK");
		ok.addClickListener(new ClickListener() {
			public void onClick(Widget w) {
				confirmPopup.hide();
				login(textBox.getText(), pwdBox.getText());
			}
		});

		panel.add(ok);
        confirmPopup.add(panel);
        confirmPopup.center();
        textBox.setFocus(true);
        confirmPopup.show();
	}

	private void logout() {
		clientController.getRltService().logout(clientState);
	}

	private void login(String userName, String pwd) {
		clientController.getRltService().login(clientState, userName, pwd);
	}

	@Override
	public void onChange(String eventName, ClientState clientState) {
		reset();
	}
}
