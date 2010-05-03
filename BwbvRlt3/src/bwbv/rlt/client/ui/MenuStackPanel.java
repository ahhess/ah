package bwbv.rlt.client.ui;

import bwbv.rlt.client.ClientState;
import bwbv.rlt.client.ClientStateChangeListener;
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
public class MenuStackPanel extends StackPanel implements ClientStateChangeListener {

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
	public void onChange(final ClientState clientState) {

		if (clientState.getRlts() != null) {
			this.clear();
			RltKat kat = null;
//			Panel panel = null;
			Tree tree = null;
			for (Rlt rlt : clientState.getRlts()) {
				 GWT.log(rlt.getKurzBez() + " : " + kat, null);
				if (kat == null || kat.getId() != rlt.getKat().getId()) {
					kat = rlt.getKat();
					// Panel panel = map.get(kat);
//					panel = new VerticalPanel();
//					add(panel, kat.getKurzBez());
					tree = new Tree();
					tree.addSelectionHandler(new SelectionHandler<TreeItem>() {
						public void onSelection(SelectionEvent<TreeItem> event) {
							Rlt rlt = (Rlt)event.getSelectedItem().getUserObject();
//							Window.alert("id="+rlt.getId());
							clientState.setCurrentRlt(rlt);
						}
					});
					add(tree, kat.getKurzBez());
				}
//				if (panel != null) {
//					final Label panelItem = new Label(rlt.getKurzBez());
//					final HTML panelItem = new HTML(rlt.getKurzBez());
//					panelItem.addClickHandler(new ClickHandler() {
//						public void onClick(ClickEvent event) {
//							// mainPane.showRlt(rlt);
//							Window.alert(panelItem.getText());
//						}
//					});
//					panel.add(panelItem);
//				}
				if (tree != null) {
					TreeItem item = new TreeItem(rlt.getKurzBez());
					item.setUserObject(rlt);
					tree.addItem(item);
				}
			}
		}
	}

	@Override
	public void onRltSelected(ClientState clientState) {
	}

}
