package bwbv.rlt.client.ui;

import bwbv.rlt.model.domain.Rlt;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class RltInfoPanel extends Composite {

	public RltInfoPanel(Rlt rlt) {
        
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setHorizontalAlignment(HorizontalPanel.ALIGN_CENTER);
		horizontalPanel.setWidth("25%");

		Grid grid = new Grid(7,2);
		horizontalPanel.add(grid);
		
		int i=0;
		grid.setText(i, 0, "RLT:");
		grid.setText(i++, 1, rlt.getLangBez());
		grid.setText(i, 0, "Kategorie:");
		grid.setText(i++, 1, rlt.getKat()==null?"":rlt.getKat().getLangBez());
		grid.setText(i, 0, "Ort:");
		grid.setText(i++, 1, rlt.getOrt());
		grid.setText(i, 0, "Halle:");
		grid.setText(i++, 1, rlt.getHalle());
		grid.setText(i, 0, "Adresse:");
		grid.setText(i++, 1, rlt.getAdresse());
		grid.setText(i, 0, "Datum:");
		grid.setText(i++, 1, rlt.getDatumtext());
		grid.setText(i, 0, "Meldeschluss:");
		grid.setText(i++, 1, rlt.getMeldeschluss()==null?"":rlt.getMeldeschluss().toString());
		
		initWidget(horizontalPanel);
	}
}
