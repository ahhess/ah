/*
 * Copyright 2002-2008 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package bwbv.rlt.client.ui;

import bwbv.rlt.client.domain.Rlt;
import bwbv.rlt.client.localdata.RltLocalData;
import bwbv.rlt.client.service.ServiceRegistry;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;

/**
 * Menu on the left
 */
public class MenuPanel extends Composite {

	private Tree menuTree;
	private Rlt[] rlts;
	
	public MenuPanel(ServiceRegistry serviceRegistry, final MainPane mainPane) {

	    menuTree = new Tree() {
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
//				GWT.log(text,null);
				for (Rlt rlt : rlts) {
					if (rlt.getTurnierbez().equalsIgnoreCase(text)) {
//						GWT.log("gefunden!",null);
						mainPane.showRlt(rlt);
					}
				}
			}
		};
		menuTree.setAnimationEnabled(true);

//		menuTree.addItem("Screen 1");
//		menuTree.addItem("Screen 2");

		getRlts();
		Rlt.Kat kat = null;
		TreeItem katItem = null;
		for (Rlt rlt : rlts) {
			if (kat == null || !kat.equals(rlt.getRltkat())) {
				kat  = rlt.getRltkat();
				katItem = new TreeItem(new HTML(kat.toString()));
				katItem.setState(true);
				menuTree.addItem(katItem);
			}
			TreeItem rltItem = new TreeItem(new HTML(rlt.getTurnierbez()));
			katItem.addItem(rltItem);
		}

		DockPanel main = new DockPanel();
		main.add(menuTree, DockPanel.NORTH);
		initWidget(main);
	}

	private void getRlts() {
		rlts = RltLocalData.getRlts();
	}

}
