package bwbv.rlt.client.ui;

import bwbv.rlt.client.domain.Rlt;
import bwbv.rlt.client.localdata.RltLocalData;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;

/**
 * Menu on the left
 */
public class MenuPanel extends Composite {

	private Rlt[] rlts;
	
	public MenuPanel(MainPane mainPane) {
		getRlts();
		DockPanel main = new DockPanel();
//		main.add(new MenuTree(serviceRegistry, mainPane, rlts), DockPanel.CENTER);
		main.add(new MenuStackPanel(mainPane, rlts), DockPanel.CENTER);
		initWidget(main);
	}

	private void getRlts() {
		rlts = RltLocalData.getRlts();
	}

}
