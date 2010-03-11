package bwbv.rlt.client.presenter;

import java.util.ArrayList;

import bwbv.rlt.client.view.MainView;
import bwbv.rlt.domain.Rlt;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;

/**
 * Menu on the left
 */
public class MenuPresenter extends Composite {

	private MenuStackPanel menuStackPanel = null;
	
	public MenuPresenter() {
		DockPanel main = new DockPanel();
//		main.add(new MenuTree(serviceRegistry, mainPane, rlts), DockPanel.CENTER);
		menuStackPanel = new MenuStackPanel();
		main.add(menuStackPanel, DockPanel.CENTER);
		initWidget(main);
	}

	public void fillMenu(MainView mainPane, ArrayList<Rlt> rlts) {
//		menuStackPanel.fillMenu(mainPane, rlts);
	}
}
