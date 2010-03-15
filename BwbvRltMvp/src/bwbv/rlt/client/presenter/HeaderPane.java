package bwbv.rlt.client.presenter;

import bwbv.rlt.client.AuthenticationException;
import bwbv.rlt.client.ClientState;
import bwbv.rlt.client.SecurityService;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * A {@link Pane} that shows the header of the main page. This header consists
 * of a title and a logout button/link.
 * 
 * Borrowed from Beginning Google Web Toolkit Book
 */
public class HeaderPane extends Composite {

	private PopupPanel confirmPopup;
	private DockPanel main;

	/**
	 * Constructs a new HeaderPane that displays the given text.
	 * 
	 * @param titleText
	 *            The text this header should show as a title.
	 */
	public HeaderPane() {
		main = new DockPanel();
		main.add(new Label("Andy's GWT Sample App"), DockPanel.CENTER);
		reset();
		initWidget(main);
		setStyleName("HeaderPane");
	}

	public void reset() {
		Boolean isLoggedIn = SecurityService.Holder.get().isLoggedIn();
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
		if (isLoggedIn) {
			panel.setSpacing(10);
			panel.add(new Label("Welcome " + ClientState.get().getUserName()));

			PushButton logoutButton = new PushButton("Logout");
			logoutButton.setStyleName("LogoutButton");
			logoutButton.addClickListener(new ClickListener() {
				public void onClick(Widget sender) {
					logout();
				}
			});
			panel.add(logoutButton);
		} else {
			PushButton loginButon = new PushButton("Login");
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

	private void logout() {
		SecurityService.Holder.get().logout();
		reset();
	}

	private void login(String userName) {

		try {
			SecurityService.Holder.get().login(userName);
			ClientState.get().setUserName(userName);
			reset();
		} catch (AuthenticationException caught) {
			throw new RuntimeException(caught);
		}
	}

	private void showNewUserNameRequestPopupPanel() {
		confirmPopup = new PopupPanel(false, true);
		VerticalPanel panel = new VerticalPanel();
		panel.add(new Label("What is your login Name?"));
		final TextBox textBox = new TextBox();
		panel.add(textBox);
		Button ok = new Button("OK");
		ok.addClickListener(new ClickListener() {
			public void onClick(Widget w) {
				confirmPopup.hide();
				login(textBox.getText());
			}
		});

		panel.add(ok);
        confirmPopup.add(panel);
        confirmPopup.center();
        textBox.setFocus(true);
        confirmPopup.show();
	}
}
