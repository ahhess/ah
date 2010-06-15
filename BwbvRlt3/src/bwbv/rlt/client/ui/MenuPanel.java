package bwbv.rlt.client.ui;

import bwbv.rlt.client.ClientState;
import bwbv.rlt.client.ClientStateChangeListener;

import com.google.gwt.user.client.ui.Composite;

/**
 * Menu on the left
 */
public class MenuPanel extends Composite implements ClientStateChangeListener {

	private MenuStackPanel menuStackPanel = null;

	public MenuPanel() {
//		DockPanel main = new DockPanel();
		// main.add(new MenuTree(serviceRegistry, mainPane, rlts), DockPanel.CENTER);
		menuStackPanel = new MenuStackPanel();
//		main.add(menuStackPanel, DockPanel.CENTER);
//		initWidget(main);
		initWidget(menuStackPanel);
	}

	public void onChange(ClientState clientState) {
		menuStackPanel.onChange(clientState);
	}
	
	public void onRltSelected(ClientState clientState) {
		menuStackPanel.onRltSelected(clientState);
	}

	// public void fillMenu(MainPane mainPane, JsArray<Rlt> rlts) {
	// public void fillMenu(MainPane mainPane, Rlt[] rlts) {
	// menuStackPanel.fillMenu(mainPane, rlts);
	// }
}
