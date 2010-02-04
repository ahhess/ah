package bwbv.rlt.client.ui;

import bwbv.rlt.client.domain.Rlt;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class RltInfoPanel extends Composite {

	public RltInfoPanel(Rlt rlt) {
        
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setHorizontalAlignment(HorizontalPanel.ALIGN_CENTER);
		horizontalPanel.setWidth("25%");

		//TODO
		horizontalPanel.add(new HTML(rlt.getKurzbez()));
		
		FlexTable table = new FlexTable();
		
		initWidget(horizontalPanel);
	}
}
