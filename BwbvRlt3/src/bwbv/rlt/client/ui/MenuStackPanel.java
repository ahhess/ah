package bwbv.rlt.client.ui;

import bwbv.rlt.client.domain.Rlt;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.StackPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Tree Menu
 */
public class MenuStackPanel extends StackPanel {

	private MainPane mainPane;
	private Rlt[] rlts;
	
	public MenuStackPanel(final MainPane mainPane, Rlt[] rlts) {

		this.mainPane = mainPane;
		this.rlts = rlts;
		setWidth("100%");
	
		Rlt.Kat kat = null;
		VerticalPanel panel = null;
		for (final Rlt rlt : rlts) {
			if (kat == null || !kat.equals(rlt.getRltkat())) {
				kat  = rlt.getRltkat();
				panel = new VerticalPanel();
				add(panel, kat.toString(), true);
			}
			HTML panelItem = new HTML(rlt.getTurnierbez());
			panelItem.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					mainPane.showRlt(rlt);
				}
			});
			panel.add(panelItem);
		}
	}

}
