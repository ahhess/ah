package bwbv.rlt.client.ui;

import bwbv.rlt.client.ClientState;
import bwbv.rlt.client.ClientStateChangeListener;
import bwbv.rlt.model.domain.Rlt;
import bwbv.rlt.model.domain.RltKat;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.DecoratedStackPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Stack Panel Menu
 */
public class MenuStackPanel extends DecoratedStackPanel implements ClientStateChangeListener {

//	private HashMap<String, Panel> map = new HashMap<String, Panel>();

	public MenuStackPanel() {

		setWidth("100%");

		// for (RltKat kat : RltKat.values()) {
		// VerticalPanel panel = new VerticalPanel();
		// add(panel, kat.toString(), true);
		// map.put(kat.toString(), panel);
		// }
	}

	// public void fillMenu(final MainPane mainPane, JsArray<Rlt> rlts) {
	// public void fillMenu(final MainPane mainPane, ArrayList<Rlt> rlts) {

	@Override
	public void onChange(ClientState clientState) {

		if (clientState.getRlts() != null) {
			this.clear();
			RltKat kat = null;
			Panel panel = null;
			for (Rlt rlt : clientState.getRlts()) {
				 GWT.log(rlt.getKurzBez() + " : " + kat, null);
				if (kat == null || kat.getId() != rlt.getKat().getId()) {
					kat = rlt.getKat();
					// Panel panel = map.get(kat);
					panel = new VerticalPanel();
					add(panel, kat.getKurzBez(), true);
				}
				if (panel != null) {
					final Label panelItem = new Label(rlt.getKurzBez());
					panelItem.addClickHandler(new ClickHandler() {
						public void onClick(ClickEvent event) {
							// mainPane.showRlt(rlt);
							Window.alert(panelItem.getText());
						}
					});
					panel.add(panelItem);
				}
			}
		}
	}

}
