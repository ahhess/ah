package bwbv.rlt.client.ui;

import bwbv.rlt.client.ClientState;
import bwbv.rlt.client.ClientStateChangeListener;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;

public class CenterPane extends SimplePanel implements ClientStateChangeListener {

	public CenterPane() {
		add(new Label("Bitte RLT ausw&auml;hlen"));
	}

	@Override
	public void onChange(ClientState clientState) {
//		this.clear();
//		DecoratedTabPanel tabPanel = new DecoratedTabPanel();
//		RltInfoPanel infoPanel = new RltInfoPanel(rlt);
	}

}
