package bwbv.rlt.client.ui;

import bwbv.rlt.client.domain.Rlt;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;

/**
 * Tree Menu
 */
public class MenuTree extends Tree {

	private MainPane mainPane;
	private Rlt[] rlts;
	
	public MenuTree(MainPane mainPane, Rlt[] rlts) {

		this.mainPane = mainPane;
		this.rlts = rlts;
	
		setAnimationEnabled(true);

//		menuTree.addItem("Screen 1");
//		menuTree.addItem("Screen 2");

		Rlt.Kat kat = null;
		TreeItem katItem = null;
		for (Rlt rlt : rlts) {
			if (kat == null || !kat.equals(rlt.getRltkat())) {
				kat  = rlt.getRltkat();
				katItem = new TreeItem(new HTML(kat.toString()));
				katItem.setState(true);
				addItem(katItem);
			}
			TreeItem rltItem = new TreeItem(new HTML(rlt.getTurnierbez()));
			katItem.addItem(rltItem);
		}
	}
	
	public void onBrowserEvent(Event e) {
		{
			sinkEvents(Event.ONCLICK);
		}
		super.onBrowserEvent(e);
		if (DOM.eventGetType(e) == Event.ONCLICK) {
			if(getSelectedItem()!=null){
				handleEvent(getSelectedItem().getText());
			}
		}
	}

	private void handleEvent(String text) {
//		GWT.log(text,null);
		for (Rlt rlt : rlts) {
			if (rlt.getTurnierbez().equalsIgnoreCase(text)) {
//				GWT.log("gefunden!",null);
				mainPane.showRlt(rlt);
			}
		}
	}

}
