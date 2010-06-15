package bwbv.rlt.client.ui;

import bwbv.rlt.client.ClientState;
import bwbv.rlt.client.ClientStateChangeListener;
import bwbv.rlt.model.domain.RltDisziplin;

import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;

public class CenterPane extends SimplePanel implements ClientStateChangeListener {

	public CenterPane() {
	}

	public void onChange(ClientState clientState) {
		clear();
		add(new Label("Bitte RLT auswählen"));
	}
	
	public void onRltSelected(ClientState clientState) {
		clear();
		DecoratedTabPanel tabPanel = new DecoratedTabPanel();
		tabPanel.setWidth("100%");
		RltInfoPanel infoPanel = new RltInfoPanel(clientState.getCurrentRlt());
		tabPanel.add(infoPanel, "Info");
		
		for (RltDisziplin disz : clientState.getCurrentRlt().getDisziplins()) {
			//TODO: 
			HorizontalPanel p = new HorizontalPanel();
			p.add(new HTML(disz.toString()));
			tabPanel.add(p, disz.getKurzBez());
		}
		add(tabPanel);
		tabPanel.selectTab(0);
	}

}
