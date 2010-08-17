package bwbv.rlt.client.ui;

import bwbv.rlt.client.ClientState;
import bwbv.rlt.model.domain.Rlt;
import bwbv.rlt.model.domain.RltKat;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.StackPanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;

/**
 * Stack Panel Menu
 */
public class MenuStackPanel extends StackPanel implements ClientState.ChangeListener {

	public MenuStackPanel(ClientState clientState) {
		clientState.addChangeListener(ClientState.ChangeListener.RLTLISTCHANGED_EVENT, this);
		setWidth("100%");
	}

	public void onChange(String eventName, final ClientState clientState) {

		if (clientState.getRlts() != null) {
			this.clear();
			RltKat kat = null;
			Tree tree = null;
			for (Rlt rlt : clientState.getRlts()) {
				GWT.log(rlt.getKurzBez() + " : " + kat, null);
				if (kat == null || kat.getId() != rlt.getKat().getId()) {
					kat = rlt.getKat();
					tree = new Tree();
					tree.addSelectionHandler(new SelectionHandler<TreeItem>() {
						public void onSelection(SelectionEvent<TreeItem> event) {
							Rlt rlt = (Rlt) event.getSelectedItem().getUserObject();
							clientState.setCurrentRlt(rlt);
						}
					});
					add(tree, kat.getKurzBez());
				}
				if (tree != null) {
					TreeItem item = new TreeItem(
					// rlt.getDatumtext() + ": " +
							rlt.getLangBez());
					item.setUserObject(rlt);
					tree.addItem(item);
				}
			}
		}
	}

//	public void onRltSelected(ClientState clientState) {
//	}
}
