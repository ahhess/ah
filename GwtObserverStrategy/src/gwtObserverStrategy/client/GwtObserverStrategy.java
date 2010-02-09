package gwtObserverStrategy.client;

import gwtObserverStrategy.client.view.CalculatorWidget;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GwtObserverStrategy implements EntryPoint {

	public void onModuleLoad() {
		RootPanel.get("root").add(new CalculatorWidget());
		RootPanel.get("loading").setVisible(false);
	}
}
