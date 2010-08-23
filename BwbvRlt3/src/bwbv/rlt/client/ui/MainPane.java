package bwbv.rlt.client.ui;

import bwbv.rlt.client.ClientController;
import bwbv.rlt.client.ClientState;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HorizontalSplitPanel;

/**
 * Entry point and flow control of our app.
 */
public class MainPane extends Composite {

	private HeaderPane headerPane;
	private StatusBarPane statusBarPane;
	private CenterPane centerPane;
	private MenuPanel menuPanel; // menu

	public MainPane(ClientState clientState, ClientController controller) {

		DockPanel mainPanel = new DockPanel();
		mainPanel.setBorderWidth(5);
		mainPanel.setSize("100%", "100%");

		headerPane = new HeaderPane(clientState, controller);
		mainPanel.add(headerPane, DockPanel.NORTH);
		mainPanel.setCellHeight(headerPane, "30px");
		mainPanel.setCellHorizontalAlignment(headerPane, DockPanel.ALIGN_CENTER);
		mainPanel.setCellVerticalAlignment(headerPane, DockPanel.ALIGN_MIDDLE);

		statusBarPane = new StatusBarPane();
		mainPanel.add(statusBarPane, DockPanel.SOUTH);
		mainPanel.setCellHeight(statusBarPane, "25px");
		mainPanel.setCellHorizontalAlignment(statusBarPane, DockPanel.ALIGN_CENTER);
		mainPanel.setCellVerticalAlignment(statusBarPane, DockPanel.ALIGN_MIDDLE);

		menuPanel = new MenuPanel(clientState);

		centerPane = new CenterPane(clientState, controller);

		HorizontalSplitPanel horizontalSplitPanel = new HorizontalSplitPanel();
		horizontalSplitPanel.setSplitPosition("250px");
		horizontalSplitPanel.setLeftWidget(menuPanel);
		horizontalSplitPanel.setRightWidget(centerPane);
		mainPanel.add(horizontalSplitPanel, DockPanel.CENTER);

		initWidget(mainPanel);
	}

//	/**
//	 * Zeigt das Rlt mit Details und den Disz. als Tabs an
//	 */
//	public void showRlt(Rlt rlt) {
//		DecoratedTabPanel tabPanel = new DecoratedTabPanel();
//		tabPanel.setWidth("100%");
//		// tabPanel.setAnimationEnabled(true);
//		tabPanel.add(new RltInfoPanel(rlt), "Info");
//		tabPanel.selectTab(0);
//		if (rlt.getDisziplins() != null) {
//			for (RltDisziplin disz : rlt.getDisziplins()) {
//				tabPanel.add(new HTML("coming soon ..."), disz.getKurzBez());
//			}
//		}
//		centerPane.setWidget(tabPanel);
//	}

}
