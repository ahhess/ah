package bwbv.rlt.client.ui;

import bwbv.rlt.client.ClientController;
import bwbv.rlt.client.ClientState;
import bwbv.rlt.model.domain.Rlt;
import bwbv.rlt.model.domain.RltDisziplin;

import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;

public class CenterPane extends SimplePanel implements ClientState.ChangeListener {

	private ClientController controller;
	private DecoratedTabPanel tabPanel;
	
	public CenterPane(ClientState clientState, ClientController controller) {
		this.controller = controller;
		clientState.addChangeListener(ClientState.ChangeListener.RLTLISTCHANGED_EVENT, this);
		clientState.addChangeListener(ClientState.ChangeListener.RLTSELECTED_EVENT, this);
		clientState.addChangeListener(ClientState.ChangeListener.RLTDISZSCHANGED_EVENT, this);
	}

	public void onChange(String eventName, ClientState clientState) {
		if (ClientState.ChangeListener.RLTLISTCHANGED_EVENT.equals(eventName)) {
			clear();
			add(new Label("Bitte RLT auswählen"));
			
		} else if (ClientState.ChangeListener.RLTSELECTED_EVENT.equals(eventName)) {
			
			// create new tab panel
			clear();
			tabPanel = new DecoratedTabPanel();
			tabPanel.setWidth("100%");
			add(tabPanel);
			
			// add the rlt info panel as first tab
			RltInfoPanel infoPanel = new RltInfoPanel(clientState.getCurrentRlt());
			tabPanel.add(infoPanel, "Info");
			tabPanel.selectTab(0);

			// show the disziplins or request them
			RltDisziplin[] disz = clientState.getCurrentRlt().getDisziplins();
			if (disz != null && disz.length > 0) {
				showDisz(clientState.getCurrentRlt());
			} else {
				controller.getRltService().sendGetRltDiszsRequest(clientState, clientState.getCurrentRlt().getId());
			}
			
		} else if (ClientState.ChangeListener.RLTDISZSCHANGED_EVENT.equals(eventName)) {
			showDisz(clientState.getCurrentRlt());
		}
	}
	
	private void showDisz(Rlt rlt) {
		for (RltDisziplin disz : rlt.getDisziplins()) {
			RltDiszPanel rltDiszPanel = new RltDiszPanel(disz);
			tabPanel.add(rltDiszPanel, disz.getKurzBez());
		}
	}
}
