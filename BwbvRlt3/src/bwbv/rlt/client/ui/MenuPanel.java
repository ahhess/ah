package bwbv.rlt.client.ui;

import bwbv.rlt.client.domain.Rlt;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;

/**
 * Menu on the left
 */
public class MenuPanel extends Composite {

	private MenuStackPanel menuStackPanel = null;
	
	public MenuPanel() {
		DockPanel main = new DockPanel();
//		main.add(new MenuTree(serviceRegistry, mainPane, rlts), DockPanel.CENTER);
		menuStackPanel = new MenuStackPanel();
		main.add(menuStackPanel, DockPanel.CENTER);
		initWidget(main);
	}

	public void fillMenu(MainPane mainPane, JsArray<Rlt> rlts) {
		menuStackPanel.fillMenu(mainPane, rlts);
	}
}
