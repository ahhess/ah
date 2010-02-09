package bwbv.rlt.client.ui;

import java.util.HashMap;

import bwbv.rlt.client.domain.Rlt;
import bwbv.rlt.client.domain.RltKat;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;
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

	private HashMap<String, Panel> map = new HashMap<String, Panel>();

	public MenuStackPanel() {

		setWidth("100%");

		for (RltKat kat : RltKat.values()) {
			VerticalPanel panel = new VerticalPanel();
			add(panel, kat.toString(), true);
			map.put(kat.toString(), panel);
		}
	}

	public void fillMenu(final MainPane mainPane, JsArray<Rlt> rlts) {
		if (rlts != null) {
			for (int i = 0; i < rlts.length(); i++) {
				final Rlt rlt = rlts.get(i);
				String kat = rlt.getRltKat();
				GWT.log(rlt.getKurzbez() + " : " + kat, null);
				if (kat!= null) {
					Panel panel = map.get(kat);
					if (panel != null) {
						Label panelItem = new Label(rlt.getKurzbez());
						panelItem.addClickHandler(new ClickHandler() {
							public void onClick(ClickEvent event) {
								mainPane.showRlt(rlt);
							}
						});
						panel.add(panelItem);
					}
				}
			}
		}
	}

}
