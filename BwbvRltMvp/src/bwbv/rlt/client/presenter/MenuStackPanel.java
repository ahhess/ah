package bwbv.rlt.client.presenter;

import java.util.ArrayList;

import bwbv.rlt.client.view.MainView;
import bwbv.rlt.model.domain.Rlt;
import bwbv.rlt.model.domain.RltKat;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.DecoratedStackPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Stack Panel Menu
 */
public class MenuStackPanel extends DecoratedStackPanel {

	// private HashMap<String, Panel> map = new HashMap<String, Panel>();

	public MenuStackPanel() {

		setWidth("100%");

		// for (RltKat kat : RltKat.values()) {
		// VerticalPanel panel = new VerticalPanel();
		// add(panel, kat.toString(), true);
		// map.put(kat.toString(), panel);
		// }
	}

	public void fillMenu(final MainView mainPane, ArrayList<Rlt> rlts) {
		if (rlts != null) {
			RltKat kat = null;
			Panel vpanel = null;
			for (int i = 0; i < rlts.size(); i++) {
				final Rlt rlt = rlts.get(i);
				if (kat == null || kat.getId() != rlt.getKat().getId()) {
					kat = rlt.getKat();
					// GWT.log(rlt.getKurzBez() + " : " + kat, null);
					// Panel panel = map.get(kat);
					vpanel = new VerticalPanel();
					this.add(vpanel, kat.getKurzBez(), true);
				}
				Label panelItem = new Label(rlt.getKurzBez());
				panelItem.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						mainPane.showRlt(rlt);
					}
				});
				vpanel.add(panelItem);
			}
		}
	}

}
