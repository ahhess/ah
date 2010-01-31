package bwbv.rlt.client.ui;

import bwbv.rlt.client.domain.Rlt;
import bwbv.rlt.client.localdata.RltLocalData;
import bwbv.rlt.client.service.ServiceRegistry;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;

/**
 * Menu on the left
 */
public class MenuPanel extends Composite {

	private Rlt[] rlts;
	
	public MenuPanel(ServiceRegistry serviceRegistry, MainPane mainPane) {
		getRlts();
		DockPanel main = new DockPanel();
//		main.add(new MenuTree(serviceRegistry, mainPane, rlts), DockPanel.CENTER);
		main.add(new MenuStackPanel(serviceRegistry, mainPane, rlts), DockPanel.CENTER);
		initWidget(main);
	}

	private void getRlts() {
		rlts = RltLocalData.getRlts();
	}

}
