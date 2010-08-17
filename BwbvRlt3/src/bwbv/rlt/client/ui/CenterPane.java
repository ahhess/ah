package bwbv.rlt.client.ui;

import bwbv.rlt.client.ClientState;

import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;

public class CenterPane extends SimplePanel implements ClientState.ChangeListener {

	public CenterPane(ClientState clientState) {
		clientState.addChangeListener(ClientState.ChangeListener.RLTLISTCHANGED_EVENT, this);
		clientState.addChangeListener(ClientState.ChangeListener.RLTSELECTED_EVENT, this);
	}

	public void onChange(String eventName, ClientState clientState) {
		clear();
		if (ClientState.ChangeListener.RLTLISTCHANGED_EVENT.equals(eventName)) {
			add(new Label("Bitte RLT auswählen"));
		} else if (ClientState.ChangeListener.RLTSELECTED_EVENT.equals(eventName)) {
			DecoratedTabPanel tabPanel = new DecoratedTabPanel();
			tabPanel.setWidth("100%");
			RltInfoPanel infoPanel = new RltInfoPanel(clientState.getCurrentRlt());
			tabPanel.add(infoPanel, "Info");

			// for (RltDisziplin disz : clientState.getCurrentRlt().getDisziplins()) {
			// //TODO:
			// HorizontalPanel p = new HorizontalPanel();
			// p.add(new HTML(disz.toString()));
			// tabPanel.add(p, disz.getKurzBez());
			// }
			add(tabPanel);
			tabPanel.selectTab(0);
		}
	}
}
