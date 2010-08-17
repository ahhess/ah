package bwbv.rlt.client.ui;

import bwbv.rlt.client.ClientState;

import com.google.gwt.user.client.ui.Composite;

/**
 * Menu on the left
 */
public class MenuPanel extends Composite {

	private MenuStackPanel menuStackPanel = null;

	public MenuPanel(ClientState clientState) {
//		DockPanel main = new DockPanel();
		// main.add(new MenuTree(serviceRegistry, mainPane, rlts), DockPanel.CENTER);
		menuStackPanel = new MenuStackPanel(clientState);
//		main.add(menuStackPanel, DockPanel.CENTER);
//		initWidget(main);
		initWidget(menuStackPanel);
	}

//	public void onChange(String eventName, ClientState clientState) {
//		menuStackPanel.onChange(eventName, clientState);
//	}
	
//	public void onRltSelected(ClientState clientState) {
//		menuStackPanel.onRltSelected(clientState);
//	}

	// public void fillMenu(MainPane mainPane, JsArray<Rlt> rlts) {
	// public void fillMenu(MainPane mainPane, Rlt[] rlts) {
	// menuStackPanel.fillMenu(mainPane, rlts);
	// }
}
