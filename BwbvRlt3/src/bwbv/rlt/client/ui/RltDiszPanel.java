package bwbv.rlt.client.ui;

import bwbv.rlt.model.domain.RltDisziplin;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class RltDiszPanel extends Composite {

	public RltDiszPanel(RltDisziplin disz) {
        
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setHorizontalAlignment(HorizontalPanel.ALIGN_CENTER);
		horizontalPanel.setWidth("25%");
				
		initWidget(horizontalPanel);
	}
}
